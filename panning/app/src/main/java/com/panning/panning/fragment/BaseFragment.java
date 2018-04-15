package com.panning.panning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panning.panning.activity.BaseActivity;

/**
 * Created by cloud_wang on 18/4/15.
 */

public abstract class BaseFragment extends Fragment{
    private View rootView;
    private boolean wantToDoSomethingWhenBackPressed;
    private String httpTag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getFragmentLayoutID(), container, false);
        return rootView;
    }

    public View getRootView() {
        return rootView;
    }

    public String getHttpTag() {
        return httpTag;
    }

    /**
     * @return the layout resource of fragment layout
     */
    public abstract int getFragmentLayoutID();

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

    public void startActivity(Class clazz) {
        ((BaseActivity) getActivity()).startActivity(clazz);
    }

    public void startActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ((BaseActivity) getActivity()).startActivity(clazz, bundle);
    }

    public void startActivityAndClearStack(Class clazz) {
        ((BaseActivity) getActivity()).startActivityAndClearStack(clazz);
    }

    public void startActivityAndClearTop(Class clazz) {
        ((BaseActivity) getActivity()).startActivityAndClearTop(clazz);
    }

    public void finish() {
        if (getActivity() != null)
            getActivity().finish();
    }

    public void onBackPressed() {

    }

    public boolean reallyWantToDoSomethingWhenBackPressed() {
        return wantToDoSomethingWhenBackPressed;
    }

    public void setWantToDoSomethingWhenBackPressed(boolean wantToDoSomethingWhenBackPressed) {
        this.wantToDoSomethingWhenBackPressed = wantToDoSomethingWhenBackPressed;
    }

}
