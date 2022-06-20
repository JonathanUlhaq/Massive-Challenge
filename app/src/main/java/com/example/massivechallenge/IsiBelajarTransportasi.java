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

public class IsiBelajarTransportasi extends AppCompatActivity {

    ImageView back,button_all,bahasa_inggris,bahasa_indonesia;

    int[] suara = {
            R.raw.mobil,
            R.raw.truk,
            R.raw.ambulan,
            R.raw.perahu,
            R.raw.kereta_api,
            R.raw.pemadam_kebakaran,
            R.raw.mobil_polisi,
            R.raw.pesawat,
            R.raw.sepeda_motor,
            R.raw.kapal,
            R.raw.bajaj,
            R.raw.balon_udara,
            R.raw.bus,
            R.raw.kapal_cepat,
            R.raw.truk_kontainer,
            R.raw.mobil_sport,
            R.raw.sepeda,
            R.raw.vespa,
            R.raw.bus_sekolah,
            R.raw.helikopter,
    };

    public void Jawaban (View view)
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(IsiBelajarTransportasi.this,suara[Integer.valueOf(view.getTag().toString())]);
        mediaPlayer.start();
        Log.e("TEST1",view.getTag().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_isi_belajar_transportasi);

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


        button_all = findViewById(R.id.all);
        bahasa_inggris = findViewById(R.id.bahasa_inggris);
        bahasa_indonesia = findViewById(R.id.bahasa_indonesia);

        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,new FragmentTransportasIndonesia()).commit();

        button_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_all.startAnimation(backAnimation);

                backAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(IsiBelajarTransportasi.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                        bahasa_inggris.setImageResource(R.drawable.button_inggris_inactive);
                        bahasa_indonesia.setImageResource(R.drawable.button_indonesia_inactive);
                        button_all.setImageResource(R.drawable.button_all_pencet);
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.splash,R.anim.splash_out).replace(R.id.frame,new FragmentAllTransportasi()).commit();

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
                        MediaPlayer mediaPlayer = MediaPlayer.create(IsiBelajarTransportasi.this,R.raw.click_sound_effect);
                        mediaPlayer.start();

                        Intent intent = new Intent(IsiBelajarTransportasi.this,DashboardBelajarTransportasi.class);
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