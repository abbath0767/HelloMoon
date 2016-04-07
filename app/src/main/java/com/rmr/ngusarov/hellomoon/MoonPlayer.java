package com.rmr.ngusarov.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class MoonPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        Log.d(FragmentHelloMoon.TAG, "Player Audio Stop");
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context context) {
        if (mPlayer != null) {
            mPlayer.start();
            return;
        }
        mPlayer = MediaPlayer.create(context, R.raw.one_small_step);
        Log.d(FragmentHelloMoon.TAG, "Player Audio Start");

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }

    public void pause() {
        if (mPlayer != null) {
            Log.d(FragmentHelloMoon.TAG, "Player Audio Pause");
            mPlayer.pause();
        }
        return;
    }

    public boolean isPlay() {
        if (mPlayer == null)
            return false;
        return mPlayer.isPlaying();
    }
}
