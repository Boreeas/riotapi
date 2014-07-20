/*
 * Copyright 2014 Malte Schütze
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

package net.boreeas.riotapi.rtmp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.boreeas.riotapi.rtmp.serialization.AmfWriter;

import java.io.IOException;

/**
 * Created on 4/25/2014.
 */
@Getter
@ToString
public abstract class RtmpEvent {
    private RtmpHeader header;
    private MessageType type;
    @Setter private int timeStamp;

    public RtmpEvent(MessageType type) {
        this.type = type;
    }

    public RtmpEvent(MessageType type, int timeStamp) {
        this.type = type;
        this.timeStamp = timeStamp;
    }

    public void setHeader(RtmpHeader header) {
        this.header = header;
        this.timeStamp = header.getTimestamp();
    }

    public abstract void writeBody(AmfWriter writer) throws IOException;
}
