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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DasboardBelajarAngka extends AppCompatActivity {

    ImageView back;
    FrameLayout angka,tebak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_dasboard_belajar_angka);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions;
        uiOptions =  View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        Animation animation = AnimationUtils.loadAnimation(DasboardBelajarAngka.this,R.anim.splash);

        back = findViewById(R.id.back);
        angka = findViewById(R.id.angka);
        tebak = findViewById(R.id.tebak);

        angka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                angka.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarAngka.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                        Intent intent = new Intent(DasboardBelajarAngka.this, IsiBelajarAngka.class);
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


        tebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tebak.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarAngka.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

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
                        MediaPlayer mediaPlayer = MediaPlayer.create(DasboardBelajarAngka.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        Intent intent = new Intent(DasboardBelajarAngka.this,DashboardBelajar.class);
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
        final Dialog dialog = new Dialog(DasboardBelajarAngka.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setCancelable(true);

        dialog.setContentView(R.layout.dialog_bahasa);
        Animation animation = AnimationUtils.loadAnimation(DasboardBelajarAngka.this,R.anim.splash);

        final ImageView bahasa_indonesia = dialog.findViewById(R.id.bahasa_indonesia);
        final ImageView bahasa_inggris = dialog.findViewById(R.id.bahasa_inggris);

        bahasa_indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_indonesia.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Intent intent = new Intent(getApplicationContext(),TebakAngkaIndonesia.class);
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

    }
}