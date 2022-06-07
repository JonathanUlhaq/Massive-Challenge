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

public class IsiBelajarHuruf extends AppCompatActivity {

    ImageView apel,back,bayangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_isi_belajar_huruf);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.unlimited_bouncing);
        Animation backAnimation = AnimationUtils.loadAnimation(this,R.anim.splash);
        Animation shadowAnimation = AnimationUtils.loadAnimation(this,R.anim.unlimited_bouncing_shadow);


        bayangan = findViewById(R.id.bayangan);
        bayangan.startAnimation(shadowAnimation);

        apel = findViewById(R.id.icon_apel);
        apel.startAnimation(animation);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(backAnimation);

                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(IsiBelajarHuruf.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Intent intent = new Intent(IsiBelajarHuruf.this,DashboardBelajar.class);
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