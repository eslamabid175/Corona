package com.example.corona;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.Activities.ContactUs;
import com.example.corona.Activities.ImportantNumbers;
import com.example.corona.Activities.QuestionsF;
import com.example.corona.ViewModels.CountriesViewModel;
import com.example.corona.adapters.CountryAdaapter;
import com.example.corona.model.Countries;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private CountriesViewModel viewModel;
    private RecyclerView recyclerView;
    private CountryAdaapter countryAdaapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  background.start();

        recyclerView = findViewById(R.id.countries_recyclerview);
        countryAdaapter = new CountryAdaapter();
        recyclerView.setAdapter(countryAdaapter);
        setupSwipe();


        Button tofavbtn = findViewById(R.id.to_fav_btn);
        tofavbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FavActivity.class));
            }
        });
        viewModel = new ViewModelProvider(this).get(CountriesViewModel.class);

        viewModel.getCountries();

        viewModel.getCountriesList().observe(this, new Observer<ArrayList<Countries>>() {
            @Override
            public void onChanged(ArrayList<Countries> countries) {
                countryAdaapter.setcountriesList(countries);

            }
        });


    }

    private void setupSwipe() {


        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull
                    RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipcountryposition = viewHolder.getAdapterPosition();
                Countries swipedcountries = countryAdaapter.getCountryAt(swipcountryposition);
                viewModel.insertCountry(swipedcountries);
                countryAdaapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "country added to data base", Toast.LENGTH_SHORT).show();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.main_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

               // compare(query);
      //      countryAdaapter.getFilter().filter(query);
//countries.getCountry();
//countryAdaapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {


                return false;
            }
        });
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_numbers:

                startActivity(new Intent(MainActivity.this, ImportantNumbers.class));

                return true;

            case R.id.main_q:
                startActivity(new Intent(MainActivity.this, QuestionsF.class));

                return true;

            case R.id.main_us:
                startActivity(new Intent(MainActivity.this, ContactUs.class));

                return true;


        }

        return false;
    }
//public void compare(String str){
//        Countries countries=new Countries();
//        ArrayList<Countries> countries1;
//        if (countries.getCountry().toString().toLowerCase()==str.toString())
//     //   return countryAdaapter.setcountriesList();
//}


//    Thread background = new Thread() {
//        public void run() {
//            try {
//                // Thread will sleep for 5 seconds
//                sleep(5*1000);
//
//                // After 5 seconds redirect to another intent
//                Intent i=new Intent(getBaseContext(),MainActivity.class);
//                startActivity(i);
//
//                //Remove activity
//                finish();
//            } catch (Exception e) {
//            }
//        }
//    };
    // start thread



}