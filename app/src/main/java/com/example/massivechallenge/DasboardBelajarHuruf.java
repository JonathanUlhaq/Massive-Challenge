package com.example.massivechallenge;

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

import androidx.appcompat.app.AppCompatActivity;

public class DasboardBelajarHuruf extends AppCompatActivity {

    ImageView back;
    MediaPlayer player;
    FrameLayout belajar_huruf,bermain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dasboard_belajar_huruf);

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

        MediaPlayer introPlayer = MediaPlayer.create(DasboardBelajarHuruf.this,R.raw.pilih_belajar_tebak);
        introPlayer.start();
        introPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                introPlayer.reset();
            }
        });

        Animation animation = AnimationUtils.loadAnimation(DasboardBelajarHuruf.this,R.anim.splash);
        belajar_huruf = findViewById(R.id.belajar_huruf);

        belajar_huruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                belajar_huruf.startAnimation(animation);

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

                                MediaPlayer mediaPlayers = MediaPlayer.create(DasboardBelajarHuruf.this,R.raw.belajar_huruf);
                                mediaPlayers.start();
                                mediaPlayers.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        mediaPlayers.reset();
                                        Intent intent = new Intent(getApplicationContext(),IsiBelajarHuruf.class);
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

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarHuruf.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(DasboardBelajarHuruf.this,DashboardBelajar.class);
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

        bermain = findViewById(R.id.bermain);

        bermain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bermain.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        introPlayer.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarHuruf.this,R.raw.click_sound_effect);
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



    }

    public void showDialog()
    {
        final Dialog dialog = new Dialog(DasboardBelajarHuruf.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setCancelable(true);

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                player.stop();
            }
        });

        dialog.setContentView(R.layout.dialog_bahasa);
        Animation animation = AnimationUtils.loadAnimation(DasboardBelajarHuruf.this,R.anim.splash);

        final ImageView bahasa_indonesia = dialog.findViewById(R.id.bahasa_indonesia);
        final ImageView bahasa_inggris = dialog.findViewById(R.id.bahasa_inggris);

        bahasa_indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_indonesia.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        player.stop();
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarHuruf.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(getApplicationContext(),TebakHurufIndonesia.class);
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

        player = MediaPlayer.create(DasboardBelajarHuruf.this,R.raw.pilih_bahasa);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.reset();
            }
        });

    }
}