package com.example.massivechallenge;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DashboardBelajar extends AppCompatActivity {

    ImageView home;
    FrameLayout transportasi,bentuk,perkakas,tata_surya,warna,profesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_dashboard_belajar);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);




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

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarWarna.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
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

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarTataSurya.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

//        End Tata Surya

//        Profesi

        profesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profesi.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarProfesi.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
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

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarTransportasi.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
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

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarPerkakas.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

//        End Perkakas

//        Bentuk

        bentuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bentuk.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajar.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(DashboardBelajar.this,DashboardBelajarBentuk.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
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

                        Intent intent = new Intent(DashboardBelajar.this,Home.class);
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