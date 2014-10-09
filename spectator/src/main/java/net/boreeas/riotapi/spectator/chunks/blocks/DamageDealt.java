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

package net.boreeas.riotapi.spectator.chunks.blocks;

import lombok.Value;
import lombok.extern.log4j.Log4j;
import net.boreeas.riotapi.spectator.chunks.Block;
import net.boreeas.riotapi.spectator.chunks.BlockHeader;
import net.boreeas.riotapi.spectator.chunks.BlockType;
import net.boreeas.riotapi.spectator.chunks.IsBlock;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Malte Schütze
 */
@Value
@Log4j
@IsBlock(BlockType.DAMAGE_DEALT)
public class DamageDealt extends Block {
    private int dmgType;
    private long receivingEntityId;
    private long sourceEntityId;
    private float damage;

    public DamageDealt(BlockHeader header, byte[] data) {
        super(header, data);

        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        this.dmgType = buffer.get() & 0xff;
        this.receivingEntityId = buffer.getInt() & 0xffffffffL;
        this.sourceEntityId = buffer.getInt() & 0xffffffffL;
        this.damage = buffer.getFloat();

        assertEndOfBuffer(buffer);
    }
}
