package com.rmr.ngusarov.hellomoon;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class FragmentVideo extends Fragment{

    private MediaController mController;
    private VideoView mVideoView;
    private Button mPlayButton;
    private VideoView videoView;

    public FragmentVideo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_video, container, false);

        videoView = (VideoView) v.findViewById(R.id.video_view);

        videoView.setMediaController(new MediaController(getActivity()));

        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int height = dm.heightPixels;
//        int width = dm.widthPixels;

        String videoSource = "android.resource://com.rmr.ngusarov.hellomoon/" + R.raw.apollo_17_stroll;
        videoView.setVideoURI(Uri.parse(videoSource));
//        mVideoView.setMinimumHeight(height);
//        mVideoView.setMinimumWidth(width);


        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
            }
        });

        return v;
    }

}
