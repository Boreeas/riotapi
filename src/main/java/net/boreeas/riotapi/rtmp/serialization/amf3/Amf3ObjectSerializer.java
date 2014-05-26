/*
 * Copyright 2014 Malte Schütze
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.boreeas.riotapi.rtmp.p2.serialization.amf3;

import lombok.Setter;
import lombok.SneakyThrows;
import net.boreeas.riotapi.rtmp.amf.TraitDefinition;
import net.boreeas.riotapi.rtmp.p2.serialization.AmfSerializer;
import net.boreeas.riotapi.rtmp.p2.serialization.AmfWriter;
import net.boreeas.riotapi.rtmp.p2.serialization.SerializationContext;

import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 5/5/2014.
 */
public class Amf3ObjectSerializer implements AmfSerializer {

    @Setter protected Map<TraitDefinition, Integer> traitRefTable;
    @Setter protected AmfWriter writer;
    @Setter SerializationContext context;

    @Override
    @SneakyThrows({NoSuchFieldException.class, IllegalAccessException.class})
    public void serialize(Object o, DataOutputStream out) throws IOException {

        TraitDefinition def = new TraitDefinition(context.traitName(), context.externalizable(), context.dynamic());

        if (traitRefTable.containsKey(def)) {
            serializeTraitRef(traitRefTable.get(def));
            // Reassign trait definition to the one we used before
            final TraitDefinition def_ = def;
            def = traitRefTable.entrySet().stream().filter((entry) -> entry.getKey().equals(def_)).findFirst().get().getKey();
        } else {
            serializeTraitDef(def, o);
        }

        if (def.isExternalizable()) {
            if (o instanceof Externalizable) {
                ((Externalizable) o).writeExternal(new ObjectOutputStream(out));
                return;
            } else {
                throw new IllegalArgumentException("Can't serialize externalizable object that doesn't implement externalizable");
            }
        }

        serializeStaticMembers(o, def.getMembers());

        if (def.isDynamic()) {
            if (o instanceof DynamicObject) {
                serializeDynamicMembers(((DynamicObject) o).getDynamicMembers());
            } else {
                throw new IllegalArgumentException("Can't serialize dynamic object that doesn't implement DynamicObject");
            }
        }
    }

    protected void serializeStaticMembers(Object o, List<String> members) throws NoSuchFieldException, IOException, IllegalAccessException {
        for (String name: members) {
            Field f = o.getClass().getDeclaredField(name);
            f.setAccessible(true);
            writer.encodeAmf3(f.get(o));
        }
        writer.encodeAmf3("");
    }

    protected void serializeDynamicMembers(Map<String, Object> kvPairs) throws IOException {
        for (Map.Entry<String, Object> entries: kvPairs.entrySet()) {
            writer.serializeAmf3(entries.getKey());
            writer.encodeAmf3(entries.getValue());
        }
        writer.serializeAmf3("");
    }

    protected void serializeTraitDefHeader(TraitDefinition def) throws IOException {


        int header = def.getMembers().size();
        header = (header << 1) | (def.isDynamic() ? 1 : 0);
        header = (header << 1) | (def.isExternalizable() ? 1 : 0);
        header = (header << 1) | 1; // TraitDefInline
        writer.serializeAmf3((header << 1) | 1);

        writer.serializeAmf3(def.getType());
        for (String name: def.getMembers()) {
            writer.serializeAmf3(name);
        }
    }

    private void serializeTraitDef(TraitDefinition def, Object o) throws IOException {
        traitRefTable.put(def, traitRefTable.size());

        if (context.members().length == 0) {
            Set<String> excludes = new HashSet<>();
            for (String s: context.excludes()) {excludes.add(s);}

            for (Field f: o.getClass().getDeclaredFields()) {
                if (!excludes.contains(f.getName()) && !Modifier.isFinal(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) {
                    def.addMember(f.getName());
                }
            }
        }

        serializeTraitDefHeader(def);
    }

    protected void serializeTraitRef(int idx) throws IOException {
        writer.serializeAmf3(idx << 2 | 1);
    }
}
