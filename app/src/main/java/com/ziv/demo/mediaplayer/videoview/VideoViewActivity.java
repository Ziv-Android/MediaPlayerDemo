package com.ziv.demo.mediaplayer.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.ziv.demo.mediaplayer.R;

public class VideoViewActivity extends AppCompatActivity {
    private String playUrl = "http://www.flashls.org/playlists/test_001/stream_1000k_48k_640x360.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoPath(playUrl);
        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
    }
}
