package com.vladan.mymovies.ui.main.about;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.vladan.mymovies.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Vladan on 10/16/2017.
 */

public class AboutFragment extends Fragment {
    View mRootView;
    ImageView imageViewGit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.about_fragment, container, false);
        imageViewGit = mRootView.findViewById(R.id.img_main_git);
        return mRootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        imageViewGit.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getString(R.string.GIT_HUB_URL)));
            startActivity(i);
        });


    }
}
