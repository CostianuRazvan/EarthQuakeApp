package com.example.zarnea.earthquakeapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zarnea.earthquakeapp.Models.EarthQuake;

import java.util.ArrayList;


public class EarthQuakeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    Activity activity;
    ArrayList<EarthQuake> list;
    Resources resources;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.earthquake, null);
        viewHolder=new EarthQuakeAdapter.EarthQuakesCards(view);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EarthQuakesCards extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView date;
        View view;

        public EarthQuakesCards(View view) {
            super(view);
            this.view = view;
            this.name =(TextView) view.findViewById(R.id.sponsors);
            this.date =(TextView) view.findViewById(R.id.scrollView);



            // Set name and picture for the first user of the event
            //view.setBackgroundColor(Color.parseColor("#FFFFFF"));

            final View currView = view;


        }

    }

    public EarthQuakeAdapter(ArrayList<EarthQuake> list, Context context, Activity activity, Resources resources){
        this.list = list;
        this.context = context;
        this.activity = activity;
        this.resources = resources;
    }
}
