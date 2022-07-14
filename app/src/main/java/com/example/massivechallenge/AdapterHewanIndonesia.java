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

public class AdapterHewanIndonesia extends PagerAdapter {

    Context context;
    LayoutInflater inflater;



    int[] gambar = {
            R.drawable.hewan_kucing,
            R.drawable.hewan_anjing,
            R.drawable.hewan_monyet,
            R.drawable.hewan_beruang,
            R.drawable.hewan_citah,
            R.drawable.hewan_elang,
            R.drawable.hewan_kangguru,
            R.drawable.hewan_kelinci,
            R.drawable.hewan_panda,
            R.drawable.hewan_sapi,
            R.drawable.hewan_singa,
            R.drawable.hewan_unta,
            R.drawable.hewan_zebra,
            R.drawable.hewan_bebek,
            R.drawable.hewan_katak,
            R.drawable.hewan_kelelawar,
            R.drawable.hewan_landak,
            R.drawable.hewan_rusa,
            R.drawable.hewan_siput,
            R.drawable.hewan_ayam,


    };



    int[] namas = {
            R.string.kucing,
            R.string.Anjing,
            R.string.Monyet,
            R.string.Beruang,
            R.string.Citah,
            R.string.Elang,
            R.string.Kangguru,
            R.string.Kelinci,
            R.string.Panda,
            R.string.Sapi,
            R.string.Singa,
            R.string.Unta,
            R.string.Zebra,
            R.string.Bebek,
            R.string.Katak,
            R.string.Kelelawar,
            R.string.Landak,
            R.string.Rusa,
            R.string.Siput,
            R.string.Ayam,

    };

    public AdapterHewanIndonesia(Context context) {
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
