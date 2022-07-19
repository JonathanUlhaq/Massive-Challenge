package com.example.massivechallenge;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBuahEng#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBuahEng extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentBuahEng() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBuahEng.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBuahEng newInstance(String param1, String param2) {
        FragmentBuahEng fragment = new FragmentBuahEng();
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

    ImageView next,previous,back,button_all,bahasa_inggris,bahasa_indonesia;
    AdapterBuahEng adapterBuahEng;
    ViewPager viewPager;
    int posisiss;
    Timer timer;
    Handler handler;

    int[] suara = {
            R.raw.buah_inggris_avocado,
            R.raw.buah_inggris_grape,
            R.raw.buah_inggris_strawberry,
            R.raw.buah_inggris_star_fruit,
            R.raw.buah_inggris_dragon_fruit,
            R.raw.buah_inggris_cherry,
            R.raw.buah_inggris_pomagrenate,
            R.raw.buah_inggris_durian,
            R.raw.buah_inggris_guava,
            R.raw.buah_inggris_lime,
            R.raw.buah_inggris_orange,
            R.raw.buah_inggris_coconut,
            R.raw.buah_inggris_kiwi,
            R.raw.buah_inggris_lemon,
            R.raw.buah_inggris_manggo,
            R.raw.buah_inggris_pineapple,
            R.raw.buah_inggris_papaya,
            R.raw.buah_inggris_banana,
            R.raw.buah_inggris_rambutan,
            R.raw.buah_inggris_watermelon,


    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buah_eng, container, false);

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.splash);
        Animation shadowAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.unlimited_bouncing_shadow);
        Animation dissapear = AnimationUtils.loadAnimation(getContext(), R.anim.dissapear);

        ImageView auto = getActivity().findViewById(R.id.auto);
        auto.setVisibility(View.VISIBLE);

        LinearLayout frameLayout;
        frameLayout = getActivity().findViewById(R.id.frame_layout);

        adapterBuahEng = new AdapterBuahEng(getContext());
        viewPager = view.findViewById(R.id.view_puager);
        viewPager.setAdapter(adapterBuahEng);

        back = getActivity().findViewById(R.id.back);
        button_all = getActivity().findViewById(R.id.all);
        bahasa_inggris = getActivity().findViewById(R.id.bahasa_inggris);
        bahasa_indonesia = getActivity().findViewById(R.id.bahasa_indonesia);

        // MENDAPATKAN POSISI DARI VIEWPAGER
        Bundle bundle = getArguments();
        ImageView button_all;
        button_all = getActivity().findViewById(R.id.all);
        button_all.setImageResource(R.drawable.button_all);

        if (bundle != null)
        {
            int data = bundle.getInt("posisi");
            viewPager.setCurrentItem(data);

            MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[data]);
            mediaPlayers.start();
        }

        if(bundle == null)
        {
            MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[viewPager.getCurrentItem()]);
            mediaPlayers.start();
        }

        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                posisiss = position ;
                timer = new Timer();
                handler = new Handler();

                ImageView cancel = getActivity().findViewById(R.id.auto2);

                auto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();


                            }
                        });


                        auto.startAnimation(animation);

                        //MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[position]);
                        Log.e("POSISIS",Integer.toString(position));
                        // mediaPlayers.start();

                        back.setEnabled(false);
                        bahasa_inggris.setEnabled(false);
                        bahasa_indonesia.setEnabled(false);
                        next.setEnabled(false);
                        button_all.setEnabled(false);
                        previous.setEnabled(false);

                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {

                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {

                                                if (bundle != null)
                                                {
//                                                int datas = bundle.getInt("posisi2");


                                                    viewPager.setCurrentItem(posisiss);
                                                    posisiss++;

                                                }
//                                        if (viewPager.getCurrentItem() == suara.length -1)
//                                        {
//                                            int i = viewPager.getCurrentItem();
//                                            viewPager.setCurrentItem(i);
//                                        }
                                                else {
                                                    int i = viewPager.getCurrentItem();
                                                    i++;
                                                    viewPager.setCurrentItem(i);
                                                }

                                            }
                                        });


                                    }


                                } ,4000,4000);


                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                                auto.setVisibility(View.GONE);
                                cancel.setVisibility(View.VISIBLE);

                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                    }



                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        cancel.startAnimation(animation);

                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);
                                mediaPlayer.start();
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayer.reset();


                                    }
                                });

                                back.setEnabled(true);
                                bahasa_inggris.setEnabled(true);
                                bahasa_indonesia.setEnabled(true);
                                next.setEnabled(true);
                                button_all.setEnabled(true);
                                previous.setEnabled(true);

                                FragmentBuahEng inggris = new FragmentBuahEng();
                                Bundle bundle = new Bundle();
                                bundle.putInt("posisi",posisiss);
                                inggris.setArguments(bundle);
                                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,inggris).commit();

                                auto.setVisibility(View.VISIBLE);
                                cancel.setVisibility(View.GONE);

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


            }

            @Override
            public void onPageSelected(int position) {
                //  frameLayout.setBackgroundResource(background.get(position));

                //                ON KETIKA ADA SUARA

                if(getContext() != null)
                {
                    MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[position]);
                    Log.e("POSISIS",Integer.toString(position));
                    mediaPlayers.start();
                }


                Log.e("POSISI",Integer.toString(viewPager.getCurrentItem()));

//                adapterAbjadIndonesia.instantiateItem(container,position);
                if(position == 18)
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
        next.setBackgroundResource(R.drawable.button_right_buah);
        previous = view.findViewById(R.id.previus);
        previous.setBackgroundResource(R.drawable.button_left_buah);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });

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
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });

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

        ImageView bahasa_inggris,bahasa_indonesia;
        bahasa_indonesia = getActivity().findViewById(R.id.bahasa_indonesia);
        bahasa_inggris = getActivity().findViewById(R.id.bahasa_inggris);

        Animation backAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.splash);


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
                        Bundle bundle = new Bundle();
                        bundle.putInt("posisi2",viewPager.getCurrentItem());

                        FragmentBuahIndo fragmentBuahIndo = new FragmentBuahIndo();
                        fragmentBuahIndo.setArguments(bundle);

                        if(getActivity() != null)
                        {
                            getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,fragmentBuahIndo).commit();

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

        return  view;

    }
}