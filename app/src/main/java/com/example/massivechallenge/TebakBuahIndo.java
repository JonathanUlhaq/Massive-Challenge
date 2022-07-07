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

public class TebakBuahIndo extends AppCompatActivity {

    //Inisialisasi
    TextView soal;
    ImageView gambar1, gambar2, gambar3;
    ImageView back;
    int lokasiJawaban, jawabanSalah, nomorSoal = 0, scoreAll = 0;
    ArrayList<Integer> jawaban = new ArrayList<Integer>();

    int[] gambar = {
            R.drawable.layer_buah_alpukat,
            R.drawable.layer_buah_anggur,
            R.drawable.layer_buah_stroberi,
            R.drawable.layer_buah_belimbing,
            R.drawable.layer_buah_buah_naga,
            R.drawable.layer_buah_ceri,
            R.drawable.layer_buah_delima,
            R.drawable.layer_buah_durian,
            R.drawable.layer_buah_jambu,
            R.drawable.layer_buah_jeruk_nipis,
            R.drawable.layer_buah_jeruk,
            R.drawable.layer_buah_kelapa,
            R.drawable.layer_buah_kiwi,
            R.drawable.layer_buah_lemon,
            R.drawable.layer_buah_mangga,
            R.drawable.layer_buah_nanas,
            R.drawable.layer_buah_pepaya,
            R.drawable.layer_buah_pisang,
            R.drawable.layer_buah_rambutan,
            R.drawable.layer_buah_semangka,


    };

    int[] namas = {
            R.string.alpukat,
            R.string.anggur,
            R.string.stroberi,
            R.string.belimbing,
            R.string.buah_naga,
            R.string.ceri,
            R.string.delima,
            R.string.durian,
            R.string.jambu,
            R.string.jeruk_nipis,
            R.string.jeruk,
            R.string.kelapa,
            R.string.kiwi,
            R.string.lemon,
            R.string.mangga,
            R.string.nanas,
            R.string.pepaya,
            R.string.pisang,
            R.string.rambutan,
            R.string.semangka,
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


        Animation animationImage = AnimationUtils.loadAnimation(TebakBuahIndo.this, R.anim.unlimited_bouncing);
        Animation animationBayangan = AnimationUtils.loadAnimation(TebakBuahIndo.this, R.anim.unlimited_bouncing_shadow);


        gambar1.startAnimation(animationImage);
        gambar2.startAnimation(animationImage);
        gambar3.startAnimation(animationImage);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tebak_buah_indo);

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

        Animation animation = AnimationUtils.loadAnimation(TebakBuahIndo.this, R.anim.splash);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this, R.raw.click_sound_effect);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.reset();
                            }
                        });
                        Intent intent = new Intent(TebakBuahIndo.this, DasboardBelajarBuah.class);
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
        final Dialog dialog = new Dialog(TebakBuahIndo.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.setContentView(R.layout.dialog_hebat);
        dialog.setCancelable(false);

        Log.e("TAGG", view.getTag().toString());
        Animation animation = AnimationUtils.loadAnimation(TebakBuahIndo.this, R.anim.splash);

        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this, R.raw.click_sound_effect);
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
                if (view.getTag().toString().equals(Integer.toString(lokasiJawaban))) {

                    MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this,R.raw.hebat);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.reset();
                        }
                    });

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
                                Dialog result = new Dialog(TebakBuahIndo.this);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this, R.raw.click_sound_effect);
                                                mediaPlayer.start();
                                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        mediaPlayer.reset();
                                                    }
                                                });
                                                Intent intent = new Intent(TebakBuahIndo.this, DasboardBelajarBuah.class);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this, R.raw.click_sound_effect);
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

                    MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this,R.raw.oops);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.reset();
                        }
                    });

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
                                Dialog result = new Dialog(TebakBuahIndo.this);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this, R.raw.click_sound_effect);
                                                mediaPlayer.start();
                                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                                        mediaPlayer.reset();
                                                    }
                                                });
                                                Intent intent = new Intent(TebakBuahIndo.this, DasboardBelajarBuah.class);
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
                                                MediaPlayer mediaPlayer = MediaPlayer.create(TebakBuahIndo.this, R.raw.click_sound_effect);
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

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}