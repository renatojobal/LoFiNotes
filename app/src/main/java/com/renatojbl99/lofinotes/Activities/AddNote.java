package com.renatojbl99.lofinotes.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.renatojbl99.lofinotes.DataBase.Note;
import com.renatojbl99.lofinotes.LocalVariables;
import com.renatojbl99.lofinotes.R;

public class AddNote extends AppCompatActivity {

    // Instantiate the elements of the screen
    AutoCompleteTextView addNoteATvNote;
    //Button addNoteBtnAdd;
    FloatingActionButton addFbtnAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);




        // Assign a value to the elements
        addNoteATvNote = (AutoCompleteTextView) findViewById(R.id.addNoteATvNote);
        //addNoteBtnAdd = (Button) findViewById(R.id.addNoteBtnAdd);
        addFbtnAdd = (FloatingActionButton) findViewById(R.id.addFbtnAdd);

        /* Create the button listener
        addNoteBtnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // Getting the text
                String text = addNoteATvNote.getText().toString();

                addNoteToDataBase(text);

                addNoteATvNote.setText("");

            }
        });*/

        // TODO: Create the floating button listener
        addFbtnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                // Getting the text
                String text = addNoteATvNote.getText().toString();
                if(text.equals("") == false) {
                    addNoteToDataBase(text);

                    addNoteATvNote.setText("");
                }

            }
        });




    }




    // Method to go to MainActivity
    public void goToMainActivity(){
        Intent intentMain = new Intent(AddNote.this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }


    // Method to go to ReviewNotes
    public void goToReviewNotesActivity(){
        Intent intentReview = new Intent(AddNote.this, ReviewNotes.class);
        startActivity(intentReview);

    }

    // Method to add a idea to the data base
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addNoteToDataBase(String text){
        String newText = validateSigns(text);
        Note note = new Note(newText);
        note.save(getApplicationContext());

        LocalVariables.notesList.texts.add(newText);
        LocalVariables.notesList.modifications = true;

    }

    @Override
    public void onBackPressed(){
        //goToMainActivity();
        finish();
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        /*switch (menuItem.getItemId()){
            case R.id.review:
                // Todo: Go to Review Activity
                goToRevieNotesActivity();
                break;
        }


        return true;*/

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.review) {


            // Todo: Go to Review Activity
            goToReviewNotesActivity();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // TODO: Method to validate all the text. Its like a filter
    public String validateSigns(String text){
        String newText="";
        newText = text.replace(" comando punto seguido ", ". ");
        newText = newText.replace(" comando punto final", ". ");
        newText = newText.replace(" comando punto aparte ", ".\n");
        newText = newText.replace(" comando punto y aparte ", ".\n");
        newText = newText.replace(" comando coma ", ", ");
        newText = newText.replace("comando comillas ", "''");
        newText = newText.replace("Comando comillas ", "''");
        newText = newText.replace(" comando punto y coma ", "; ");
        newText = newText.replace(" comando dos puntos ", ": ");
        newText = newText.replace("comando pregunta", " Pregunta : ");
        newText = newText.replace("Comando pregunta", " Pregunta : ");
        newText = newText.replace("comando abre pregunta", " Pregunta : ");
        newText = newText.replace("Comando abre pregunta", " Pregunta : ");
        newText = newText.replace(" comando cierra pregunta ", "? ");
        newText = newText.replace(" Comando cierra pregunta ", "? ");
        newText = newText.replace(" comando sierra pregunta ", "? ");
        newText = newText.replace(" Comando sierra pregunta ", "? ");


        newText = newText.replace(" Comando Punto Final", ". ");
        newText = newText.replace(" Comando Punto Aparte ", ".\n");
        newText = newText.replace(" Comando Punto y Aparte ", ".\n");
        newText = newText.replace(" Comando Coma ", ", ");
        newText = newText.replace("Comando Comillas ", "''");
        newText = newText.replace("Comando Comillas ", "''");
        newText = newText.replace(" Comando Punto y Coma ", "; ");
        newText = newText.replace(" Comando Dos Puntos ", ": ");
        newText = newText.replace("Comando Pregunta", " Pregunta : ");
        newText = newText.replace("Comando Pregunta", " Pregunta : ");
        newText = newText.replace("Comando Abre Pregunta", " Pregunta : ");
        newText = newText.replace("Comando Abre Pregunta", " Pregunta : ");
        newText = newText.replace(" Comando Cierra Pregunta ", "? ");
        newText = newText.replace(" Comando Cierra Pregunta ", "? ");
        newText = newText.replace(" Comando Sierra Pregunta ", "? ");
        newText = newText.replace(" Comando Sierra Pregunta ", "? ");







        return newText;
    }



}
