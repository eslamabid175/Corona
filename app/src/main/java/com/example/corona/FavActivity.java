package com.example.corona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.corona.ViewModels.CountriesViewModel;
import com.example.corona.adapters.CountryAdaapter;
import com.example.corona.model.Countries;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class FavActivity extends AppCompatActivity {

    private CountriesViewModel viewModel;
    private RecyclerView recyclerView;
    private CountryAdaapter countryAdaapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);


        recyclerView=findViewById(R.id.fav_recyclerview);
        countryAdaapter=new CountryAdaapter();
        recyclerView.setAdapter(countryAdaapter);
        setupSwipe();


        Button tohomebtn=findViewById(R.id.to_home_btn);
        tohomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FavActivity.this,MainActivity.class));

            }
        });

        viewModel=new ViewModelProvider(this).get(CountriesViewModel.class);

        viewModel.getfavdata();

        viewModel.getFavList().observe(this, new Observer<List<Countries>>() {
            @Override
            public void onChanged(List<Countries> countries) {

                ArrayList<Countries>list=new ArrayList<>();
                list.addAll(countries);
                countryAdaapter.setcountriesList(list);

            }
        });


    }
    private void setupSwipe(){


        ItemTouchHelper.SimpleCallback callback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull
                    RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull  RecyclerView.ViewHolder viewHolder, int direction) {
                int swipcountryposition=viewHolder.getAdapterPosition();
                Countries swipedcountries =countryAdaapter.getCountryAt(swipcountryposition);
                viewModel.deleteCountry(swipedcountries.getCountry());
                countryAdaapter.notifyDataSetChanged();
                Toast.makeText(FavActivity.this,
                        "country deleted from favroites", Toast.LENGTH_SHORT).show();
            }
        };
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}