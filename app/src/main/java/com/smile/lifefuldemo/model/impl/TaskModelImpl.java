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

package com.smile.lifefuldemo.model.impl;

import com.smile.lifeful.OnLoadLifefulListener;
import com.smile.lifeful.OnLoadListener;
import com.smile.lifefuldemo.model.TaskLoadModel;
import com.smile.okhttpintegration.OkCallback;
import com.smile.okhttpintegration.OkHttp;

/**
 * @author Smile Wei
 * @since 2017/7/9.
 */

public class TaskModelImpl implements TaskLoadModel {

    @Override
    public void load(final OnLoadListener<String> listener) {

        OkHttp.get("http://api.56kon.com/version/check", null, new OkCallback() {
            @Override
            public void onResponse(String response) {
                if (listener != null)
                    listener.onSuccess(response);
            }

            @Override
            public void onFailure(String error) {
                if (listener != null)
                    listener.onError(error);
            }
        });
    }

    @Override
    public void load(final OnLoadLifefulListener<String> listener) {
        OkHttp.get("http://api.56kon.com/version/check", null, new OkCallback() {
            @Override
            public void onResponse(String response) {
                if (listener != null)
                    listener.onSuccess(response);
            }

            @Override
            public void onFailure(String error) {
                if (listener != null)
                    listener.onError(error);
            }
        });
    }
}
