package com.example.apikinopoisk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class InfoPage extends AppCompatActivity {
    TextView name;
    TextView date;
    TextView description;
    ImageView coverInfo;
    TextView RatingInfo;
    VideoView videoView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        coverInfo = findViewById(R.id.coverInfo);
        RatingInfo = findViewById(R.id.RatingInfo);
        videoView = findViewById(R.id.videoView);
        name.setText(getIntent().getStringExtra("name"));
        date.setText(getIntent().getStringExtra("date"));
        description.setText(getIntent().getStringExtra("description"));
        Picasso.with(InfoPage.this).load(getIntent().getStringExtra("poster")).into(coverInfo);
        RatingInfo.setText(getIntent().getStringExtra("rating"));
        String videoUrl = getIntent().getStringExtra("video");
        Uri videoUri = Uri.parse(videoUrl);
        videoView.setVideoURI(videoUri);
        videoView.start();
        Intent intent = new Intent(this, actors.class);
        String id = getIntent().getStringExtra("id");
        intent.putExtra("id", id);
        button = findViewById(R.id.actors);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}