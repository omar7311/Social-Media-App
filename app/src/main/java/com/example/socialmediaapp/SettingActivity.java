package com.example.socialmediaapp;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class SettingActivity extends AppCompatActivity {
    Toolbar toolbar;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbar=findViewById(R.id.toolbar);
        spinner=findViewById(R.id.spinner);
        setSupportActionBar(toolbar);
        String[] spinnerItem={"A","B","C","D"};
        ArrayAdapter myadapter=new ArrayAdapter(this,R.layout.spinner_item,spinnerItem);
       spinner.setAdapter(myadapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(SettingActivity.this,spinnerItem[position], Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }
}