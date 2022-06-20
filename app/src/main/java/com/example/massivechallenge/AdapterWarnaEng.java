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

public class AdapterWarnaEng extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    public AdapterWarnaEng(Context context) {
        this.context = context;
    }

    int[] namas = {
            R.string.red,
            R.string.orange,
            R.string.yellow,
            R.string.green,
            R.string.blue,
            R.string.black,
            R.string.white,
            R.string.grey,
            R.string.pink,
            R.string.purple,
            R.string.chocolate



    };

    int[] gambar = {
            R.drawable.gambar_warna_merah,
            R.drawable.gambar_warna_jingga,
            R.drawable.gambar_warna_kuning,
            R.drawable.gambar_warna_hijau,
            R.drawable.gambar_warna_biru,
            R.drawable.gambar_warna_hitam,
            R.drawable.gambar_warna_putih,
            R.drawable.gambar_warna_abu,
            R.drawable.gambar_warna_merah_muda,
            R.drawable.gambar_warna_ungu,
            R.drawable.gambar_warna_coklat



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
