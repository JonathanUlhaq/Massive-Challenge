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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class TebakProfesiIndonesia extends AppCompatActivity {

    //Inisialisasi
    TextView soal;
    ImageView gambar1, gambar2, gambar3;
    ImageView back;
    int lokasiJawaban, jawabanSalah, nomorSoal = 0, scoreAll = 0;
    ArrayList<Integer> jawaban = new ArrayList<Integer>();

    int[] gambar = {
            R.drawable.layer_profesi_1,
            R.drawable.layer_profesi_2,
            R.drawable.layer_profesi_3,
            R.drawable.layer_profesi_4,
            R.drawable.layer_profesi_5,
            R.drawable.layer_profesi_6,
            R.drawable.layer_profesi_7,
            R.drawable.layer_profesi_8,
            R.drawable.layer_profesi_9,
            R.drawable.layer_profesi_10,
            R.drawable.layer_profesi_11,
            R.drawable.layer_profesi_12,
            R.drawable.layer_profesi_13,
            R.drawable.layer_profesi_14,
            R.drawable.layer_profesi_15,
            R.drawable.layer_profesi_16,
            R.drawable.layer_profesi_17,
            R.drawable.layer_profesi_18,
            R.drawable.layer_profesi_19

    };

    int[] namas = {
            R.string.Koki,
            R.string.Pengusaha,
            R.string.Dokter,
            R.string.Nelayan,
            R.string.Guru,
            R.string.Ilmuan,
            R.string.Insinyur,
            R.string.Montir,
            R.string.Pelukis,
            R.string.Pemadam,
            R.string.Petani,
            R.string.Photographer,
            R.string.Pilot,
            R.string.Polisi,
            R.string.Pramugari,
            R.string.Tentara,
            R.string.Sekretaris,
            R.string.Pelayan,
            R.string.Atlet,
    };

    public void generateSoal() {
        Random random = new Random();
        int a = random.nextInt(19);
        int b = namas[a];
        int c = gambar[a];
        soal.setText(b);

        lokasiJawaban = random.nextInt(3);
        jawaban.clear();

        for (int i = 0; i < 3; i++) {
            if (i == lokasiJawaban) {
                jawaban.add(c);
            } else {
                jawabanSalah = gambar[random.nextInt(19)];
                while (jawabanSalah == c) {
                    jawabanSalah = gambar[random.nextInt(19)];
                }

                jawaban.add(jawabanSalah);
            }
        }

        gambar1.setImageDrawable(getDrawable(jawaban.get(0)));
        gambar2.setImageDrawable(getDrawable(jawaban.get(1)));
        gambar3.setImageDrawable(getDrawable(jawaban.get(2)));


        Animation animationImage = AnimationUtils.loadAnimation(TebakProfesiIndonesia.this, R.anim.unlimited_bouncing);
        Animation animationBayangan = AnimationUtils.loadAnimation(TebakProfesiIndonesia.this, R.anim.unlimited_bouncing_shadow);


        gambar1.startAnimation(animationImage);
        gambar2.startAnimation(animationImage);
        gambar3.startAnimation(animationImage);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_tebak_profesi_indonesia);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
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
        gambar1 = findViewById(R.id.gambar1);
        gambar2 = findViewById(R.id.gambar2);
        gambar3 = findViewById(R.id.gambar3);

        back = findViewById(R.id.back);

        Animation animation = AnimationUtils.loadAnimation(TebakProfesiIndonesia.this, R.anim.splash);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(TebakProfesiIndonesia.this, R.raw.click_sound_effect);
                        mediaPlayer.start();

                        Intent intent = new Intent(TebakProfesiIndonesia.this, DashboardBelajarProfesi.class);
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

    public void Jawaban(View view) {
        final Dialog dialog = new Dialog(TebakProfesiIndonesia.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setContentView(R.layout.dialog_hebat);
        dialog.setCancelable(false);

        Log.e("TAGG", view.getTag().toString());
        Animation animation = AnimationUtils.loadAnimation(TebakProfesiIndonesia.this, R.anim.splash);

        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                MediaPlayer mediaPlayer = MediaPlayer.create(TebakProfesiIndonesia.this, R.raw.click_sound_effect);
                mediaPlayer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                nomorSoal++;
                if (view.getTag().toString().equals(Integer.toString(lokasiJawaban))) {

                    new CountDownTimer(3000, 1000) {
                        @Override
                        public void onTick(long l) {

                            dialog.show();

                        }

                        @Override
                        public void onFinish() {
                            dialog.cancel();
                            generateSoal();
                            scoreAll = scoreAll + 10;

                            if (nomorSoal == 10) {
                                Dialog result = new Dialog(TebakProfesiIndonesia.this);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakProfesiIndonesia.this, R.raw.click_sound_effect);
                                                mediaPlayer.start();

                                                Intent intent = new Intent(TebakProfesiIndonesia.this, DasboardBelajarAngka.class);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakProfesiIndonesia.this, R.raw.click_sound_effect);
                                                mediaPlayer.start();

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

                    new CountDownTimer(3000, 1000) {
                        @Override
                        public void onTick(long l) {

                            dialog.show();

                        }

                        @Override
                        public void onFinish() {
                            dialog.cancel();
                            generateSoal();

                            if (nomorSoal == 10) {
                                Dialog result = new Dialog(TebakProfesiIndonesia.this);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakProfesiIndonesia.this, R.raw.click_sound_effect);
                                                mediaPlayer.start();

                                                Intent intent = new Intent(TebakProfesiIndonesia.this, DashboardBelajarTransportasi.class);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakProfesiIndonesia.this, R.raw.click_sound_effect);
                                                mediaPlayer.start();

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

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}