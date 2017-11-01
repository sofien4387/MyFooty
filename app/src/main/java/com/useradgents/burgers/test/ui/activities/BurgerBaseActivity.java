package com.useradgents.burgers.test.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arellomobile.mvp.sample.github.R;
import com.useradgents.burgers.test.constants.BurgerConstants;
import com.useradgents.burgers.test.mvp.common.broadcasts.BurgerBroadCast;

public class BurgerBaseActivity extends AppCompatActivity {

    protected BurgerBroadCast mChangeConnectionReceiver;

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mChangeConnectionReceiver = new BurgerBroadCast();

        IntentFilter filter = new IntentFilter(BurgerConstants.CONNECTIVITY_CHANGE_ACTION);

        registerReceiver(mChangeConnectionReceiver, filter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        initToolBarViewConnectionChecker();

    }

    private void initToolBarViewConnectionChecker() {

        //View errorBarView = findViewById(R.id.toolbar_sub_error_bar);
        //mChangeConnectionReceiver.setConnectionToolBar(errorBarView);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mChangeConnectionReceiver != null) {
            this.unregisterReceiver(mChangeConnectionReceiver);
        }
    }

}