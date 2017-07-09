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

package com.smile.lifefuldemo.presenter;

import com.smile.lifeful.Lifeful;
import com.smile.lifeful.OnLoadLifefulListener;
import com.smile.lifeful.OnLoadListener;
import com.smile.lifefuldemo.contract.TaskContract;
import com.smile.lifefuldemo.model.TaskLoadModel;
import com.smile.lifefuldemo.model.impl.TaskModelImpl;

/**
 * @author Smile Wei
 * @since 2017/7/9.
 */

public class TaskPresenter implements TaskContract.Presenter {
    private TaskContract.View view;
    private TaskLoadModel loadModel;

    public void initView(TaskContract.View view) {
        loadModel = new TaskModelImpl();
        this.view = view;
        this.view.initView();
    }

    @Override
    public void lifeful(Lifeful lifeful) {
        view.loadingTask();
        loadModel.load(new OnLoadLifefulListener<>(new OnLoadListener<String>() {
            @Override
            public void onSuccess(String success) {
                view.showTask("OnLoadLifefulListener");
            }

            @Override
            public void onError(String error) {
                view.errorTask("OnLoadLifefulListener");
            }
        }, lifeful));

    }

    @Override
    public void notLifeful() {
        view.loadingTask();
        loadModel.load(new OnLoadListener<String>() {
            @Override
            public void onSuccess(String success) {
                view.showTask("OnLoadListener");
            }

            @Override
            public void onError(String error) {
                view.errorTask("OnLoadListener");
            }
        });
    }
}
