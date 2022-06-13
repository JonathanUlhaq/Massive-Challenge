package com.example.massivechallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AdapterTransportasiInggris extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public AdapterTransportasiInggris(Context context) {
        this.context = context;
    }

    int[] namas = {
            R.string.car,
            R.string.truck,
            R.string.ambulance,
            R.string.boat,
            R.string.train,
            R.string.fireEngine,
            R.string.police,
            R.string.airplane,
            R.string.motor,
            R.string.ship,
            R.string.rick,
            R.string.balloon,
            R.string.buss,
            R.string.speedboat,
            R.string.containerTruck,
            R.string.sportCar,
            R.string.bycicle,
            R.string.scooter,
            R.string.school,
            R.string.helicopter

    };

    int[] gambar = {
            R.drawable.gambar_mobil,
            R.drawable.gambar_truk,
            R.drawable.gambar_ambulan,
            R.drawable.gambar_perahu,
            R.drawable.gambar_kereta_api,
            R.drawable.gambar_pemadam_kebakaran,
            R.drawable.gambar_mobil_polisi,
            R.drawable.gambar_pesawat,
            R.drawable.gambar_sepeda_motor,
            R.drawable.gambar_kapal,
            R.drawable.gambar_bajaj,
            R.drawable.gambar_balon_udara,
            R.drawable.gambar_bus,
            R.drawable.gambar_kapal_cepat,
            R.drawable.gambar_truk_kontainer,
            R.drawable.gambar_mobil_sport,
            R.drawable.gambar_sepeda,
            R.drawable.gambar_vespa,
            R.drawable.gambar_bus_sekolah,
            R.drawable.gambar_heli_kopter

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

        icon_apel = view.findViewById(R.id.icon_apel);
        nama = view.findViewById(R.id.nama);

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
