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

public class AdapterSayurEng extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public AdapterSayurEng(Context context) {
        this.context = context;
    }

    int[] namas = {
            R.string.broccoli,
            R.string.cauliflower,
            R.string.chili,
            R.string.leek,
            R.string.corn,
            R.string.mushroom,
            R.string.long_bean,
            R.string.pea,
            R.string.water_spinach,
            R.string.soybean,
            R.string.potato,
            R.string.cabbage,
            R.string.pumpkin,
            R.string.radis,
            R.string.peppers,
            R.string.lettuce,
            R.string.eggplant,
            R.string.cucumber,
            R.string.tomato,
            R.string.carrot


    };

    int[] gambar = {
            R.drawable.gambar_sayur_brokoli,
            R.drawable.gambar_sayur_kol,
            R.drawable.gambar_sayur_cabe,
            R.drawable.gambar_sayur_daun_bawang,
            R.drawable.gambar_sayur_jagung,
            R.drawable.gambar_sayur_jamur,
            R.drawable.gambar_sayur_kacang_panjang,
            R.drawable.gambar_sayur_kacang_polong,
            R.drawable.gambar_sayur_kangkung,
            R.drawable.gambar_sayur_kedelai,
            R.drawable.gambar_sayur_kentang,
            R.drawable.gambar_sayur_kubis,
            R.drawable.gambar_sayur_labu,
            R.drawable.gambar_sayur_lobak,
            R.drawable.gambar_sayur_paprika,
            R.drawable.gambar_sayur_selada,
            R.drawable.gambar_sayur_terong,
            R.drawable.gambar_sayur_timun,
            R.drawable.gambar_sayur_tomat,
            R.drawable.gambar_sayur_wortel

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
        TextView nama;
        FrameLayout frame_layout;

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);
        frame_layout = view.findViewById(R.id.frame_layout);

        frame_layout.setBackgroundResource(R.drawable.bg_isi_sayur);

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
