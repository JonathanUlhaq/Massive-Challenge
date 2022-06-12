package com.example.massivechallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AdapterAngkaIndonesia extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public AdapterAngkaIndonesia(Context context) {


        this.context = context;
    }

    int[] angka = {

            R.drawable.angka_1_indonesia,
            R.drawable.angka_2_indonesia,
            R.drawable.angka_3_indonesia,
            R.drawable.angka_4_indonesia,
            R.drawable.angka_5_indonesia,
            R.drawable.angka_6_indonesia,
            R.drawable.angka_7_indonesia,
            R.drawable.angka_8_indonesia,
            R.drawable.angka_9_indonesia,
            R.drawable.angka_10_indonesia,


    };

    int[] gambar = {
            R.drawable.angka_apel,
            R.drawable.angka_apel_2,
            R.drawable.angka_apel_3,
            R.drawable.angka_apel_4,
            R.drawable.angka_apel_5,
            R.drawable.angka_apel_6,
            R.drawable.angka_apel_7,
            R.drawable.angka_apel_8,
            R.drawable.angka_apel_9,
            R.drawable.angka_apel_10,


    };

    @Override
    public int getCount() {
        return gambar.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_tampil,container,false);

        Animation animation = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.unlimited_bouncing);
        Animation shadowAnimation = AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.unlimited_bouncing_shadow);
        ImageView abjad_a,a_apel,shadow;

        abjad_a = view.findViewById(R.id.abjad_a);
        a_apel = view.findViewById(R.id.icon_apel);
        shadow = view.findViewById(R.id.bayangan);


        a_apel.startAnimation(animation);
        shadow.setVisibility(View.GONE);

        a_apel.setImageResource(gambar[position]);
        abjad_a.setImageResource(angka[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
