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

package net.boreeas.riotapi.com.riotgames.platform.summoner;

import lombok.Data;
import lombok.ToString;
import net.boreeas.riotapi.com.riotgames.platform.summoner.spellbook.RuneSlot;
import net.boreeas.riotapi.rtmp.serialization.Serialization;

import java.util.List;
import java.util.ArrayList;

/**
 * Created on 7/19/2014.
 */
@Data
@ToString
@Serialization(name = "com.riotgames.platform.summoner.SummonerCatalog")
public class SummonerCatalog {
    // TODO inspect
    private Object items;
    private List<MasteryGroup> talentTree = new ArrayList<>();
    private List<RuneSlot> spellBookConfig = new ArrayList<>();
}
