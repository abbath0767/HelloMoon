package com.rmr.ngusarov.hellomoon;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ActivityVideo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView mVideoView = (VideoView) findViewById(R.id.video_view);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);
        Uri path = Uri.parse("android.resource://" +
                "com.rmr.ngusarov.hellomoon/raw/apollo_17_stroll");
        mVideoView.setVideoURI(path);
        mVideoView.start();
    }
}
