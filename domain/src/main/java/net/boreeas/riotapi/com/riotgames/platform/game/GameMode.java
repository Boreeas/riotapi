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

package net.boreeas.riotapi.com.riotgames.platform.game;

import net.boreeas.riotapi.rtmp.serialization.Serialization;

/**
 * Created on 4/12/2014.
 */
@Serialization(name = "com.riotgames.platform.game.GameMode")
public enum GameMode {
    CLASSIC,
    ODIN,
    ARAM,
    TUTORIAL,
    ONEFORALL,
    ASCENSION,
    FIRSTBLOOD;

    public static GameMode getByName(String name) {
        for (GameMode mode: values()) {
            if (mode.name().equals(name)) {
                return mode;
            }
        }

        return null;
    }
}
