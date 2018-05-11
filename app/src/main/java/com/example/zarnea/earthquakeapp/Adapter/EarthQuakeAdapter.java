package com.example.zarnea.earthquakeapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zarnea.earthquakeapp.CardDetailsActivity;
import com.example.zarnea.earthquakeapp.Models.EarthQuake;
import com.example.zarnea.earthquakeapp.R;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


public class EarthQuakeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    Activity activity;
    ArrayList<EarthQuake> list;
    Resources resources;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public EarthQuakeAdapter(ArrayList<EarthQuake> list, Context context, Activity activity, Resources resources){
         list.sort(new Comparator<EarthQuake>() {
            @Override
            public int compare(EarthQuake o1, EarthQuake o2) {
                if(o1.getDate() < o2.getDate()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
         this.list = list;
        this.context = context;
        this.activity = activity;
        this.resources = resources;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == 1) {
            View view;

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.earthquake, null);
            viewHolder = new EarthQuakeAdapter.EarthQuakesCards(view);
        }

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder,final int position) {
        ((EarthQuakesCards)holder).name.setText(list.get(position).getLocation());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ((EarthQuakesCards)holder).date.setText(sdf.format(list.get(position).getDate()));
        ((EarthQuakesCards) holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(context, CardDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("location",list.get(position).getLocation());
                bundle.putDouble("magnitude",list.get(position).getMagnitude());
                bundle.putString("date",((EarthQuakesCards)holder).date.getText().toString());
                bundle.putString("alert",list.get(position).getAlert());
                bundle.putInt("tsunami",list.get(position).getTsunami());
                bundle.putString("eventUrl",list.get(position).getEventUrl());
                i.putExtra("data", bundle);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EarthQuakesCards extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView date;
        View view;

        public EarthQuakesCards(View view) {
            super(view);
            this.view = view;
            this.name =(TextView) view.findViewById(R.id.name);
            this.date =(TextView) view.findViewById(R.id.date);



            // Set name and picture for the first user of the event
            //view.setBackgroundColor(Color.parseColor("#FFFFFF"));

            final View currView = view;


        }

    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }


}
