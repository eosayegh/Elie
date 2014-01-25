package com.example.page;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Elie on 1/24/14.
 */
public class Upload extends  MainActivity {

    public Spinner spMajor;
    public String selectedMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);


        ArrayList<String> majArray = new ArrayList<String>();
        majArray.add("Civil Engineering");
        majArray.add("Computer Science");

        spMajor = (Spinner) findViewById(R.id.spMajor);
        ArrayAdapter<String> spinnerArrayAdapterMajor = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, majArray);
        spMajor.setAdapter(spinnerArrayAdapterMajor);


        ArrayList<String> classArray = new ArrayList<String>();
        classArray.add("Civil Engineering");
        classArray.add("Computer Science");

        Spinner spClass  = (Spinner) findViewById(R.id.spClass);
        ArrayAdapter<String> spinnerArrayAdapterClass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,classArray);
        spClass.setAdapter(spinnerArrayAdapterClass);
    }


}
