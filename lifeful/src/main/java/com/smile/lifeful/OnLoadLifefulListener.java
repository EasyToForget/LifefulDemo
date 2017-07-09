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

public class OnLoadLifefulListener<T> implements OnLoadListener<T> {

    private LifefulGenerator<OnLoadListener<T>> lifefulGenerator;

    public OnLoadLifefulListener(OnLoadListener<T> listener, Lifeful lifeful) {
        lifefulGenerator = new DefaultLifefulGenerator<>(listener, lifeful);
    }

    @Override
    public void onSuccess(T success) {
        if (LifefulUtil.destroy(lifefulGenerator))
            return;
        lifefulGenerator.getCallback().onSuccess(success);
    }

    @Override
    public void onError(String error) {
        if (LifefulUtil.destroy(lifefulGenerator))
            return;
        lifefulGenerator.getCallback().onError(error);
    }
}
