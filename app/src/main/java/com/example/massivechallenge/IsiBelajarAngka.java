package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class IsiBelajarAngka extends AppCompatActivity {

    ImageView bahasa_indonesia,bahasa_inggris,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_isi_belajar_angka);

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

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.unlimited_bouncing);
        Animation backAnimation = AnimationUtils.loadAnimation(this,R.anim.splash);
        Animation shadowAnimation = AnimationUtils.loadAnimation(this,R.anim.unlimited_bouncing_shadow);

        bahasa_indonesia = findViewById(R.id.bahasa_indonesia);
        bahasa_inggris = findViewById(R.id.bahasa_inggris);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentAngkaIndonesia()).commit();

        bahasa_inggris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bahasa_inggris.startAnimation(backAnimation);

                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();

                        bahasa_indonesia.setImageDrawable(getDrawable(R.drawable.button_indonesia_inactive));
                        bahasa_inggris.setImageDrawable(getDrawable(R.drawable.button_inggris_active));

                        Fragment fragment = new FragmentAngkaInggris();

                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame_layout,fragment).commit();

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
                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click_sound_effect);
                        mediaPlayer.start();

                        bahasa_indonesia.setImageDrawable(getDrawable(R.drawable.button_indonesia_active));
                        bahasa_inggris.setImageDrawable(getDrawable(R.drawable.button_inggris_inactive));

                        Fragment fragment = new FragmentAngkaIndonesia();

                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame_layout,fragment).commit();

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
                back.startAnimation(backAnimation);

                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(IsiBelajarAngka.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                        Intent intent = new Intent(IsiBelajarAngka.this,DashboardBelajar.class);
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
}