package com.example.order.cglibdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.order.cglibdemo.test.Test;
import com.example.order.cglibdemo.test.Test2;
import com.mdit.library.proxy.CallbackFilter;
import com.mdit.library.proxy.NoOp;

import java.lang.reflect.Method;

import leo.android.cglib.proxy.Enhancer;
import leo.android.cglib.proxy.MethodInterceptor;
import leo.android.cglib.proxy.MethodProxy;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testEnhancer();
        testEnhancer2();
    }

    private void testEnhancer() {
        Enhancer enhancer = new Enhancer(this);
        enhancer.setSuperclass(Test.class);
        enhancer.setInterceptor(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Object[] objects, MethodProxy methodProxy) throws Exception {
                Log.e(TAG,"intercept  -- before---");
                Object o1 = methodProxy.invokeSuper(o, objects);
                Log.e(TAG,"intercept  -- after---");
                return o1;
            }
        });
        Test test = (Test) enhancer.create();
        test.test1();
        test.toString();
    }

    private void testEnhancer2() {

        com.mdit.library.proxy.Enhancer enhancer = new com.mdit.library.proxy.Enhancer(this);
        enhancer.setSuperclass(Test2.class);
        enhancer.setCallbacks(new com.mdit.library.proxy.MethodInterceptor[]{NoOp.INSTANCE, new com.mdit.library.proxy.MethodInterceptor() {

            @Override
            public Object intercept(Object object, Object[] args, com.mdit.library.proxy.MethodProxy methodProxy) throws Exception {
                Log.e(TAG,"intercept  -- before---");
                Object o1 = methodProxy.invokeSuper(object, args);
                Log.e(TAG,"intercept  -- after---");
                return o1;
            }
        }});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("test1"))
                return 1;
                else
                    return 0;
            }
        });
        Test2 test2 = (Test2) enhancer.create();
        test2.test1();
        test2.toString();
    }
}