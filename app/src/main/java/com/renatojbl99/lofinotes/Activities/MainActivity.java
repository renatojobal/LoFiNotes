package com.renatojbl99.lofinotes.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.renatojbl99.lofinotes.DataBase.DataHelper;
import com.renatojbl99.lofinotes.DataBase.NotesList;
import com.renatojbl99.lofinotes.LocalVariables;
import com.renatojbl99.lofinotes.R;

public class MainActivity extends Activity {

    RelativeLayout mainRL;
    ImageView imageView;

    // TODO: To Create the database
    DataHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Create the database
        conn = new DataHelper(getApplicationContext());

        LocalVariables.notesList = new NotesList(getApplicationContext());
        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                goToAddNote();

            }
        }, 3000); */


        mainRL = (RelativeLayout) findViewById(R.id.mainRL);
        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddNote();
            }
        });

        mainRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddNote();
            }
        });

    }

    // Method to go to add note
    private void goToAddNote(){
        Intent intentAdd = new Intent(MainActivity.this, AddNote.class);
        startActivity(intentAdd);

    }

    //Todo: Method


}
