package com.rmr.ngusarov.hellomoon;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentHelloMoon extends Fragment {

    public static final String TAG = "mediaPlayerTag";

    private Button mPlayButton;
    private Button mStopButton;
    private Button mPlayVideoButton;
    private MoonPlayer mMoonPlayer = new MoonPlayer();
    private String flag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        flag = getResources().getString(R.string.hellomoon_play);

        mPlayButton = (Button) v.findViewById(R.id.hello_moon_play_button);
        if (mMoonPlayer.isPlay())
            mPlayButton.setText(R.string.hellomoon_pause);
        mPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //todo need debug
                if (mPlayButton.getText().equals(flag)) {
                    mMoonPlayer.play(getActivity());
                    mPlayButton.setText(R.string.hellomoon_pause);
                } else {
                    mMoonPlayer.pause();
                    mPlayButton.setText(R.string.hellomoon_play);
                }
            }
        });

        mStopButton = (Button) v.findViewById(R.id.hello_moon_stop_button);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoonPlayer.stop();
                mPlayButton.setText(R.string.hellomoon_play);
            }
        });

        mPlayVideoButton = (Button) v.findViewById(R.id.hello_moon_play_video_button);
        mPlayVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ActivityVideo.class);
                startActivity(i);
            }
        });

        return v;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mMoonPlayer.stop();
    }
}
