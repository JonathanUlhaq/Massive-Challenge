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

public class AdapterProfesiInggris extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public AdapterProfesiInggris(Context context) {
        this.context = context;
    }

    int[] gambar = {
            R.drawable.gambar_profesi_1,
            R.drawable.gambar_profesi_2,
            R.drawable.gambar_profesi_3,
            R.drawable.gambar_profesi_4,
            R.drawable.gambar_profesi_5,
            R.drawable.gambar_profesi_6,
            R.drawable.gambar_profesi_7,
            R.drawable.gambar_profesi_8,
            R.drawable.gambar_profesi_9,
            R.drawable.gambar_profesi_10,
            R.drawable.gambar_profesi_11,
            R.drawable.gambar_profesi_12,
            R.drawable.gambar_profesi_13,
            R.drawable.gambar_profesi_14,
            R.drawable.gambar_profesi_15,
            R.drawable.gambar_profesi_16,
            R.drawable.gambar_profesi_17,
            R.drawable.gambar_profesi_18,
            R.drawable.gambar_profesi_19,
    };

    int[] namas = {
            R.string.Koki1,
            R.string.Pengusaha1,
            R.string.Dokter1,
            R.string.Nelayan1,
            R.string.Guru1,
            R.string.Ilmuan1,
            R.string.Insinyur1,
            R.string.Montir1,
            R.string.Pelukis1,
            R.string.Pemadam1,
            R.string.Petani1,
            R.string.Photographer,
            R.string.Pilot,
            R.string.Polisi1,
            R.string.Pramugari1,
            R.string.Tentara1,
            R.string.Sekretaris1,
            R.string.Pelayan1,
            R.string.Atlet1,
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

        frame_layout.setBackgroundResource(R.drawable.bg_profesi_isi);
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
