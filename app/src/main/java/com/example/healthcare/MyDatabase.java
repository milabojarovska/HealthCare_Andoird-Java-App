package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "HealthCare.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_HEALTH ="my_healthcare";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_HEIGHT = "user_height";
    private static final String COLUMN_WEIGHT = "user_weight";
    private static final String COLUMN_BREAKFAST = "user_breakfast";
    private static final String COLUMN_LUNCH = "user_lunch";
    private static final String COLUMN_DINNER = "user_dinner";
    private static final String COLUMN_BCAL = "user_bcal";
    private static final String COLUMN_LCAL = "user_lcal";
    private static final String COLUMN_DCAL = "user_dcal";



    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createHealthTableQuery  = "CREATE TABLE " + TABLE_NAME_HEALTH +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_HEIGHT + " INTEGER, " +
                        COLUMN_WEIGHT + " INTEGER, " +
                        COLUMN_BREAKFAST + " TEXT, " +
                        COLUMN_LUNCH + " TEXT, " +
                        COLUMN_DINNER + " TEXT, " +
                        COLUMN_BCAL + " INTEGER, " +
                        COLUMN_LCAL + " INTEGER, " +
                        COLUMN_DCAL + " INTEGER);";
        db.execSQL(createHealthTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_HEALTH);
        onCreate(db);
    }

    public void addMealsInfo(int height, int weight, String breakfast, String lunch, String dinner,int bCal, int lCal, int dCal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_HEIGHT, height);
        cv.put(COLUMN_WEIGHT, weight);
        cv.put(COLUMN_BREAKFAST, breakfast);
        cv.put(COLUMN_LUNCH, lunch);
        cv.put(COLUMN_DINNER, dinner);
        cv.put(COLUMN_BCAL, bCal);
        cv.put(COLUMN_LCAL, lCal);
        cv.put(COLUMN_DCAL, dCal);
        long result = db.insert(TABLE_NAME_HEALTH, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME_HEALTH;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
