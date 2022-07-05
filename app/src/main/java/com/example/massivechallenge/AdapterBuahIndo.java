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

public class AdapterBuahIndo extends PagerAdapter {

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



    public AdapterBuahIndo(Context context) {
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
