package com.example.massivechallenge;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class AdapterBuahEng extends PagerAdapter {

    Context context;
    LayoutInflater inflater;



    int[] gambar = {
            R.drawable.gambar_buah_alpukat,
            R.drawable.gambar_buah_anggur,
            R.drawable.gambar_buah_stroberi,
            R.drawable.gambar_buah_belimbing,
            R.drawable.gambar_buah_buah_naga,
            R.drawable.gambar_buah_ceri,
            R.drawable.gambar_buah_delima,
            R.drawable.gambar_buah_durian,
            R.drawable.gambar_buah_jambu,
            R.drawable.gambar_buah_jeruk_nipis,
            R.drawable.gambar_buah_jeruk,
            R.drawable.gambar_buah_kelapa,
            R.drawable.gambar_buah_kiwi,
            R.drawable.gambar_buah_lemon,
            R.drawable.gambar_buah_mangga,
            R.drawable.gambar_buah_nanas,
            R.drawable.gambar_buah_pepaya,
            R.drawable.gambar_buah_pisang,
            R.drawable.gambar_buah_rambutan,
            R.drawable.gambar_buah_semangka,


    };



    int[] namas = {
            R.string.avocado,
            R.string.grape,
            R.string.strawberry,
            R.string.star_fruit,
            R.string.dragon_fruit,
            R.string.cherry,
            R.string.pomegranate,
            R.string.durian,
            R.string.guava,
            R.string.lime,
            R.string.orange,
            R.string.coconut,
            R.string.kiwi,
            R.string.lemon,
            R.string.mango,
            R.string.pineapple,
            R.string.papaya,
            R.string.banana,
            R.string.rambutan,
            R.string.watermelon,



    };

    public AdapterBuahEng(Context context) {
        this.context = context;
    }

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
        View view = inflater.inflate(R.layout.layout_tampil_2,container,false);

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.unlimited_bouncing);

        ImageView icon_apel;
        TextView nama;
        FrameLayout frame_layout;

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);
        frame_layout = view.findViewById(R.id.frame_layout);

        frame_layout.setBackgroundResource(R.drawable.bg_alat_isi);

        icon_apel.startAnimation(animation);

        icon_apel.setImageResource(gambar[position]);
        nama.setText(namas[position]);

        container.addView(view);



        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
