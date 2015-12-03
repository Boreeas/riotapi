/*
 * Copyright 2014 The LolDevs team (https://github.com/loldevs)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.boreeas.riotapi.com.riotgames.platform.broadcast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;
import lombok.ToString;
import net.boreeas.riotapi.rtmp.serialization.Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created on 7/19/2014.
 */
@Data
@ToString
@Serialization(name = "com.riotgames.platform.broadcast.BroadcastNotification", externalizable = true)
public class BroadcastNotification implements Externalizable {
    // TODO inspect
    private JsonObject json;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        String asString = json.toString();
        out.writeInt(asString.length());
        out.write(asString.getBytes("UTF-8"));
    }

    public void readExternal(ObjectInput in) throws IOException {
        byte[] buffer = new byte[in.readInt()];
        int i = 0;
        while (i < buffer.length - 1) {
            i += in.read(buffer, i, buffer.length - i);
        }
        String json = new String(buffer, "UTF-8");
        JsonElement elem = new JsonParser().parse(json);
        this.json = elem == null || elem.isJsonNull() ? null : elem.getAsJsonObject();
    }
}
