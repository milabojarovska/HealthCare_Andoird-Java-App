package com.example.healthcare;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDatabase myDB;
    ArrayList<String> mealId,breakfastInput,lunchInput,dinnerInput,breakfastCalInput,lunchCalInput,dinnerCalInput;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // Store the item ID to avoid multiple method calls
                if (itemId == R.id.navigation_meal) {
                    // Open the AddMealActivity
                    Intent addMealIntent = new Intent(DashBoard.this, AddMeal.class);
                    startActivity(addMealIntent);
                    return true;
                } else if (itemId == R.id.navigation_dashboard) {
                    // Already in the dashboard, no action needed
                    return true;
                }
                return false;
            }
        });
// Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myDB = new MyDatabase(DashBoard.this);
        mealId = new ArrayList<>();
        breakfastInput = new ArrayList<>();
        lunchInput = new ArrayList<>();
        dinnerInput = new ArrayList<>();
        breakfastCalInput = new ArrayList<>();
        lunchCalInput = new ArrayList<>();
        dinnerCalInput = new ArrayList<>();
        storeDataInArrays();
         customAdapter = new CustomAdapter(DashBoard.this, mealId,breakfastInput,lunchInput,dinnerInput,breakfastCalInput,lunchCalInput,dinnerCalInput);
       recyclerView.setAdapter(customAdapter);
    }
    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                mealId.add(cursor.getString(0));
                breakfastInput.add(cursor.getString(3));
                lunchInput.add(cursor.getString(4));
                dinnerInput.add(cursor.getString(5));
                breakfastCalInput.add(cursor.getString(6));
                lunchCalInput.add(cursor.getString(7));
                dinnerCalInput.add(cursor.getString(8));
            }
        }
    }
}
