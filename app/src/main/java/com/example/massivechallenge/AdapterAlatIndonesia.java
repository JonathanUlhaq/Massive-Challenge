package com.example.massivechallenge;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class AdapterAlatIndonesia extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    int[] gambar = {
            R.drawable.gambar_alat_1,
            R.drawable.gambar_alat_2,
            R.drawable.gambar_alat_3,
            R.drawable.gambar_alat_4,
            R.drawable.gambar_alat_5,
            R.drawable.gambar_alat_6,
            R.drawable.gambar_alat_7,
            R.drawable.gambar_alat_8,
            R.drawable.gambar_alat_9,
            R.drawable.gambar_alat_10,
            R.drawable.gambar_alat_11,
            R.drawable.gambar_alat_12,
            R.drawable.gambar_alat_13,
            R.drawable.gambar_alat_14,
            R.drawable.gambar_alat_15,
            R.drawable.gambar_alat_16,
            R.drawable.gambar_alat_17,
            R.drawable.gambar_alat_18,
            R.drawable.gambar_alat_19,
            R.drawable.gambar_alat_20,

    };

    int[] namas = {
            R.string.gembok,
            R.string.gergaji,
            R.string.gergaji_mesin,
            R.string.gunting,
            R.string.helm,
            R.string.jarum,
            R.string.kaca_pembesar,
            R.string.kapak,
            R.string.kunci_inggris,
            R.string.magnet,
            R.string.obeng,
            R.string.paku,
            R.string.palu,
            R.string.rantai,
            R.string.roda,
            R.string.skop,
            R.string.baut,
            R.string.soket,
            R.string.tali,
            R.string.tangga,
    };

    public AdapterAlatIndonesia(Context context) {
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

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);

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
