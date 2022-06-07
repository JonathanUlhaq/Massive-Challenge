package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class DashboardBelajar extends AppCompatActivity {

    FrameLayout huruf, angka, menulis, transportasi, perkakas, profesi, hewan, sayur, buah, bentuk, warna, tata_surya;

import android.widget.ImageView;

public class DashboardBelajar extends AppCompatActivity {

    ImageView home;
    FrameLayout transportasi,bentuk,perkakas,tata_surya,warna,profesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_dashboard_belajar);

        huruf = findViewById(R.id.huruf);
        angka = findViewById(R.id.angka);
        menulis = findViewById(R.id.menulis);
        transportasi = findViewById(R.id.transportasi);
        perkakas = findViewById(R.id.perkakas);
        profesi = findViewById(R.id.profesi);
        hewan= findViewById(R.id.hewan);
        sayur = findViewById(R.id.sayur);
        buah = findViewById(R.id.buah);
        bentuk = findViewById(R.id.bentuk);
        warna = findViewById(R.id.warna);
        tata_surya = findViewById(R.id.tata_surya);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bouncing);



        huruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                huruf.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash);
        Animation itemAnimation = AnimationUtils.loadAnimation(this,R.anim.bouncing);

        home = findViewById(R.id.homes);
        transportasi = findViewById(R.id.transportasi);
        bentuk = findViewById(R.id.bentuk);
        perkakas = findViewById(R.id.perkakas);
        tata_surya = findViewById(R.id.tata_surya);
        warna = findViewById(R.id.warna);
        profesi = findViewById(R.id.profesi);


//        Warna

        warna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                warna.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarHuruf.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        angka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                angka.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarAngka.class);

                        startActivity(intent);
                    }

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarWarna.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        menulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                menulis.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarMenulis.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        transportasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transportasi.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

            }
        });

//        End Warna

//        Tata Surya

        tata_surya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tata_surya.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarTransportasi.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        perkakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                perkakas.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarTataSurya.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarPerkakas.class);

                        startActivity(intent);
                    }

                    @Override

                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


            }
        });

//        End Tata Surya

//        Profesi

        profesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                profesi.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                profesi.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarProfesi.class);

                        startActivity(intent);


                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarProfesi.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        hewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hewan.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarHewan.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        sayur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sayur.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


            }
        });

//        End Profesi


//        Transportasi

        transportasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transportasi.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarSayur.class);

                        startActivity(intent);

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarTransportasi.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        buah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buah.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


            }
        });

//        End Transportasi

//        Perkakas

        perkakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perkakas.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarBuah.class);

                        startActivity(intent);


                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarPerkakas.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

            }
        });

//        End Perkakas

//        Bentuk

        bentuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bentuk.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                bentuk.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarBentuk.class);

                        startActivity(intent);

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarBentuk.class);
                        startActivity(intent);


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });


        warna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                warna.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();
            }
        });

//        End Bentuk

//        Home

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.startAnimation(animation);


                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarWarna.class);

                        startActivity(intent);


                        Intent intent = new Intent(DashboardBelajar.this,Home.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });



        tata_surya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tata_surya.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(DashboardBelajar.this,DasboardBelajarTataSurya.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

//        End Home



    }
}