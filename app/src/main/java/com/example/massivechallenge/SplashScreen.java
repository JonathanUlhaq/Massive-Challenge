package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIME = 4*1000;
    ImageView icon_loading;
    TextView judul,deskripsi;
    LinearLayout tulisan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

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

        Animation animation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.pop_out);
        Animation animation2 = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.pop_out);
        Animation animation3 = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.pop_out);
        Animation bounce = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.unlimited_bouncing_splashscreen);

        icon_loading = findViewById(R.id.icon_loading);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        tulisan = findViewById(R.id.tulisan);

        icon_loading.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                icon_loading.startAnimation(bounce);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation2.setStartOffset(500);
        animation3.setStartOffset(1000);

        judul.startAnimation(animation2);
        deskripsi.startAnimation(animation3);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,Home.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, SPLASH_TIME);
    }
    }
