/*
 * Copyright (c) 2017 [zhiye.wei@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smile.lifeful;

import java.lang.ref.WeakReference;

/**
 * @author Smile Wei
 * @since 2017/7/9.
 */

public class DefaultLifefulGenerator<Callback> implements LifefulGenerator<Callback> {
    private WeakReference<Lifeful> weakReference;
    private boolean isLifefulNull;
    private Callback callback;

    DefaultLifefulGenerator(Callback callback, Lifeful lifeful) {
        this.callback = callback;
        weakReference = new WeakReference<>(lifeful);
        isLifefulNull = lifeful == null;
    }

    /**
     * @return callback
     */
    @Override
    public Callback getCallback() {
        return callback;
    }

    /**
     * @return weak reference
     */
    @Override
    public WeakReference<Lifeful> getLifefulWeakReference() {
        return weakReference;
    }

    /**
     * Returns true if the lifeful is null.
     *
     * @return true if str is null, else false
     */
    @Override
    public boolean isLifefulNull() {
        return isLifefulNull;
    }
}
