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

/**
 * @author Smile Wei
 * @since 2017/7/9.
 */

public class LifefulUtil {

    /**
     * Check to see whether the Activity/Fragment is destroyed.
     *
     * @param lifefulGenerator lifeful
     * @param <T>              T
     * @return true if
     * 1. lifefulGenerator is null
     * 2. callback is null
     * 3. weakReference is null
     * 4. lifeful which bind with weakReference is null and the lifeful which is passed is not null
     * 5. lifeful which bind with weakReference is not null and lifeful which is passed is not alive.
     * <p>
     * else return false
     */
    public static <T> boolean destroy(LifefulGenerator<T> lifefulGenerator) {
        if (lifefulGenerator == null)
            return true;

        if (lifefulGenerator.getCallback() == null)
            return true;

        if (lifefulGenerator.getLifefulWeakReference() == null)
            return true;

        Lifeful lifeful = lifefulGenerator.getLifefulWeakReference().get();

        return lifeful == null && !lifefulGenerator.isLifefulNull() || lifeful != null && !lifeful.isAlive();

    }
}
