package com.example.massivechallenge;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterAbjadIndonesia extends PagerAdapter {

    Context context;
    LayoutInflater inflater;
    int[] abjad = {
            R.drawable.abjad_1, R.drawable.abjad_2,
            R.drawable.abjad_3, R.drawable.abjad_4,
            R.drawable.abjad_5, R.drawable.abjad_6,
            R.drawable.abjad_7, R.drawable.abjad_8,
            R.drawable.abjad_9, R.drawable.abjad_10,
            R.drawable.abjad_kuda, R.drawable.abjad_12,
            R.drawable.abjad_13, R.drawable.abjad_14,
            R.drawable.abjad_15, R.drawable.abjad_16,
            R.drawable.abjad_17, R.drawable.abjad_18,
            R.drawable.abjad_19, R.drawable.abjad_20,
            R.drawable.abjad_21, R.drawable.abjad_22,
            R.drawable.abjad_23, R.drawable.abjad_24,
            R.drawable.abjad_25, R.drawable.abjad_26,



    };


    int[] bayangan = {
            R.drawable.bayangan_belajar_huruf,
            R.drawable.bayangan_belajar_huruf_2, R.drawable.bayangan_belajar_huruf_3,
            R.drawable.bayangan_belajar_huruf_4, R.drawable.bayangan_belajar_huruf_5,
            R.drawable.bayangan_belajar_huruf_6, R.drawable.bayangan_belajar_huruf_7,
            R.drawable.bayangan_belajar_huruf_8, R.drawable.bayangan_belajar_huruf_9,
            R.drawable.bayangan_belajar_huruf_10, R.drawable.bayangan_belajar_huruf_11,
            R.drawable.bayangan_belajar_huruf_12, R.drawable.bayangan_belajar_huruf_13,
            R.drawable.bayangan_belajar_huruf_14, R.drawable.bayangan_belajar_huruf_15,
            R.drawable.bayangan_belajar_huruf_16, R.drawable.bayangan_belajar_huruf_17,
            R.drawable.bayangan_belajar_huruf_18, R.drawable.bayangan_belajar_huruf_19,
            R.drawable.bayangan_belajar_huruf_20, R.drawable.bayangan_belajar_huruf_21,
            R.drawable.bayangan_belajar_huruf_22, R.drawable.bayangan_belajar_huruf_23,
            R.drawable.bayangan_belajar_huruf_24, R.drawable.bayangan_belajar_huruf_25, R.drawable.bayangan_belajar_huruf_26,

    };




    int[] gambar = {
            R.drawable.a_apel, R.drawable.b_bola,
            R.drawable.c_cicak, R.drawable.d_domba,
            R.drawable.e_elang, R.drawable.f_foto,
            R.drawable.g_gajah, R.drawable.h_harimau,
            R.drawable.i_ikan, R.drawable.j_jam,
            R.drawable.k_kuda, R.drawable.l_lebah,
            R.drawable.m_meja, R.drawable.n_nanas,
            R.drawable.o_orangutan, R.drawable.p_pisang,
            R.drawable.q_quran, R.drawable.r_roda,
            R.drawable.s_sapi, R.drawable.t_telur,
            R.drawable.u_unta, R.drawable.v_vas,
            R.drawable.w_wortel, R.drawable.x_xylo,
            R.drawable.y_yoyo, R.drawable.z_zebra,


    };

    public AdapterAbjadIndonesia(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return abjad.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_tampil,container,false);

        LinearLayout isi_layout;
        Animation animation = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.unlimited_bouncing);
        Animation shadowAnimation = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.unlimited_bouncing_shadow);
        ImageView abjad_a,a_apel,shadow;

        isi_layout = view.findViewById(R.id.liner_layout);
        abjad_a = view.findViewById(R.id.abjad_a);
        a_apel = view.findViewById(R.id.icon_apel);
        shadow = view.findViewById(R.id.bayangan);




        shadow.startAnimation(shadowAnimation);
        a_apel.startAnimation(animation);

        shadow.setImageResource(bayangan[position]);
        abjad_a.setImageResource(abjad[position]);
        a_apel.setImageResource(gambar[position]);

        container.addView(view);

        return view;

    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}