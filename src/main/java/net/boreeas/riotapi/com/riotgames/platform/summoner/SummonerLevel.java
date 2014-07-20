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

package net.boreeas.riotapi.com.riotgames.platform.summoner;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import net.boreeas.riotapi.rtmp.serialization.Serialization;
import net.boreeas.riotapi.rtmp.serialization.SerializedName;

/**
 * Created on 7/19/2014.
 */
@Getter
@ToString
@EqualsAndHashCode
@Serialization(name = "com.riotgames.platform.summoner.SummonerLevel")
public class SummonerLevel {
    private double expTierMod;
    private double infTierMod;
    private double grantRp;
    private double expForWin;
    private double expForLoss;
    private double summonerTier;
    private double expToNextLevel;
    @SerializedName(name = "summonerLevel")
    private double level;
}
