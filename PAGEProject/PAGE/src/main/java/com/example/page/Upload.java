package com.example.page;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by Elie on 1/24/14.
 */
public class Upload extends  MainActivity {

 public Spinner spClasses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);

        Spinner spMajor;


        //Create Major Array List
        final ArrayList<String> majArray = new ArrayList<String>();
        majArray.add("Civil Engineering");
        majArray.add("Computer Science");
        majArray.add("Mathematics");



        //Call and Load Spinner
        spMajor = (Spinner) findViewById(R.id.spMajor);
        ArrayAdapter<String> spinnerArrayAdapterMajor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, majArray);
        spMajor.setAdapter(spinnerArrayAdapterMajor);




        spMajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin(i);
            }
        });

    }

    public void spin(int ii) {
        final ArrayList<String> classesCE = new ArrayList<String>();
        final ArrayList<String> classesCS = new ArrayList<String>();
        final ArrayList<String> classesMT = new ArrayList<String>();

        //Prepare Classes Arrays
        classesCE.add("CE 476 Bridge Engineering");
        classesCE.add("CE 433 Timber Design");

        classesCS.add("CS 130 Discrete..");
        classesCS.add("CS 140 Introduction to Java");

        classesMT.add("MATH 224 Linear Algebra");
        classesMT.add("MATH 430 Euclidean Geometry ");

        if(ii==0){
            spClasses = (Spinner) findViewById(R.id.spClass);
            ArrayAdapter<String> spinnerArrayAdapterClasses = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classesCE);
            spClasses.setAdapter(spinnerArrayAdapterClasses);}
        else if(ii==1){
            spClasses = (Spinner) findViewById(R.id.spClass);
            ArrayAdapter<String> spinnerArrayAdapterClasses = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classesCS);
            spClasses.setAdapter(spinnerArrayAdapterClasses);}
        else if(ii==2){
            spClasses = (Spinner) findViewById(R.id.spClass);
            ArrayAdapter<String> spinnerArrayAdapterClasses = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classesMT);
            spClasses.setAdapter(spinnerArrayAdapterClasses);}

    }



}
