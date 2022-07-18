package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
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

public class DashboardBelajarProfesi extends AppCompatActivity {

    ImageView back;
    FrameLayout profesi,tebak_profesi;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard_belajar_profesi);

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


        Animation animation = AnimationUtils.loadAnimation(DashboardBelajarProfesi.this,R.anim.splash);

        profesi = findViewById(R.id.belajar_es);
        tebak_profesi = findViewById(R.id.tebak_profesi);

        MediaPlayer introPlayer = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.pilih_belajar_tebak);
        introPlayer.start();
        introPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                introPlayer.reset();
            }
        });

        profesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profesi.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();

                                MediaPlayer mediaPlayers = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.belajar_profesi);
                                mediaPlayers.start();
                                mediaPlayers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayers.reset();
                                        Intent intent = new Intent(getApplicationContext(),IsiBelajarProfesi.class);
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

        tebak_profesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tebak_profesi.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.click_sound_effect);
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

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(DashboardBelajarProfesi.this,DashboardBelajar.class);
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
        final Dialog dialog = new Dialog(DashboardBelajarProfesi.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setCancelable(true);

        dialog.setContentView(R.layout.dialog_bahasa);
        Animation animation = AnimationUtils.loadAnimation(DashboardBelajarProfesi.this,R.anim.splash);

        final ImageView bahasa_indonesia = dialog.findViewById(R.id.bahasa_indonesia);
        final ImageView bahasa_inggris = dialog.findViewById(R.id.bahasa_inggris);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                player.stop();
            }
        });

        bahasa_indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_indonesia.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        player.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(getApplicationContext(),TebakProfesiIndonesia.class);
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
                        player.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(getApplicationContext(),TebakProfesiInggris.class);
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

        player = MediaPlayer.create(DashboardBelajarProfesi.this,R.raw.pilih_bahasa);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.reset();
            }
        });

    }
}