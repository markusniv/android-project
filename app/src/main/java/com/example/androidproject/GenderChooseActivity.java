package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

/***
 * Activity that is ran the first time user launches the app. Lets the user pick their gender
 * which is then used for the calculations the app does.
 */

public class GenderChooseActivity extends AppCompatActivity {
    public static final String EXTRA = "com.example.androidproject.EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_choose);
    }

    public void buttonClick(View v) {

        Bundle bundle = getIntent().getExtras();
        String prefs = bundle.getString(MainActivity.EXTRA, null);
        SharedPreferences prefGet = getSharedPreferences(prefs, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefGet.edit();

        if (v == findViewById(R.id.maleButton)) {
            prefEdit.putString("GENDER_KEY", "Male");
        }
        if (v == findViewById(R.id.femaleButton)) {
            prefEdit.putString("GENDER_KEY", "Female");
        }
        prefEdit.putBoolean("FIRST_USER_LAUNCH", false);
        prefEdit.commit();
        Intent backToMain = new Intent(GenderChooseActivity.this, MainActivity.class);
        startActivity(backToMain);
    }
}
