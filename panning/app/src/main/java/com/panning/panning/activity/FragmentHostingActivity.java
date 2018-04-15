package com.panning.panning.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.panning.panning.R;
import com.panning.panning.fragment.BaseFragment;
import com.panning.panning.fragment.FragmentRegister;

/**
 * Created by cloud_wang on 18/4/14.
 */

public class FragmentHostingActivity extends BaseActivity {

    public static final String ACTIVITY_INTENT_FLAG = "activity_intent_flag";
    private static final String NEED_SAVE_DATA = "need_save_data";
    private static final String FRAGMENT_CLASS_NAME = "fragment_class_name";
    private Bundle needSaveData;

    @Override
    public int getContentViewID() {
        return R.layout.activity_hosting;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle;
        if (savedInstanceState == null) {
            bundle = getIntent().getExtras();
        } else {
            bundle = savedInstanceState.getBundle(NEED_SAVE_DATA);
        }
        needSaveData = bundle;

        Fragment fragment = FragmentRegister.getFragment(bundle);
        if (fragment != null) {
            replaceFragment(fragment, FragmentRegister.getFragmentTag(bundle));
        } else {
            String fragmentClassName = bundle.getString(FRAGMENT_CLASS_NAME);
            try {
                fragment = (Fragment) Class.forName(fragmentClassName).newInstance();
                fragment.setArguments(bundle);
                replaceFragment(fragment, FragmentRegister.getFragmentTag(bundle));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBundle(NEED_SAVE_DATA, needSaveData);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment == null || !fragment.reallyWantToDoSomethingWhenBackPressed()) {
            super.onBackPressed();
        } else {
            fragment.onBackPressed();
        }
    }

    public static void startFragment(Context context, int fragmentID) {
        Bundle bundle = new Bundle();
        bundle.putInt(FragmentRegister.FRAGMENT_ID, fragmentID);
        startFragment(context, bundle);
    }

    public static void startFragment(Context context, int fragmentID, Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Bundle must not be null");
        }
        bundle.putInt(FragmentRegister.FRAGMENT_ID, fragmentID);
        startFragment(context, bundle);
    }

    public static void startFragment(Context context, Class<? extends Fragment> clazz) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_CLASS_NAME, clazz.getName());
        startFragment(context, bundle);
    }

    public static void startFragment(Context context, Class<? extends Fragment> clazz, Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Bundle must not be null");
        }
        bundle.putString(FRAGMENT_CLASS_NAME, clazz.getName());
        startFragment(context, bundle);
    }

    private static void startFragment(Context context, Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Bundle must not be null");
        }

        int ID = bundle.getInt(FragmentRegister.FRAGMENT_ID, 0);
        String name = bundle.getString(FRAGMENT_CLASS_NAME, null);
        if (ID == 0 && name == null) {
            throw new IllegalArgumentException("Fragment ID/name must has one");
        }

        int intentFlag = bundle.getInt(ACTIVITY_INTENT_FLAG, 0);

        Intent intent = new Intent(context, FragmentHostingActivity.class);
        intent.putExtras(bundle);
        if (intentFlag > 0)
            intent.setFlags(intentFlag);
        context.startActivity(intent);
    }
}
