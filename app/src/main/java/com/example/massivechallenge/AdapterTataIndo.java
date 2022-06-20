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

public class AdapterTataIndo extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    public AdapterTataIndo(Context context) {
        this.context = context;
    }

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
            R.string.neptunus


    };

    int[] gambar = {
            R.drawable.gambar_tata_matahari,
            R.drawable.gambar_tata_bulan,
            R.drawable.gambar_tata_merkurius,
            R.drawable.gambar_tata_venus,
            R.drawable.gambar_tata_bumi,
            R.drawable.gambar_tata_mars,
            R.drawable.gambar_tata_jupiter,
            R.drawable.gambar_tata_saturnus,
            R.drawable.gambar_tata_uranus,
            R.drawable.gambar_tata_neptunus


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

        frame_layout.setBackgroundResource(R.drawable.bg_isi_tata_surya);

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
