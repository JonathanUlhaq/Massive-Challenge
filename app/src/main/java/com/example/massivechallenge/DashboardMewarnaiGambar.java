package com.example.massivechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DashboardMewarnaiGambar extends AppCompatActivity {

    ImageView home;
    FrameLayout bus, ship, car, apple, manggo, strobery, gajah, monkey, kubis, paprika, carrot, rosses;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard_mewarnai_gambar);

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




        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash);
        Animation itemAnimation = AnimationUtils.loadAnimation(this,R.anim.splash);


        home = findViewById(R.id.homes);
        bus = findViewById(R.id.bus);
        ship = findViewById(R.id.ship);
        car = findViewById(R.id.car);
        apple = findViewById(R.id.apel);
        manggo = findViewById(R.id.manggo);
        strobery = findViewById(R.id.strobery);
        gajah = findViewById(R.id.gajah);
        monkey = findViewById(R.id.monkey);
        kubis = findViewById(R.id.kubis);
        paprika = findViewById(R.id.paprika);
        carrot= findViewById(R.id.carrot);
        rosses= findViewById(R.id.rosses);

//        bus

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiBus.class);
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



        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ship.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiShip.class);
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


        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiCar.class);
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




        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apple.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiApel.class);
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



        manggo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manggo.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiManggo.class);
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


        strobery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               strobery.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiStroberi.class);
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



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,Home.class);
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


        gajah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gajah.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiGajah.class);
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


        monkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monkey.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiMonkey.class);
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


        kubis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kubis.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiKubis.class);
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


        paprika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paprika.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiPaprika.class);
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



        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               carrot.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiCarrot.class);
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


        rosses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rosses.startAnimation(itemAnimation);

                itemAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        Intent intent = new Intent(DashboardMewarnaiGambar.this,MewarnaiRoses.class);
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