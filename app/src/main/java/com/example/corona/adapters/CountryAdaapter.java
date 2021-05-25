package com.example.corona.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.R;
import com.example.corona.model.Countries;

import java.util.ArrayList;
import java.util.Collection;

public class CountryAdaapter  extends RecyclerView.Adapter<CountryAdaapter.AdapterViewHolder> implements Filterable {
        private ArrayList<Countries> countriesList=new ArrayList<>();
        ArrayList<Countries>countriesArrayListAll;
        @NonNull
        @Override
        public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterViewHolder(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.country_item,parent,false));

        }

    public CountryAdaapter() {
    }

    public CountryAdaapter(ArrayList<Countries> countriesList) {
        this.countriesList = countriesList;
        this.countriesArrayListAll=new ArrayList<>(countriesList);
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

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
      ArrayList<Countries>filterdlist=new ArrayList<>();
      if (constraint.toString().isEmpty()){


          filterdlist.addAll(countriesArrayListAll);

      }else {

for (Countries countries: countriesArrayListAll){

    if (countries.getCountry().toLowerCase().contains(constraint.toString().toLowerCase())){

        filterdlist.add(countries);
    }
}

      }
FilterResults filterResults=new FilterResults();
      filterResults.values=filterdlist;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
countriesList.clear();
countriesList.addAll((Collection<? extends Countries>) results.values);
        notifyDataSetChanged();
        }
    };

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
