package com.vladan.mymovies.ui.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.vladan.mymovies.R;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar toolbar = findViewById(R.id.toolbar_share_view);
        setSupportActionBar(toolbar);
        initView();
    }


    private void initView() {
        ImageView mImageView = findViewById(R.id.iv_movie);

        if (getIntent() != null) {
            String img = getIntent().getStringExtra("img");
            Picasso.with(this).load(img).into(mImageView);
        }

    }
}
