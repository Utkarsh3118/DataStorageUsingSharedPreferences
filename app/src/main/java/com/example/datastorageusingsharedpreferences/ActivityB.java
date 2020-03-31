package com.example.datastorageusingsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    private static final String CONSTANT = "N/A";
    private TextView tvName,tvPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tvName = findViewById(R.id.receivedName);
        tvPassword = findViewById(R.id.receivedPassword);

    }

    public void loadData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("MyData",MODE_PRIVATE);
        String name = sharedPreferences.getString("name",CONSTANT);
        String password = sharedPreferences.getString("password",CONSTANT);
        if(name.equals(CONSTANT)||name.equals(CONSTANT))
        {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data loaded Successfully", Toast.LENGTH_SHORT).show();
            tvName.setText(name);
            tvPassword.setText(password);
        }
    }

    public void previousActivity(View view)
    {

        Toast.makeText(this, "Going to previous activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ActivityB.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}
