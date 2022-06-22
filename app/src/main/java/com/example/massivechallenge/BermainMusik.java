package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class BermainMusik extends AppCompatActivity {
    ImageView back,sound,sound2;
    TextView display;
    int[] suara = {
            R.raw.dos,
            R.raw.re,
            R.raw.mi,
            R.raw.fa,
            R.raw.sol,
            R.raw.la,
            R.raw.si,
            R.raw.do_oct
    };

    int [] nama = {
            R.string.dos,
            R.string.re,
            R.string.mi,
            R.string.fa,
            R.string.sol,
            R.string.la,
            R.string.si,
            R.string.do_octv,

    };

    public void Nada (View view)
    {
        Animation animation = AnimationUtils.loadAnimation(BermainMusik.this,R.anim.pencet);
        Animation getar = AnimationUtils.loadAnimation(BermainMusik.this,R.anim.getar);

        view.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                MediaPlayer mediaPlayer = MediaPlayer.create(BermainMusik.this,suara[Integer.valueOf(view.getTag().toString())]);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.reset();
                    }
                });

                display.setVisibility(View.VISIBLE);
                display.setText(nama[Integer.valueOf(view.getTag().toString())]);

                sound.startAnimation(getar);
                sound2.startAnimation(getar);

                Log.e("TEST1",view.getTag().toString());

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_bermain_musik);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.unlimited_bouncing);
        Animation backAnimation = AnimationUtils.loadAnimation(this,R.anim.splash);
        Animation shadowAnimation = AnimationUtils.loadAnimation(this,R.anim.unlimited_bouncing_shadow);

        display = findViewById(R.id.display);
        sound = findViewById(R.id.sound);
        sound2 = findViewById(R.id.sound2);

        display.setVisibility(View.INVISIBLE);

        back = findViewById(R.id.homes);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(backAnimation);

                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(BermainMusik.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                        Intent intent = new Intent(BermainMusik.this,Home.class);
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