package com.panning.panning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.panning.panning.R;
import com.panning.panning.view.PanningTopBar;

/**
 * Created by cloud_wang on 18/5/22.
 */

public class UserInfoAvtivity extends AppCompatActivity {

    private PanningTopBar topBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        topBar = findViewById(R.id.topBar);
        topBar.setOnLeftAndRightClickListener(new PanningTopBar.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftBtnClick() {
                finish();
            }

            @Override
            public void OnRightBtnClick() {
                startActivity(new Intent(UserInfoAvtivity.this, SettingActivity.class));
            }
        });
    }
}
