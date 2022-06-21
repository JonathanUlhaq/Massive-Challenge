package com.example.massivechallenge;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAllPerkakas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAllPerkakas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAllPerkakas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAllPerkakas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAllPerkakas newInstance(String param1, String param2) {
        FragmentAllPerkakas fragment = new FragmentAllPerkakas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_perkakas, container, false);

        ImageView bahasa_inggris,bahasa_indonesia,button_all;
        bahasa_indonesia = getActivity().findViewById(R.id.bahasa_indonesia);
        bahasa_inggris = getActivity().findViewById(R.id.bahasa_inggris);
        button_all = getActivity().findViewById(R.id.all);
        Animation backAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.splash);
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);

        bahasa_inggris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_inggris.startAnimation(backAnimation);
                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        bahasa_indonesia.setImageResource(R.drawable.button_indonesia_inactive);
                        bahasa_inggris.setImageResource(R.drawable.button_inggris_active);

                        button_all.setBackgroundResource(R.drawable.button_all);



                        FragmentPerkakasInggris fragmentPerkakasInggris = new FragmentPerkakasInggris();


                        if(getActivity() != null)
                        {
                            getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,fragmentPerkakasInggris).commit();

                        }

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {





                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });



            }
        });

        bahasa_indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_indonesia.startAnimation(backAnimation);
                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        bahasa_indonesia.setImageResource(R.drawable.button_indonesia_active);
                        bahasa_inggris.setImageResource(R.drawable.button_inggris_inactive);

                        button_all.setImageResource(R.drawable.button_all);


                        FragmentPerkakasIndonesia fragmentPerkakasIndonesia = new FragmentPerkakasIndonesia();

                        if(getActivity() != null)
                        {
                            getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,fragmentPerkakasIndonesia).commit();

                        }

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {



                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });



            }
        });

        return view;

    }
}