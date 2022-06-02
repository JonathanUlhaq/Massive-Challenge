package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout belajar,musik,mewarnai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_home);

        musik = findViewById(R.id.musik);
        mewarnai = findViewById(R.id.mewarnai);
        belajar = findViewById(R.id.belajar);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bouncing);

        belajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                belajar.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(Home.this,R.raw.click_sound_effect);
                mediaPlayer.start();

                Intent intent = new Intent(Home.this,DashboardBelajar.class);
                startActivity(intent);
            }
        });

        mewarnai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mewarnai.startAnimation(animation);
                MediaPlayer mediaPlayer = MediaPlayer.create(Home.this,R.raw.click_sound_effect);
                mediaPlayer.start();
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