package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class DashboardMewarnai extends AppCompatActivity {

    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_dashboard_mewarnai);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        home = findViewById(R.id.home);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(DashboardMewarnai.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnai.this,Home.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

    }
}