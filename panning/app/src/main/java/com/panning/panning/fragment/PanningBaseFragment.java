package com.panning.panning.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/4/4.
 */

public class PanningBaseFragment extends AppCompatDialogFragment {

    private TextView notice;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panning_base, container, false);
        notice = view.findViewById(R.id.notice);
        notice.setText("上淘金，淘到你人生第一桶金～       上淘金，淘到你人生第一桶金～");
        notice.setSelected(true);
        return view;
    }
}
