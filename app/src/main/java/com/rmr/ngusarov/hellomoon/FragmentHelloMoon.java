package com.rmr.ngusarov.hellomoon;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentHelloMoon extends Fragment {

    public static final String TAG = "mediaPlayerTag";

    private Button mPlayButton;
    private Button mStopButton;
    private MoonPlayer mMoonPlayer = new MoonPlayer();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayButton = (Button) v.findViewById(R.id.hello_moon_play_button);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoonPlayer.play(getActivity());
            }
        });

        mStopButton = (Button) v.findViewById(R.id.hello_moon_stop_button);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoonPlayer.stop();
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
