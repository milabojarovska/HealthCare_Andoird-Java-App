package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class AddMeal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // Store the item ID to avoid multiple method calls
                if (itemId == R.id.navigation_meal) {
                    // Open the AddMealActivity
                    Intent addMealIntent = new Intent(AddMeal.this, AddMeal.class);
                    startActivity(addMealIntent);
                    return true;
                } else if (itemId == R.id.navigation_dashboard) {
                    Intent addDashboardIntent = new Intent(AddMeal.this, DashBoard.class);
                    startActivity(addDashboardIntent);
                    return true;
                } else if (itemId == R.id.navigation_activity) {
                    // Handle the activity menu item click
                    // For example, open an AddActivity
                    Intent addActivityIntent = new Intent(AddMeal.this, AddActivity.class);
                    startActivity(addActivityIntent);
                    return true;
                }
                return false;
            }
        });
    }
}