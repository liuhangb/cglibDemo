package com.example.order.cglibdemo.test;

import android.util.Log;

/**
 * Created by lh, 2020/12/4
 */
public class Test2 {
    private final String TAG = "Test";

    public void test1() {
        Log.d(TAG, "test1======");
    }

    @Override
    public String toString() {
        return "Test{" +
                "TAG='" + TAG + '\'' +
                '}';
    }
}
