package com.example.massivechallenge;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAngkaIndo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAngkaIndo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentAngkaIndo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAngkaIndo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAngkaIndo newInstance(String param1, String param2) {
        FragmentAngkaIndo fragment = new FragmentAngkaIndo();
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

    ImageView next,previous;
    AdapterAngkaIndonesia adapterAngkaIndonesia;
    ViewPager viewPager;

    int[] suara = {
            R.raw.satu,
            R.raw.dua,
            R.raw.tiga,
            R.raw.empat,
            R.raw.lima,
            R.raw.enam,
            R.raw.tujuh,
            R.raw.delapan,
            R.raw.sembilan,
            R.raw.sepuluh,


    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_angka_indo, container, false);

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.splash);
        Animation shadowAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.unlimited_bouncing_shadow);
        Animation dissapear = AnimationUtils.loadAnimation(getContext(), R.anim.dissapear);

        ArrayList<Integer> background = new ArrayList<Integer>();

        for (int i =1; i<=26;i++)
        {
            background.add(getResources().getIdentifier("bg_angka_"+i,"drawable","com.example.massivechallenge"));
        }

        LinearLayout frameLayout;
        frameLayout = getActivity().findViewById(R.id.frame_layout);


        adapterAngkaIndonesia = new AdapterAngkaIndonesia(getContext());
        viewPager = view.findViewById(R.id.view_puager);
        viewPager.setAdapter(adapterAngkaIndonesia);



        // MENDAPATKAN POSISI DARI VIEWPAGER
        Bundle bundle = getArguments();

        if (bundle != null)
        {
            int data = bundle.getInt("posisi2");
            viewPager.setCurrentItem(data);
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),suara[data]);
            Log.e("POSISIS",Integer.toString(data));
            mediaPlayer.start();
        } if(bundle == null)
        {
            MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[viewPager.getCurrentItem()]);
            mediaPlayers.start();
        }

        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
           frameLayout.setBackgroundResource(background.get(position));

                Log.e("POSISI",Integer.toString(viewPager.getCurrentItem()));

                MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[position]);
                Log.e("POSISIS",Integer.toString(position));
                mediaPlayers.start();

                ImageView bahasa_inggris,bahasa_indonesia;
                bahasa_indonesia = getActivity().findViewById(R.id.bahasa_indonesia);
                bahasa_inggris = getActivity().findViewById(R.id.bahasa_inggris);
                Animation backAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.splash);


                bahasa_inggris.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        bahasa_inggris.startAnimation(backAnimation);
                        backAnimation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                                mediaPlayer.start();

                                bahasa_indonesia.setImageResource(R.drawable.button_indonesia_inactive);
                                bahasa_inggris.setImageResource(R.drawable.button_inggris_active);

                                Bundle bundle = new Bundle();
                                bundle.putInt("posisi",viewPager.getCurrentItem());

                                FragmentAngkaEng fragmentAngkaEng = new FragmentAngkaEng();
                                fragmentAngkaEng.setArguments(bundle);

                                if(getActivity() != null)
                                {
                                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,fragmentAngkaEng).commit();

                                }


                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                                Fragment fragment = new BahasaInggris();



                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });



                    }
                });

//                adapterAbjadIndonesia.instantiateItem(container,position);
                if(position == 9)
                {
                    next.startAnimation(dissapear);
                    dissapear.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            next.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                } else {
                    next.setVisibility(View.VISIBLE);
                }

                if(position == 0)
                {
                    previous.startAnimation(dissapear);
                    dissapear.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            previous.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                } else {
                    previous.setVisibility(View.VISIBLE);
                }



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        next = view.findViewById(R.id.next);
        previous = view.findViewById(R.id.previus);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() -1,true);
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() +1,true);
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