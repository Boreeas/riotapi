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
import net.boreeas.riotapi.rtmp.RtmpClient;

/**
 * Created by malte on 7/15/2014.
 */
@AllArgsConstructor
public class AccountService {
    private static final String SERVICE = "accountService";
    private RtmpClient client;

    /**
     * Retrieve the account state for the current user
     * @return The account state
     */
    public String getAccountState() {
        return client.sendRpcAndWait(SERVICE, "getAccountStateForCurrentSession");
    }
}
