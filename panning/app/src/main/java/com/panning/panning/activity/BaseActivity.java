package com.panning.panning.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/4/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager supportFragmentManager;
    private boolean isActivityDestroyed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewID());
        supportFragmentManager = getSupportFragmentManager();
        checkIntent();
    }

    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, false, "");
    }

    public void replaceFragment(Fragment fragment, String tag) {
        replaceFragment(fragment, false, tag);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack, String tag) {
        if (fragment == null || fragment == getSupportFragmentManager().findFragmentById(R.id.container)) {
            return;
        }
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }

    public Fragment getFragment(String tag) {
        return supportFragmentManager.findFragmentByTag(tag);
    }

    public boolean isActivityDestroyed() {
        return isActivityDestroyed;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isActivityDestroyed = false;
    }

    public void startActivity(Class clazz) {
        startActivity(clazz, null);
    }

    public void startActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityAndClearStack(Class clazz) {
        Intent intent = new Intent(this, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void startActivityAndClearTop(Class clazz) {
        Intent intent = new Intent(this, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void checkIntent() {
        onIntentFetched(getIntent());
    }

    public void onIntentFetched(Intent intent) {

    }

    public abstract int getContentViewID();

    public static void showView(View v) {
        if (v != null)
            v.setVisibility(View.VISIBLE);
    }

    public static void hideView(View v) {
        if (v != null)
            v.setVisibility(View.INVISIBLE);
    }

    public static void goneView(View v) {
        if (v != null)
            v.setVisibility(View.GONE);
    }

    private MessageReceiver messageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.panning.panning";

    public void registerMessageReceiver() {
        messageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        registerReceiver(messageReceiver, filter);
    }
    
    public class MessageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
