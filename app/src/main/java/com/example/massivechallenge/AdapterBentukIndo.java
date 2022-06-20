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

public class AdapterBentukIndo extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    public AdapterBentukIndo(Context context) {
        this.context = context;
    }

    int[] namas = {
            R.string.persegi,
            R.string.persegi_panjang,
            R.string.lingkaran,
            R.string.lonjong,
            R.string.segitiga,
            R.string.segi_lima,
            R.string.segi_enam,
            R.string.segi_delapan,
            R.string.jajar_genjang,
            R.string.trapesium,
            R.string.belah_ketupat,
            R.string.bintang,
            R.string.panah,
            R.string.bulan,
            R.string.layang_layang


    };

    int[] gambar = {
            R.drawable.gambar_bentuk_bentuk,
            R.drawable.gambar_bentuk_persegi_panjang,
            R.drawable.gambar_bentuk_lingkaran,
            R.drawable.gambar_bentuk_lonjong,
            R.drawable.gambar_bentuk_segitiga,
            R.drawable.gambar_bentuk_segi_lima,
            R.drawable.gambar_bentuk_segi_enam,
            R.drawable.gambar_bentuk_segi_delapan,
            R.drawable.gambar_bentuk_jajar_genjang,
            R.drawable.gambar_bentuk_trapesium,
            R.drawable.gambar_bentuk_belah_ketupat,
            R.drawable.gambar_bentuk_bintang,
            R.drawable.gambar_bentuk_panah,
            R.drawable.gambar_bentuk_bulan,
            R.drawable.gambar_bentuk_layang_layang




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

        frame_layout.setBackgroundResource(R.drawable.bg_isi_bentuk);

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
