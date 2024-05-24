package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class AddMeal extends AppCompatActivity {

    EditText height_input,weight_input,breakfastInput,lunchInput,dinnerInput,breakfastCalInput,lunchCalInput,dinnerCalInput;
    Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        height_input = findViewById(R.id.height_input);
        weight_input = findViewById(R.id.weight_input);
        breakfastInput = findViewById(R.id.breakfastInput);
        breakfastCalInput = findViewById(R.id.breakfastCalInput);
        lunchInput = findViewById(R.id.lunchInput);
        lunchCalInput = findViewById(R.id.lunchCalInput);
        dinnerInput = findViewById(R.id.dinnerInput);
        dinnerCalInput = findViewById(R.id.dinnerCalInput);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabase myDB = new MyDatabase(AddMeal.this);
                myDB.addMealsInfo(Integer.valueOf(height_input.getText().toString().trim()),
                        Integer.valueOf(weight_input.getText().toString().trim()),
                        breakfastInput.getText().toString().trim(),
                        lunchInput.getText().toString().trim() ,
                        dinnerInput.getText().toString().trim() ,
                        Integer.valueOf(breakfastCalInput.getText().toString().trim()),
                        Integer.valueOf(lunchCalInput.getText().toString().trim()),
                        Integer.valueOf(dinnerCalInput.getText().toString().trim()));
            }
        });

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
                }
                return false;
            }
        });
    }
}