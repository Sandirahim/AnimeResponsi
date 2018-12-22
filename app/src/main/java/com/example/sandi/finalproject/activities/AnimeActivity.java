package com.example.sandi.finalproject.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sandi.finalproject.R;

import com.example.sandi.finalproject.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();

        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio") ;
        String category = getIntent().getExtras().getString("anime_category");
        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode") ;
        String image_url = getIntent().getExtras().getString("anime_img") ;
        String rating = getIntent().getExtras().getString("anime_rating") ;

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = (TextView) findViewById(R.id.aa_anime_name);
        TextView tv_studio = (TextView) findViewById(R.id.aa_studio);
        TextView tv_categorie = (TextView) findViewById(R.id.aa_categorie);
        TextView tv_description = (TextView) findViewById(R.id.aa_description);
        TextView tv_rating  = (TextView) findViewById(R.id.aa_rating);
        ImageView img = (ImageView) findViewById(R.id.aa_thumbnail);

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(studio);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }
}
