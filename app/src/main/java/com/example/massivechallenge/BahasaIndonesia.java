package com.example.massivechallenge;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BahasaIndonesia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BahasaIndonesia extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BahasaIndonesia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BahasaIndonesia.
     */
    // TODO: Rename and change types and number of parameters
    public static BahasaIndonesia newInstance(String param1, String param2) {
        BahasaIndonesia fragment = new BahasaIndonesia();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    ImageView apel,back,bayangan,bahasa_indonesia,bahasa_inggris;
    LinearLayout layout_isi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bahasa_indonesia, container, false);

        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.unlimited_bouncing);
        Animation shadowAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.unlimited_bouncing_shadow);

        layout_isi = getActivity().findViewById(R.id.layout_isi);


        bayangan = view.findViewById(R.id.bayangan);
        bayangan.startAnimation(shadowAnimation);

        apel = view.findViewById(R.id.icon_apel);
        apel.startAnimation(animation);

        return view;
    }

    private  class Adapter extends FragmentPagerAdapter {

        int list_gambar []  = new int[]  {
                R.drawable.a_apel
        };

        public Adapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return Arrays.asList(list_gambar).indexOf("1");
        }

        @Override
        public int getCount() {
            return list_gambar.length;
        }
    }
}