package com.panning.panning.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/4/4.
 */

public class VideoActivity extends AppCompatActivity {

    private VideoView panningVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        panningVideo = findViewById(R.id.panningVideo);
        Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        panningVideo.setVideoURI(uri);//为视频播放器设置视频路径
        panningVideo.setMediaController(new MediaController(this));//显示控制栏
        panningVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                panningVideo.start();//开始播放视频
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
