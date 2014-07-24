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

import lombok.Data;
import lombok.ToString;
import net.boreeas.riotapi.rtmp.serialization.Serialization;

/**
 * Created on 7/19/2014.
 */
@Data
@ToString
@Serialization(name = "com.riotgames.platform.game.PlayerCredentialsDto")
public class PlayerCredentials {
    private String encryptionKey;
    private String observerEncryptionKey;
    private double gameId;
    private int lastSelectedSkinIndex;
    private String serverIp;
    private int serverPort;
    private boolean observer;
    private String observerServerIp;
    private int observerServerPort;
    private double summonerId;
    private String summonerName;
    private String handshakeToken;
    private double playerId;
    private int championId;
}
