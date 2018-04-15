package com.panning.panning.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Switch;

/**
 * Created by cloud_wang on 18/4/15.
 */

public class FragmentRegister {

    public static final String FRAGMENT_ID = "fragment_id";
    public static final int TEST_FRAGMENT = 0;

    public static final String TEST = "test";

    public static Fragment getFragment(Bundle bundle) {
        int fragmentID = bundle.getInt(FRAGMENT_ID);
        Fragment f = getFragment(fragmentID);
        if (f != null)
            f.setArguments(bundle);
        return f;
    }

    private static Fragment getFragment(int fragmentID) {
        switch (fragmentID) {
            case TEST_FRAGMENT:
                return new Fragment();
            default:
                return null;
        }
    }

    public static String getFragmentTag(Bundle bundle) {
        int fragmentID = bundle.getInt(FRAGMENT_ID);
        String tag = TEST;
        switch (fragmentID) {
            case TEST_FRAGMENT:
                break;
        }
        return tag;
    }
}
