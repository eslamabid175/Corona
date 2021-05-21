package com.example.corona.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.R;
import com.example.corona.model.Countries;

import java.util.ArrayList;

public class CountryAdaapter  extends RecyclerView.Adapter<CountryAdaapter.AdapterViewHolder> {
        private ArrayList<Countries> countriesList=new ArrayList<>();
        @NonNull
        @Override
        public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.country_item,parent,false));

        }

        @Override
        public void onBindViewHolder(@NonNull CountryAdaapter.AdapterViewHolder holder, int position) {

            holder.nc.setText(countriesList.get(position).getNewConfirmed()+"");
            holder.tc.setText(countriesList.get(position).getTotalConfirmed()+"");
            holder.c.setText(countriesList.get(position).getCountry());
            holder.nd.setText(countriesList.get(position).getNewDeaths()+"");
            holder.td.setText(countriesList.get(position).getTotalDeaths()+"");
            holder.d.setText(countriesList.get(position).getDate());
            holder.nr.setText(countriesList.get(position).getNewRecovered()+"");
            holder.tr.setText(countriesList.get(position).getTotalRecovered()+"");
        }

        @Override
        public int getItemCount() {
            return countriesList.size();
        }
        public void setcountriesList(ArrayList<Countries> countriesList){

            this.countriesList=countriesList;
            notifyDataSetChanged();
        }
        public Countries getCountryAt(int position){
            return countriesList.get(position);
        }
        public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private     TextView nc,tc,c,nd,td,d,nr,tr;

            public AdapterViewHolder(@NonNull View itemView) {
                super(itemView);
                nc=itemView.findViewById(R.id.new_confirmed);
                tc=itemView.findViewById(R.id.total_confirmed);
                c=itemView.findViewById(R.id.country);
                nd=itemView.findViewById(R.id.new_deaths);
                td=itemView.findViewById(R.id.total_deaths);
                d=itemView.findViewById(R.id.date);
                nr=itemView.findViewById(R.id.new_recovered);
                tr=itemView.findViewById(R.id.total_recovered);


            }
        }
    }
