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

package net.boreeas.riotapi.com.riotgames.platform.gameinvite.contract;

import lombok.Data;
import net.boreeas.riotapi.com.riotgames.platform.game.GameMode;
import net.boreeas.riotapi.com.riotgames.platform.game.GameType;
import net.boreeas.riotapi.constants.BotDifficulty;

/**
 * @author Malte Schütze
 */
@Data
public class InvitationGameMetaData {
    private int queueId;
    private boolean isRanked;
    private String rankedTeamName;
    private String rankedTeamId;
    private BotDifficulty botDifficulty;
    private int mapId;
    private int gameTypeConfigId;
    private GameMode gameMode;
    private GameType gameType;
}
