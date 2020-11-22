package com.Project.OMRReader.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.Project.OMRReader.Fragments.QuizDetailsOverallFragment;
import com.Project.OMRReader.Fragments.QuizDetailsStudentFragment;

public class QuizDetailsTabLayoutAdapter extends FragmentStatePagerAdapter {

    Fragment fragment;
    Context context;

    public QuizDetailsTabLayoutAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                fragment = new QuizDetailsOverallFragment();
                return fragment;
            }
            case 1: {
                fragment = new QuizDetailsStudentFragment();
                return fragment;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Overall";
            case 1:
                return "Student";
            default:
                return null;
        }
    }

}
