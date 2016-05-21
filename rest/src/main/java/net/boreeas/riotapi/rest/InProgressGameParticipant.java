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

package net.boreeas.riotapi.rest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Malte Schütze
 */
@Data
public class InProgressGameParticipant {
    private boolean bot;
    private long championId;
    private List<Mastery> masteries = new ArrayList<>();
    private long profileIconId;
    private List<Rune> runes = new ArrayList<>();
    private long spell1Id;
    private long spell2Id;
    private long summonerId;
    private String summonerName;
    private long teamId;

    @Data
    public class Mastery {
        private int masteryId;
        private int rank;
    }

    @Data
    public class Rune {
        private int count;
        private long runeId;
    }
}
