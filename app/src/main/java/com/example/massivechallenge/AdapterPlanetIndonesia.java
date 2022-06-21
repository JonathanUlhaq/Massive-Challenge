package com.example.massivechallenge;

import android.content.Context;
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

public class AdapterPlanetIndonesia extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int[] namas = {
            R.string.matahari,
            R.string.bulan,
            R.string.merkurius,
            R.string.venus,
            R.string.bumi,
            R.string.mars,
            R.string.jupiter,
            R.string.saturnus,
            R.string.uranus,
            R.string.neptunus,
    };

    int[] gambar = {
            R.drawable.gambar_planet_1,
            R.drawable.gambar_planet_2,
            R.drawable.gambar_planet_3,
            R.drawable.gambar_planet_4,
            R.drawable.gambar_planet_5,
            R.drawable.gambar_planet_6,
            R.drawable.gambar_planet_7,
            R.drawable.gambar_planet_8,
            R.drawable.gambar_planet_9,
            R.drawable.gambar_planet_10,
    };

    public AdapterPlanetIndonesia(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return namas.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_tampil_2,container,false);

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.unlimited_bouncing);

        ImageView icon_apel;
        TextView nama;
        FrameLayout frame_layout;

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);
        frame_layout = view.findViewById(R.id.frame_layout);

        frame_layout.setBackgroundResource(R.drawable.bg_planet_isi);

        icon_apel.startAnimation(animation);

        icon_apel.setImageResource(gambar[position]);
        nama.setText(namas[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
