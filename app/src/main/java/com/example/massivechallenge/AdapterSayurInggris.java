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

public class AdapterSayurInggris extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public AdapterSayurInggris(Context context) {
        this.context = context;
    }

    int[] gambar = {
            R.drawable.sayur_brokoli,
            R.drawable.sayur_bunga_kol,
            R.drawable.sayur_cabe,
            R.drawable.sayur_daun_bawang,
            R.drawable.sayur_jagung,
            R.drawable.sayur_jamur,
            R.drawable.sayur_kacang_panjang,
            R.drawable.sayur_kacang_polong,
            R.drawable.sayur_kangkung,
            R.drawable.sayur_kedelai,
            R.drawable.sayur_kentang,
            R.drawable.sayur_kubis,
            R.drawable.sayur_labu,
            R.drawable.sayur_lobak,
            R.drawable.sayur_paprika,
            R.drawable.sayur_selada,
            R.drawable.sayur_terong,
            R.drawable.sayur_timun,
            R.drawable.sayur_tomat,
            R.drawable.sayur_wortel,

    };

    int[] namas = {
            R.string.Sayur_Eng11,
            R.string.Sayur_Eng2,
            R.string.Sayur_Eng3,
            R.string.Sayur_Eng4,
            R.string.Sayur_Eng5,
            R.string.Sayur_Eng6,
            R.string.Sayur_Eng7,
            R.string.Sayur_Eng8,
            R.string.Sayur_Eng9,
            R.string.Sayur_Eng10,
            R.string.Sayur_Eng11,
            R.string.Sayur_Eng12,
            R.string.Sayur_Eng13,
            R.string.Sayur_Eng14,
            R.string.Sayur_Eng15,
            R.string.Sayur_Eng16,
            R.string.Sayur_Eng17,
            R.string.Sayur_Eng18,
            R.string.Sayur_Eng19,
            R.string.Sayur_Eng20,
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
        View view = inflater.inflate(R.layout.layout_tampil_2,container,false);

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.unlimited_bouncing);

        ImageView icon_apel;
        FrameLayout frame_layout;
        TextView nama;

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);

        frame_layout = view.findViewById(R.id.frame_layout);

        frame_layout.setBackgroundResource(R.drawable.bg_hewan_isi);

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
