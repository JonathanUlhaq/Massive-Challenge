package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.danny_jiang.tracinglibrary.bean.LetterFactory;
import com.danny_jiang.tracinglibrary.view.TracingLetterView;

public class BelajarMenulisBesar extends AppCompatActivity {

    private TracingLetterView letterView;
    int i = 0;
    FrameLayout menulis_huruf;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_belajar_menulis_besar);

        sharedPref = getSharedPreferences("POSISI",Context.MODE_PRIVATE);

         i = sharedPref.getInt("INDEX",0);


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


        Animation animation = AnimationUtils.loadAnimation(BelajarMenulisBesar.this,R.anim.splash);
        menulis_huruf = findViewById(R.id.menulis_huruf);

        letterView = findViewById(R.id.letter);
        LetterFactory letterFactory = new LetterFactory();

        if (i == 0)
        {
            letterView.setLetterChar(letterFactory.A);
            letterView.setPointColor(Color.BLUE);
            letterView.setInstructMode(true);
        }


        letterView.setTracingListener(new TracingLetterView.TracingListener() {
            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(BelajarMenulisBesar.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.setContentView(R.layout.dialog_hebat);
                dialog.setCancelable(false);

                new CountDownTimer(3000,1000 )
                {
                    @Override
                    public void onTick(long l) {
                        dialog.show();




                    }

                    public void onFinish() {
                        dialog.cancel();

//                        i++;
//
//                        menulis_huruf.removeAllViews();

//
//                        SharedPreferences.Editor editor = sharedPref.edit();
//                        editor.putInt("INDEX", i);
//                        editor.apply();
//
//                        letterView = findViewById(R.id.letter);
//                        LetterFactory letterFactory = new LetterFactory();
//
//                        letterView.setLetterChar(letterFactory.A+i);
//                        letterView.setPointColor(Color.BLUE);
//                        letterView.setInstructMode(true);

                    }
                }.start();

            }

            @Override
            public void onTracing(float x, float y) {

            }
        });


    }
    Intent intent;
    public void Abjad(View view)
    {
        i++;
        letterView = findViewById(R.id.letter);
        LetterFactory letterFactory = new LetterFactory();


        String value = view.getTag().toString();

        switch (value){
            case "0":
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                letterView.setLetterChar(letterFactory.B);
                letterView.setPointColor(Color.BLUE);
                letterView.setInstructMode(true);
                break;
            case "1":
                intent = getIntent();
                finish();
                startActivity(intent);
                letterView.setLetterChar(letterFactory.C);
                letterView.setPointColor(Color.BLUE);
                letterView.setInstructMode(true);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        i = 0;
    }
}