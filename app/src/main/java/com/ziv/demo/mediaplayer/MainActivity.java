package com.ziv.demo.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private String playUrl = "http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoPath(playUrl);
        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
    }
}
