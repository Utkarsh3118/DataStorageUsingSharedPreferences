package com.example.datastorageusingsharedpreferences;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName,etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etUsername);
        etPass = findViewById(R.id.etPassword);
    }

    public void saveData(View view)
    {
        SharedPreferences sharedPreferences= getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",etName.getText().toString());
        editor.putString("password",etPass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data was saved successfully at "+getFilesDir()+"/", Toast.LENGTH_SHORT).show();
    }

    public void nextActivity(View view)
    {
        Toast.makeText(this, "Next Activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,ActivityB.class);
        startActivity(intent);
      finish();
    }
}
