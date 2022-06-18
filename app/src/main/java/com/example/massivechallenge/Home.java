package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout belajar,musik,mewarnai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

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

        musik = findViewById(R.id.musik);
        mewarnai = findViewById(R.id.mewarnai);
        belajar = findViewById(R.id.belajar);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bouncing);

        belajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                belajar.startAnimation(animation);


                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(Home.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(Home.this,DashboardBelajar.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

        mewarnai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mewarnai.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(Home.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        Intent intent = new Intent(Home.this,DashboardMewarnai.class);
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

        musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musik.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(Home.this,R.raw.click_sound_effect);
                mediaPlayer.start();
            }
        });

    }
}