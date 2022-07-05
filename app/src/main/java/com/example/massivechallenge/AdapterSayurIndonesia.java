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

public class AdapterSayurIndonesia extends PagerAdapter {

    Context context;
    LayoutInflater inflater;



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
            R.string.Sayur_1,
            R.string.Sayur_2,
            R.string.Sayur_3,
            R.string.Sayur_4,
            R.string.Sayur_5,
            R.string.Sayur_6,
            R.string.Sayur_7,
            R.string.Sayur_8,
            R.string.Sayur_9,
            R.string.Sayur_10,
            R.string.Sayur_11,
            R.string.Sayur_12,
            R.string.Sayur_13,
            R.string.Sayur_14,
            R.string.Sayur_15,
            R.string.Sayur_16,
            R.string.Sayur_17,
            R.string.Sayur_18,
            R.string.Sayur_19,
            R.string.Sayur_20,

    };

    public AdapterSayurIndonesia(Context context) {
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

        frame_layout.setBackgroundResource(R.drawable.bg_hewan_isi);

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
