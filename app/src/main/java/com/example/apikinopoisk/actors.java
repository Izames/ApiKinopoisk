package com.example.apikinopoisk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class actors extends AppCompatActivity {
    TextView textView;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        textView = findViewById(R.id.staff);
        apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
        textView = findViewById(R.id.staff);
        apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
        Call<ArrayList<ActorsClass>> call = apiInterface.getActors(Integer.parseInt(getIntent().getStringExtra("id")), "3893e6f1-07a4-4e49-aca6-da672a5bd8e3");
        call.enqueue(new Callback<ArrayList<ActorsClass>>() {
            @Override
            public void onResponse(Call<ArrayList<ActorsClass>> call, Response<ArrayList<ActorsClass>> response) {
                if (response.isSuccessful()){
                    String text = "";
                    ArrayList<ActorsClass> actorsClass = response.body();
                    for (ActorsClass a: actorsClass){
                        text+= a.getNameRu() + ", ";
                    }
                    textView.setText(text);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ActorsClass>> call, Throwable t) {

            }
        });
    }
}