package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
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
            }
        });

        mewarnai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mewarnai.startAnimation(animation);
            }
        });

        musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musik.startAnimation(animation);
            }
        });

    }
}