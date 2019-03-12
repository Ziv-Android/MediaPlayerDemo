package com.ziv.demo.mediaplayer.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.ziv.demo.mediaplayer.R;
import com.ziv.demo.mediaplayer.utils.LogUtil;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    private static final String TAG = "MediaPlayerActivity";
    private String playUrl = "http://www.flashls.org/playlists/test_001/stream_1000k_48k_640x360.m3u8";
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        SurfaceView surfaceView = findViewById(R.id.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(this);

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(playUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                LogUtil.d(TAG, "MediaPlayer Prepared, start play.");
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Surface surface = holder.getSurface();
        mediaPlayer.setSurface(surface);
        mediaPlayer.prepareAsync();
        LogUtil.d(TAG, "SurfaceCreated()");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        LogUtil.d(TAG, "SurfaceChanged()");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        LogUtil.d(TAG, "SurfaceDestroyed()");
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
