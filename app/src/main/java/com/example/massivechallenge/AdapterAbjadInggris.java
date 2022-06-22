package com.example.massivechallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AdapterAbjadInggris extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    int[] bayangans = {
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

    int[] abjads = {
            R.drawable.abjad_ei, R.drawable.abjad_bi,
            R.drawable.abjad_ci, R.drawable.abjad_di,
            R.drawable.abjad_ii, R.drawable.abjad_fi,
            R.drawable.abjad_gi, R.drawable.abjad_hi,
            R.drawable.abjad_ai, R.drawable.abjad_ji,
            R.drawable.abjad_11, R.drawable.abjad_li,
            R.drawable.abjad_mi, R.drawable.abjad_ni,
            R.drawable.abjad_oi, R.drawable.abjad_pi,
            R.drawable.abjad_qi, R.drawable.abjad_ri,
            R.drawable.abjad_si, R.drawable.abjad_ti,
            R.drawable.abjad_ui, R.drawable.abjad_vi,
            R.drawable.abjad_wi, R.drawable.abjad_xi,
            R.drawable.ic_abjad_yi, R.drawable.abjad_zi,



    };

    int[] gambars = {
            R.drawable.a_apel, R.drawable.b_bola,
            R.drawable.c_carrot, R.drawable.d_dog,
            R.drawable.e_elang, R.drawable.f_fish,
            R.drawable.g_giraffe, R.drawable.h_hat,
            R.drawable.i_ice, R.drawable.j_juice,
            R.drawable.k_kangoro, R.drawable.l_lamb,
            R.drawable.m_monkey, R.drawable.n_no,
            R.drawable.o_octopus, R.drawable.p_pig,
            R.drawable.q_question, R.drawable.r_ring,
            R.drawable.s_sun, R.drawable.t_table,
            R.drawable.u_umbrella, R.drawable.v_van,
            R.drawable.w_watch, R.drawable.x_xylo,
            R.drawable.y_yellow, R.drawable.z_zebra,


    };



    public AdapterAbjadInggris(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bayangans.length;
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


        abjad_a = view.findViewById(R.id.abjad_a);
        a_apel = view.findViewById(R.id.icon_apel);
        shadow = view.findViewById(R.id.bayangan);




        shadow.startAnimation(shadowAnimation);
        a_apel.startAnimation(animation);

        shadow.setImageResource(bayangans[position]);
        abjad_a.setImageResource(abjads[position]);
        a_apel.setImageResource(gambars[position]);

        container.addView(view);

        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
