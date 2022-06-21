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

public class AdapterWarnaInggris extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public AdapterWarnaInggris(Context context) {
        this.context = context;
    }

    int[] gambar = {
            R.drawable.gambar_warna_1,
            R.drawable.gambar_warna_2,
            R.drawable.gambar_warna_3,
            R.drawable.gambar_warna_4,
            R.drawable.gambar_warna_5,
            R.drawable.gambar_warna_6,
            R.drawable.gambar_warna_7,
            R.drawable.gambar_warna_8,
            R.drawable.gambar_warna_9,
            R.drawable.gambar_warna_10,
            R.drawable.gambar_warna_11,
    };

    int[] namas = {
            R.string.red,
            R.string.Orange,
            R.string.Yellow,
            R.string.Green,
            R.string.Blue,
            R.string.Black,
            R.string.White,
            R.string.Grey,
            R.string.Pink,
            R.string.Purple,
            R.string.Brown,
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
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_tampil_2,container,false);

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.unlimited_bouncing);

        ImageView icon_apel;
        TextView nama;
        FrameLayout frame_layout;

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);
        frame_layout = view.findViewById(R.id.frame_layout);

        frame_layout.setBackgroundResource(R.drawable.bg_isi_warna);

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
