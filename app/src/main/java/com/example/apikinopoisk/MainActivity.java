package com.example.apikinopoisk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.sort);
        String[] options = {"ожидаемые", "топ рейтинг"};
        ArrayAdapter<String> sortingType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spinner.setAdapter(sortingType);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemIdAtPosition(position) == 0) {
                    Toast.makeText(MainActivity.this, "Ожидаемые", Toast.LENGTH_SHORT).show();
                } else if (parent.getItemIdAtPosition(position) == 1) {
                    Toast.makeText(MainActivity.this, "Топы", Toast.LENGTH_SHORT).show();
                } else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        apiInterface = ServiceBuilder.buildRequest().create(ApiInterface.class);
        Call<Film> getFilm = apiInterface.getListPremierFilms("TOP_POPULAR_ALL", 1,
                "3893e6f1-07a4-4e49-aca6-da672a5bd8e3");
        getFilm.enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if(response.isSuccessful()){
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setHasFixedSize(true);
                    Film list = response.body();
                    ItemAdaptor adaptor = new ItemAdaptor(MainActivity.this, list);
                    recyclerView.setAdapter(adaptor);
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка со стороны клиента", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                TextView textView = findViewById(R.id.problem);
                textView.setText(t.getMessage());
            }
        });
    }
}