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

package net.boreeas.riotapi.rtmp.packets;

import lombok.Getter;
import net.boreeas.riotapi.rtmp.amf.AmfInputStream;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created on 4/19/2014.
 */
public class RtmpAbort extends RtmpPacket {
    public static final byte TYPE = 2;

    @Getter private int chunkId;

    public RtmpAbort(int chunkId) {
        super(FMT_FULL_HEADER);
        this.chunkId = chunkId;
    }

    @Override
    public byte getType() {
        return TYPE;
    }

    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void writeBody(OutputStream out) throws IOException {
        out.write(chunkId >> 24);
        out.write(chunkId >> 16);
        out.write(chunkId >> 8);
        out.write(chunkId);
    }

    public static RtmpAbort fromStream(AmfInputStream in) throws IOException {
        RtmpAbort abort = new RtmpAbort(0);
        abort.chunkId = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read();

        return abort;
    }
}
