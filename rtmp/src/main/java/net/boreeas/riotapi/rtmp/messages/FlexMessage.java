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

package net.boreeas.riotapi.rtmp.messages;/*
 * Copyright 2014 Malte Schütze
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import lombok.Getter;
import lombok.Setter;
import net.boreeas.riotapi.rtmp.serialization.AnonymousAmfObject;

import java.util.UUID;

/**
 * Created on 5/26/2014.
 */
@Getter
@Setter
public class FlexMessage {
    public static final String DEST_CLIENT_ID = "DSDstClientId";
    public static final String ENDPOINT = "DSEndpoint";
    public static final String REMOTE_CREDENTIALS = "DSRemoteCredentials";
    public static final String REQUEST_TIMEOUT = "DSRequestTimeout";
    public static final String LOCAL_CLIENT_ID = "DSId";


    private String clientId;
    private String destination;
    private String messageId = UUID.randomUUID().toString();
    private int timestamp;
    private int timeToLive;
    private Object body;
    //private Map<String, Object> headers = new HashMap<>();
    private AnonymousAmfObject headers = new AnonymousAmfObject();
}
