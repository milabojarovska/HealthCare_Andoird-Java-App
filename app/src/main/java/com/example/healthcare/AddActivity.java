package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // Store the item ID to avoid multiple method calls
                if (itemId == R.id.navigation_meal) {
                    // Open the AddMealActivity
                    Intent addMealIntent = new Intent(AddActivity.this, AddMeal.class);
                    startActivity(addMealIntent);
                    return true;
                } else if (itemId == R.id.navigation_dashboard) {
                    Intent addDashboardIntent = new Intent(AddActivity.this, DashBoard.class);
                    startActivity(addDashboardIntent);
                    return true;
                } else if (itemId == R.id.navigation_activity) {
                    // Handle the activity menu item click
                    // For example, open an AddActivity
                    Intent addActivityIntent = new Intent(AddActivity.this, AddActivity.class);
                    startActivity(addActivityIntent);
                    return true;
                }
                return false;
            }
        });
    }
}