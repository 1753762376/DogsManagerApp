package com.example.jack.dogsmaganerapp;


import android.os.Bundle;

/**
 * BackgroundLibrary使用方法：
 * 1.在super.onCreate方法之前调用
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
