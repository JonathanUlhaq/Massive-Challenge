package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class TebakHurufIndonesia extends AppCompatActivity {

    int[] huruf = {
            R.string.A,
            R.string.B,
            R.string.C,
            R.string.D,
            R.string.E,
            R.string.F,
            R.string.G,
            R.string.H,
            R.string.I,
            R.string.J,
            R.string.K,
            R.string.L,
            R.string.M,
            R.string.N,
            R.string.O,
            R.string.P,
            R.string.Q,
            R.string.R,
            R.string.S,
            R.string.T,
            R.string.U,
            R.string.V,
            R.string.W,
            R.string.X,
            R.string.Y,
            R.string.Z
    };

    //Inisialisasi
    TextView soal;
    Button huruf1,huruf2,huruf3;
    ImageView back,bayangan,bayangan1,bayangan2;
    int lokasiJawaban, jawabanSalah,nomorSoal = 0,scoreAll = 0;
    ArrayList<Integer> jawaban = new ArrayList<Integer>();

    public void generateSoal()
    {
        Random random = new Random();
        int a = huruf[random.nextInt(26)];
        soal.setText(a);

        lokasiJawaban = random.nextInt(3);
        jawaban.clear();

        for(int i = 0; i<3;i++)
        {
            if (i == lokasiJawaban)
            {
                jawaban.add(a);
            } else {
                jawabanSalah = huruf[random.nextInt(26)];

                while (jawabanSalah == a)
                {
                    jawabanSalah = huruf[random.nextInt(26)];
                }

                jawaban.add(jawabanSalah);
            }
        }


        huruf1.setText(jawaban.get(0));
        huruf2.setText(jawaban.get(1));
        huruf3.setText(jawaban.get(2));
        Log.e("TAGG2",Integer.toString(lokasiJawaban));

        Animation animationImage = AnimationUtils.loadAnimation(TebakHurufIndonesia.this,R.anim.unlimited_bouncing);
        Animation animationBayangan = AnimationUtils.loadAnimation(TebakHurufIndonesia.this,R.anim.unlimited_bouncing_shadow);


        huruf1.startAnimation(animationImage);
        huruf2.startAnimation(animationImage);
        huruf3.startAnimation(animationImage);

        bayangan.startAnimation(animationBayangan);
        bayangan1.startAnimation(animationBayangan);
        bayangan2.startAnimation(animationBayangan);


    }

    public void Jawaban(View view)
    {


        final Dialog dialog = new Dialog(TebakHurufIndonesia.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setContentView(R.layout.dialog_hebat);
        dialog.setCancelable(false);

        Log.e("TAGG",view.getTag().toString());
        Animation animation = AnimationUtils.loadAnimation(TebakHurufIndonesia.this,R.anim.splash);

        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                MediaPlayer mediaPlayer = MediaPlayer.create(TebakHurufIndonesia.this,R.raw.click_sound_effect);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.reset();
                    }
                });

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                nomorSoal++;
                if(view.getTag().toString().equals(Integer.toString(lokasiJawaban)))
                {


                    new CountDownTimer(3000,1000)
                    {
                        @Override
                        public void onTick(long l) {

                            dialog.show();

                        }

                        @Override
                        public void onFinish() {
                            dialog.cancel();
                            generateSoal();
                            scoreAll= scoreAll + 10;

                            if(nomorSoal == 10)
                            {
                                Dialog result = new Dialog(TebakHurufIndonesia.this);
                                result.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                result.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                result.setContentView(R.layout.dialog_niali_akhir);
                                result.setCancelable(false);

                                TextView scoress = result.findViewById(R.id.score);
                                ImageView kembali = result.findViewById(R.id.kembali);
                                ImageView ulangi = result.findViewById(R.id.ulangi);

                                kembali.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        kembali.startAnimation(animation);

                                        animation.setAnimationListener(new Animation.AnimationListener() {
                                            @Override
                                            public void onAnimationStart(Animation animation) {
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakHurufIndonesia.this,R.raw.click_sound_effect);
                                                mediaPlayer.start();
                                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        mediaPlayer.reset();
                                                    }
                                                });
                                                Intent intent = new Intent(TebakHurufIndonesia.this,DasboardBelajarHuruf.class);
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


                                ulangi.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        ulangi.startAnimation(animation);

                                        animation.setAnimationListener(new Animation.AnimationListener() {
                                            @Override
                                            public void onAnimationStart(Animation animation) {
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakHurufIndonesia.this,R.raw.click_sound_effect);
                                                mediaPlayer.start();
                                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        mediaPlayer.reset();
                                                    }
                                                });
                                                generateSoal();
                                                scoreAll = 0;
                                                nomorSoal = 0;
                                                result.cancel();
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

                                scoress.setText(Integer.toString(scoreAll));

                                result.show();

                            }

                        }
                    }.start();

                } else {

                    ImageView hebat = dialog.findViewById(R.id.hebat);
                    hebat.setImageResource(R.drawable.gambar_oops);
                    new CountDownTimer(3000,1000)
                    {
                        @Override
                        public void onTick(long l) {

                            dialog.show();

                        }

                        @Override
                        public void onFinish() {
                            dialog.cancel();
                            generateSoal();

                            if(nomorSoal == 10)
                            {
                                Dialog result = new Dialog(TebakHurufIndonesia.this);
                                result.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                result.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                result.setContentView(R.layout.dialog_niali_akhir);
                                result.setCancelable(false);

                                TextView scoress = result.findViewById(R.id.score);
                                ImageView kembali = result.findViewById(R.id.kembali);
                                ImageView ulangi = result.findViewById(R.id.ulangi);

                                kembali.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        kembali.startAnimation(animation);

                                        animation.setAnimationListener(new Animation.AnimationListener() {
                                            @Override
                                            public void onAnimationStart(Animation animation) {
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakHurufIndonesia.this,R.raw.click_sound_effect);
                                                mediaPlayer.start();
                                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        mediaPlayer.reset();
                                                    }
                                                });
                                                Intent intent = new Intent(TebakHurufIndonesia.this,DasboardBelajarHuruf.class);
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


                                ulangi.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        ulangi.startAnimation(animation);

                                        animation.setAnimationListener(new Animation.AnimationListener() {
                                            @Override
                                            public void onAnimationStart(Animation animation) {
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakHurufIndonesia.this,R.raw.click_sound_effect);
                                                mediaPlayer.start();
                                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        mediaPlayer.reset();
                                                    }
                                                });
                                                generateSoal();
                                                scoreAll = 0;
                                                nomorSoal = 0;
                                                result.cancel();
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

                                scoress.setText(Integer.toString(scoreAll));

                                result.show();

                            }
                        }
                    }.start();

                }



                Log.e("Nomor",Integer.toString(nomorSoal));
                Log.e("SCORE",Integer.toString(scoreAll));



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
        setContentView(R.layout.activity_tebak_huruf_indo);

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

        soal = findViewById(R.id.soal);
        huruf1 = findViewById(R.id.huruf1);
        huruf2 = findViewById(R.id.huruf2);
        huruf3 = findViewById(R.id.huruf3);
        bayangan = findViewById(R.id.bayangan);
        bayangan1 = findViewById(R.id.bayangan1);
        bayangan2 = findViewById(R.id.bayangan2);
        back = findViewById(R.id.back);

        Animation animation = AnimationUtils.loadAnimation(TebakHurufIndonesia.this,R.anim.splash);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(TebakHurufIndonesia.this,R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(TebakHurufIndonesia.this,DasboardBelajarHuruf.class);
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

        generateSoal();


    }
}