package com.example.HeroProject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.example.HeroProject.R;
import com.example.HeroProject.adapter.HeroAdapter;
import com.example.HeroProject.application.BaseApplication;
import com.example.HeroProject.pojo.Hero;
import com.example.HeroProject.viewmodel.HeroViewModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HeroAdapter adapter;

    List<Hero> heroList;
    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BaseApplication)getApplication()).getAppComponent().inject(this);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroViewModel viewModel =  ViewModelProviders.of(this).get(HeroViewModel.class);

        viewModel.getHeroes(retrofit).observe(this, heroes -> {
            heroList = heroes;
            adapter = new HeroAdapter(MainActivity.this, heroes);
            recyclerView.setAdapter(adapter);
        });
    }
}