/*
 * Copyright 2015 The LolDevs team (https://github.com/loldevs)
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

package net.boreeas.riotapi.com.riotgames.team.dto;

import lombok.Data;
import net.boreeas.riotapi.com.riotgames.team.TeamInfo;
import net.boreeas.riotapi.rtmp.serialization.Serialization;

import java.util.ArrayList;

/**
 * @author Malte Schütze
 */
@Data
@Serialization(name = "com.riotgames.team.dto.PlayerDTO")
public class Player {
    private long playerId;
    private ArrayList<Team> teamsSummary = new ArrayList<>();
    private ArrayList<Team> createdTeams = new ArrayList<>();
    private ArrayList<TeamInfo> playerTeams = new ArrayList<>();
}
