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

public class AdapterHewanIndo extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    public AdapterHewanIndo(Context context) {
        this.context = context;
    }

    int[] namas = {
            R.string.Kucing,
            R.string.Anjing,
            R.string.Monyet,
            R.string.beruang,
            R.string.citah,
            R.string.elang,
            R.string.kangguru,
            R.string.kelinci,
            R.string.panda,
            R.string.sapi,
            R.string.singa,
            R.string.unta,
            R.string.zebra,
            R.string.bebek,
            R.string.katak,
            R.string.kelelawar,
            R.string.landak,
            R.string.rusa,
            R.string.siput,
            R.string.ayam

    };

    int[] gambar = {
            R.drawable.gambar_hewan_kucing,
            R.drawable.gambar_hewan_anjing,
            R.drawable.gambar_hewan_monyet,
            R.drawable.gambar_hewan_beruang,
            R.drawable.gambar_hewan_citah,
            R.drawable.gambar_hewan_elang,
            R.drawable.gambar_hewan_kangguru,
            R.drawable.gambar_hewan_kelinci,
            R.drawable.gambar_hewan_panda,
            R.drawable.gambar_hewan_sapi,
            R.drawable.gambar_hewan_singa,
            R.drawable.gambar_hewan_unta,
            R.drawable.gambar_hewan_zebra,
            R.drawable.gambar_hewan_bebek,
            R.drawable.gambar_hewan_katak,
            R.drawable.gambar_hewan_kelelawar,
            R.drawable.gambar_hewan_landak,
            R.drawable.gambar_hewan_rusa,
            R.drawable.gambar_hewan_siput,
            R.drawable.gambar_hewan_ayam,


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

        frame_layout.setBackgroundResource(R.drawable.bg_isi_hewan);

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
