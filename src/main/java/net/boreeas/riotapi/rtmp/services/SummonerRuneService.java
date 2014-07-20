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

package net.boreeas.riotapi.rtmp.services;

import lombok.AllArgsConstructor;
import net.boreeas.riotapi.com.riotgames.platform.summoner.runes.SummonerRuneInventory;
import net.boreeas.riotapi.rtmp.RtmpClient;

/**
 * Created by malte on 7/16/2014.
 */
@AllArgsConstructor
public class SummonerRuneService {
    public static final String SERVICE = "summonerRuneService";
    private RtmpClient client;

    public SummonerRuneInventory getSummonerRuneInventory(double summonerId) {
        return client.sendRpcAndWait(SERVICE, "getSummonerRuneInventory", summonerId);
    }

    // TODO inspect
    public Object getSummonerRunes(double summonerId) {
        return client.sendRpcAndWait(SERVICE, "getSummonerRunes", summonerId);
    }
}
