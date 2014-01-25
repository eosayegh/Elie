package com.example.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;


import java.sql.Array;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.*;
import java.lang.Object;
import android.os.Environment;



/**
 * Created by Elie on 1/24/14.
 */
public class Upload extends Activity implements View.OnClickListener {

 public Spinner spClasses;
 ImageView iv;
 Button btnPic;
 ImageButton ib;
 Bitmap bmp;
 Intent i;
 final static int cameraData = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);

        initialize();
        InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
        bmp = BitmapFactory.decodeStream(is);

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

    private void initialize() {
        iv = (ImageView) findViewById(R.id.imgView);
        ib = (ImageButton) findViewById(R.id.ib);
        btnPic = (Button) findViewById(R.id.btnPic);
        btnPic.setOnClickListener(this);
        ib.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ib:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cameraData);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");

           /* ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, 40, bytes);

//you can create a new file name "test.jpg" in sdcard folder.
            File f = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "test.jpg");

            f.createNewFile();

//write the bytes in file
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());

// remember close de FileOutput
            fo.close();*/

            iv.setImageBitmap(bmp);

        }
    }
}
