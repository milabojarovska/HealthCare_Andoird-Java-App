package com.example.healthcare;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;

    private ArrayList  mealId,breakfastInput,lunchInput,dinnerInput,breakfastCalInput,lunchCalInput,dinnerCalInput;

    CustomAdapter(Context context, ArrayList mealId, ArrayList breakfastInput,ArrayList lunchInput,ArrayList dinnerInput,ArrayList breakfastCalInput,ArrayList lunchCalInput,ArrayList dinnerCalInput){
        this.context = context;
        this.mealId = mealId;
        this.breakfastInput = breakfastInput;
        this.lunchInput = lunchInput;
        this.dinnerInput = dinnerInput;
        this.breakfastCalInput = breakfastCalInput;
        this.lunchCalInput = lunchCalInput;
        this.dinnerCalInput = dinnerCalInput;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_card, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mealId_txt.setText(String.valueOf(mealId.get(position)));
        holder.breakfastInput_txt.setText(String.valueOf(breakfastInput.get(position)));
        holder.lunchInput_txt.setText(String.valueOf(lunchInput.get(position)));
        holder.dinnerInput_txt.setText(String.valueOf(dinnerInput.get(position)));
        holder.breakfastCalInput_txt.setText(String.valueOf(breakfastCalInput.get(position)));
        holder.lunchCalInput_txt.setText(String.valueOf(lunchCalInput.get(position)));
        holder.dinnerCalInput_txt.setText(String.valueOf(dinnerCalInput.get(position)));

        int breakfastCalories = parseCalories(String.valueOf(breakfastCalInput.get(position)));
        int lunchCalories = parseCalories(String.valueOf(lunchCalInput.get(position)));
        int dinnerCalories = parseCalories(String.valueOf(dinnerCalInput.get(position)));

        int totalCalories = breakfastCalories + lunchCalories + dinnerCalories;
        holder.max_calories.setText("Max Calories: " + totalCalories + " Cal");
    }



    @Override
    public int getItemCount() {
        return mealId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mealId_txt,breakfastInput_txt,lunchInput_txt,dinnerInput_txt,breakfastCalInput_txt,lunchCalInput_txt,dinnerCalInput_txt,max_calories;


        @SuppressLint("WrongViewCast")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mealId_txt= itemView.findViewById(R.id.mealId_txt);
            breakfastInput_txt= itemView.findViewById(R.id.breakfastInput_txt);
            lunchInput_txt= itemView.findViewById(R.id.lunchInput_txt);
            dinnerInput_txt= itemView.findViewById(R.id.dinnerInput_txt);
            breakfastCalInput_txt= itemView.findViewById(R.id.breakfastCalInput_txt);
            lunchCalInput_txt= itemView.findViewById(R.id.lunchCalInput_txt);
            dinnerCalInput_txt= itemView.findViewById(R.id.dinnerCalInput_txt);
            max_calories= itemView.findViewById(R.id.max_calories);
        }
    }

    private int parseCalories(String calorieText) {
        return Integer.parseInt(calorieText.split(" ")[0]);
    }
}