package com.example.reconcile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    private TextView titleview, descview;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        titleview = (TextView) findViewById(R.id.article_title);
      //  catview = (TextView) findViewById(R.id.category);
        descview = (TextView) findViewById(R.id.description);
        img = (ImageView) findViewById(R.id.news_img);


        // get data from array
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        // set content
        titleview.setText(Title);
        descview.setText(Description);
        img.setImageResource(image);

    }
}