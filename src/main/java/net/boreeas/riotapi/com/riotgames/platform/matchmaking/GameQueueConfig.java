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

package net.boreeas.riotapi.com.riotgames.platform.matchmaking;

import lombok.Data;
import net.boreeas.riotapi.rtmp.serialization.Serialization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 7/19/2014.
 */
@Data
@Serialization(name = "com.riotgames.platform.matchmaking.GameQueueConfig")
public class GameQueueConfig {
    private int blockedMinutesThreshold;
    private int minimumParticipantListSize;
    private boolean ranked;
    private int maxLevel;
    private int minLevel;
    private int gameTypeConfigId;
    private boolean thresholdEnabled;
    private String queueState;
    private String type;
    private String cacheName;
    private double id;
    private String queueBonusKey;
    private String queueStateString;
    private String pointsConfigKey;
    private boolean teamOnly;
    private int minimumQueueDodgeDelayTime;
    private List<Integer> supportedMapIds = new ArrayList<>();
    private String gameMode;
    private String typeString;
    private int numPlayersPerTeam;
    private int maximumParticipantListSize;
    private boolean disallowFreeChampions;
    private String mapSelectionAlgorithm;
    private double thresholdSize;
    private MatchingThrottleConfig matchingThrottleConfig;
}
