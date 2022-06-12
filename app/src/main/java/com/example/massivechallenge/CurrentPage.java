package com.example.massivechallenge;

import androidx.viewpager.widget.ViewPager;

/**
 * Get the current view position from the ViewPager by
 * extending SimpleOnPageChangeListener class and adding your method
 */
public class CurrentPage extends ViewPager.SimpleOnPageChangeListener {

    private int currentPage;
    ViewPager viewPager;

    public CurrentPage(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
    }

    public final int getCurrentPage() {
        return currentPage;
    }
}