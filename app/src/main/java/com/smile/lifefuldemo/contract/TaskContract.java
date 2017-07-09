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

package com.smile.lifefuldemo.contract;

import com.smile.lifeful.Lifeful;

/**
 * @author Smile Wei
 * @since 2017/7/9.
 */

public interface TaskContract {

    interface View {
        void initView();

        void showTask(String res);

        void networkError();

        void showMsg(String msg);

        void loadingTask();

        void errorTask(String error);
    }

    interface Presenter {
        void lifeful(Lifeful lifeful);

        void notLifeful();
    }
}
