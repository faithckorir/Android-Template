package com.ekenya.rnd.baseapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.ekenya.rnd.common.abstractions.BaseActivity;
import com.ekenya.rnd.baseapp.ui.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    private DemoApplication mApp;
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        mApp = (DemoApplication) getApplication();

        //
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
    private void setStatus(String label){
        //
    }
}