package com.example.massivechallenge;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DasboardBelajarHewan extends AppCompatActivity {

    ImageView back;
    FrameLayout belajar_hewan,tebak_hewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dasboard_belajar_hewan);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int  uiOptions =  View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        Animation animation = AnimationUtils.loadAnimation(DasboardBelajarHewan.this,R.anim.splash);
        MediaPlayer introPlayer = MediaPlayer.create(DasboardBelajarHewan.this,R.raw.pilih_belajar_tebak);
        introPlayer.start();
        introPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
            }
        });

        back = findViewById(R.id.back);
        belajar_hewan = findViewById(R.id.belajar_hewan);
        tebak_hewan = findViewById(R.id.tebak_hewan);

        belajar_hewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                belajar_hewan.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();
                        back.setEnabled(false);
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();

                                MediaPlayer mediaPlayers = MediaPlayer.create(DasboardBelajarHewan.this,R.raw.belajar_hewan);
                                mediaPlayers.start();
                                mediaPlayers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayers.reset();
                                        Intent intent = new Intent(getApplicationContext(),IsiBelajarHewan.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });

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

        tebak_hewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebak_hewan.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarHewan.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        showDialog();
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarHewan.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(DasboardBelajarHewan.this,DashboardBelajar.class);
                        startActivity(intent);
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

    public void showDialog()
    {
        final Dialog dialog = new Dialog(DasboardBelajarHewan.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setCancelable(true);

        dialog.setContentView(R.layout.dialog_bahasa);
        Animation animation = AnimationUtils.loadAnimation(DasboardBelajarHewan.this,R.anim.splash);

        final ImageView bahasa_indonesia = dialog.findViewById(R.id.bahasa_indonesia);
        final ImageView bahasa_inggris = dialog.findViewById(R.id.bahasa_inggris);

        bahasa_indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_indonesia.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Intent intent = new Intent(getApplicationContext(),TebakHewanIndonesia.class);
                        startActivity(intent);
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


        bahasa_inggris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_inggris.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Intent intent = new Intent(getApplicationContext(),TebakHewanInggris.class);
                        startActivity(intent);
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

        dialog.show();

        MediaPlayer player = MediaPlayer.create(DasboardBelajarHewan.this,R.raw.pilih_bahasa);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.reset();
            }
        });

    }
}