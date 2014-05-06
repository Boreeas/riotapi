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

package net.boreeas.riotapi.rtmp.p2.serialization;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created on 5/3/2014.
 */
public class Amf3LongSerializer implements AmfSerializer<Long> {
    @Override
    public void serialize(Long val, OutputStream out) throws IOException {
        out.write((int) (val >> 56));
        out.write((int) (val >> 48));
        out.write((int) (val >> 40));
        out.write((int) (val >> 32));
        out.write((int) (val >> 24));
        out.write((int) (val >> 16));
        out.write((int) (val >>  8));
        out.write((int) (long) val);
    }
}
