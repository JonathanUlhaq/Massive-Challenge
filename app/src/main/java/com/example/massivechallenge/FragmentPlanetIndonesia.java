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
 * Use the {@link FragmentPlanetIndonesia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPlanetIndonesia extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPlanetIndonesia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPlanetIndonesia.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPlanetIndonesia newInstance(String param1, String param2) {
        FragmentPlanetIndonesia fragment = new FragmentPlanetIndonesia();
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
    AdapterPlanetIndonesia adapterPlanetIndonesia;
    ViewPager viewPager;
    int positioss;
    Timer timer;
    Handler handler;

    int[] suara = {
            R.raw.matahari,
            R.raw.bulan,
            R.raw.merkurius,
            R.raw.tata_indo_venus,
            R.raw.bumi,
            R.raw.tata_indo_mars,
            R.raw.jupiter,
            R.raw.tata_indo_saturnus2,
            R.raw.uranus,
            R.raw.neptunus
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_planet_indonesia, container, false);

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.splash);
        Animation shadowAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.unlimited_bouncing_shadow);
        Animation dissapear = AnimationUtils.loadAnimation(getContext(), R.anim.dissapear);


        ImageView auto = getActivity().findViewById(R.id.auto);
        auto.setVisibility(View.VISIBLE);

        LinearLayout frameLayout;
        frameLayout = getActivity().findViewById(R.id.frame_layout);

        adapterPlanetIndonesia = new AdapterPlanetIndonesia(getContext());
        viewPager = view.findViewById(R.id.view_puager);
        viewPager.setAdapter(adapterPlanetIndonesia);

        // MENDAPATKAN POSISI DARI VIEWPAGER
        Bundle bundle = getArguments();

        if (bundle != null)
        {
            int data = bundle.getInt("posisi2");
            viewPager.setCurrentItem(data);
            MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[data]);

            mediaPlayers.start();
            mediaPlayers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.reset();
                }
            });
        }

        if(bundle == null)
        {
            MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[viewPager.getCurrentItem()]);
            mediaPlayers.start();
            mediaPlayers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.reset();
                }
            });
        }

        MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),R.raw.click_sound_effect);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                positioss = position;
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

                        MediaPlayer mediaPlayers = MediaPlayer.create(getContext(),suara[position]);
                        Log.e("POSISIS",Integer.toString(position));
                        mediaPlayers.start();

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


                                                    viewPager.setCurrentItem(positioss);
                                                    positioss++;

                                                }
                                        if (viewPager.getCurrentItem() == suara.length -1)
                                        {
                                            int i = viewPager.getCurrentItem();
                                            viewPager.setCurrentItem(i);
                                        }
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

                                FragmentPlanetIndonesia indonesia = new FragmentPlanetIndonesia();
                                Bundle bundle = new Bundle();
                                bundle.putInt("posisi2",positioss);
                                indonesia.setArguments(bundle);
                                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,indonesia).commit();

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
                   mediaPlayers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                       @Override
                       public void onCompletion(MediaPlayer mediaPlayer) {
                           mediaPlayer.reset();
                       }
                   });
               }


                Log.e("POSISI",Integer.toString(viewPager.getCurrentItem()));

//                adapterAbjadIndonesia.instantiateItem(container,position);
                if(position == 19)
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

        ImageView bahasa_inggris,bahasa_indonesia,button_all;
        bahasa_indonesia = getActivity().findViewById(R.id.bahasa_indonesia);
        bahasa_inggris = getActivity().findViewById(R.id.bahasa_inggris);
        button_all = getActivity().findViewById(R.id.all);
        Animation backAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.splash);


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

                        Bundle bundle = new Bundle();
                        bundle.putInt("posisi",positioss);
                        Log.e("COBA POSISI",Integer.toString(positioss));
                        FragmentPlanetInggris fragmentPlanetInggris = new FragmentPlanetInggris();
                        fragmentPlanetInggris.setArguments(bundle);


                        if(getActivity() != null)
                        {
                            getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,fragmentPlanetInggris).commit();

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