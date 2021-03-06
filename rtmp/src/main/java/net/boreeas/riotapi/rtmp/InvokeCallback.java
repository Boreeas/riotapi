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

package net.boreeas.riotapi.rtmp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created on 6/2/2014.
 */
public class InvokeCallback {
    private CountDownLatch latch = new CountDownLatch(1);
    private volatile Object result;

    public Object waitForReply() throws InterruptedException {
        latch.await();
        return result;
    }

    public Object waitForReply(long timeout, TimeUnit unit) throws InterruptedException, IllegalStateException {
        latch.await(timeout, unit);
        if (result == null) {
            throw new IllegalStateException("Wait timed out, but result did not arrive");
        }
        return result;
    }

    public void release(Object result) {
        this.result = result;
        latch.countDown();
    }
}
