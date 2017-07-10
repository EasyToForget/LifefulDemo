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

package com.smile.lifefuldemo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.smile.lifeful.Lifeful;
import com.smile.lifefuldemo.contract.TaskContract;
import com.smile.lifefuldemo.presenter.TaskPresenter;

public class SecondActivity extends AppCompatActivity implements TaskContract.View, Lifeful {
    private Activity activity;

    private TaskPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        activity = this;
        presenter = new TaskPresenter();
        presenter.initView(this);
    }

    @Override
    public void initView() {
        findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.lifeful(SecondActivity.this);
            }
        });

        findViewById(R.id.btn_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.notLifeful();
            }
        });
    }

    @Override
    public void showTask(String res) {
        Log.e("showTask", res);
    }

    @Override
    public void networkError() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void loadingTask() {

    }

    @Override
    public void errorTask(String error) {
        Log.e("errorTask", error);
    }

    @Override
    public boolean isAlive() {
        if (activity == null)
            return false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return !(activity.isDestroyed() || activity.isFinishing());
        }
        return !activity.isFinishing();
    }
}
