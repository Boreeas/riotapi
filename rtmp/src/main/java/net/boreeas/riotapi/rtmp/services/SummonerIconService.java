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
import net.boreeas.riotapi.com.riotgames.platform.summoner.icon.SummonerIconInventory;
import net.boreeas.riotapi.rtmp.RtmpClient;

/**
 * Created by malte on 7/18/2014.
 */
@AllArgsConstructor
public class SummonerIconService {
    private static final String SERVICE = "summonerIconService";
    private RtmpClient client;

    public SummonerIconInventory getSummonerIconInventory(double summonerId) {
        return client.sendRpcAndWait(SERVICE, "getSummonerIconInventory", summonerId);
    }


}
