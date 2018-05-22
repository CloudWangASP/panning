package com.panning.panning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/5/22.
 */

public class UserInfoAvtivity extends AppCompatActivity {

    private TextView setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        setting = findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserInfoAvtivity.this, SettingActivity.class));
            }
        });
    }
}
