package com.example.menuexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Pickeractivity extends AppCompatActivity {
Spinner spCountryList;
ArrayList<String>CountriesList;
String[] countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickeractivity);
        spCountryList=findViewById(R.id.SpCountryList);
        //CountriesList = new ArrayList<>();
       // CountriesList=(ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.Countries));
        countries=getResources().getStringArray(R.array.Countries);
        ArrayAdapter<String> nAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, countries);
        spCountryList.setAdapter(nAdapter);
        spCountryList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Pickeractivity.this, countries[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
