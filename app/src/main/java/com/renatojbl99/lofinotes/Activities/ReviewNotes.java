package com.renatojbl99.lofinotes.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.renatojbl99.lofinotes.DataBase.DataHelper;
import com.renatojbl99.lofinotes.DataBase.FeedDB;
import com.renatojbl99.lofinotes.DataBase.Note;
import com.renatojbl99.lofinotes.LocalVariables;
import com.renatojbl99.lofinotes.R;

public class ReviewNotes extends AppCompatActivity {

    // Toolbar reviewToolbar;
    SwipeMenuListView listView;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_notes);

        listView = (SwipeMenuListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, LocalVariables.notesList.texts);

        listView.setAdapter(adapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // delete
                        deleteNote(position);
                        break;

                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });



    }

    @Override
    public void onBackPressed(){
        goToAddNoteActivity();
    }



    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                // TODO: Go to add note activity
                goToAddNoteActivity();
                break;

        }


        return true;

    }



    // TODO: Method to go to MainActivity
    private void goToReviewActivity(){
        Intent intentReview = new Intent(ReviewNotes.this, ReviewNotes.class);
        startActivity(intentReview);
        finish();
    }


    // TODO: Method to go to AddNoteActivity
    private void goToAddNoteActivity(){
        finish();
    }



    // TODO: Method to upload the text for each note
    private String getTextFromNoteById(int targetId){

        Note targetNote = new Note(targetId, getApplicationContext());
        // targetNote.loadAttributes(getApplicationContext());
        String targetText = targetNote.getText();

        System.out.println("*********************The text is: "+targetText); // TODO: Sending HINT message

        return targetText;

    }

    // TODO: Method to delete a note
    private void deleteNote(int position){

        LocalVariables.notesList.texts.remove(position);
        LocalVariables.notesList.modifications = true;
        adapter.notifyDataSetChanged();
        LocalVariables.notesList.pushArrayList(getApplicationContext());





    }
    // TODO: Method to modify a note
    private void modifyNote(){


    }
    // TODO: Method to accept a note
    private void acceptNote(){


    }


    // Method to know the number of entries
    public int getEntriesCount(Context context) {
        // TODO: Create the connection
        DataHelper conn = new DataHelper(context);
        SQLiteDatabase dbR = conn.getReadableDatabase();


        int count = (int) DatabaseUtils.queryNumEntries(dbR, FeedDB.NOTES_TABLE_NAME);
        dbR.close();
        return count;
    }











    /*
    // TODO: Method to update the data
    private void upLoadView(){


        LinearLayout dataContainer = new LinearLayout(getApplicationContext());
        dataContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        dataContainer.setOrientation(LinearLayout.VERTICAL);
        dataContainer.setGravity(Gravity.END);
        dataContainer.setTop(60);

        long entires = LocalVariables.getNumberOfNotes(getApplicationContext());

        //Create botones dinamicamente.

        // Create a connection
        DataHelper conn = new DataHelper(getApplicationContext());
        SQLiteDatabase dbR = conn.getReadableDatabase();

        try {
            Cursor cursor = dbR.rawQuery("SELECT * FROM "+FeedDB.NOTES_TABLE_NAME, null);

            int i;
            while(cursor.moveToNext()){
                i = cursor.getInt(0);
                System.out.println("*********************Iteration number: "+i); // TODO: Sending HINT message
                final int finalI = i;

                // LayoutInflater inflater = LayoutInflater.from(this);

                final LinearLayout noteContainer = (LinearLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.present_note,null);

                // View noteContainer = inflater.inflate(R.layout.present_note, null);

                // Instance the objects
                final TextView textView = (TextView) noteContainer.findViewById(R.id.reviewTv);
                Button btnDelete = (Button) noteContainer.findViewById(R.id.reviewBtnDelete);
                //Button btnAccept = (Button) noteContainer.findViewById(R.id.reviewBtnAccept);

                String textToShow = getTextFromNoteById(i);

                textView.setText(textToShow);
                if(textToShow == null){
                    System.out.println("*********************The text is null"); // TODO: Sending HINT message

                }else if (textToShow != null){
                    System.out.println("*********************The text is different from null"); // TODO: Sending HINT message


                    noteContainer.setTag(i);


                    btnDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            deleteNote(finalI);
                            goToReviewActivity();


                        }
                    });


                    btnAccept.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });



                    //Va agregegando botones al contenedor.
                    dataContainer.addView(noteContainer);

                }


            }

            //Crea contenedor para agregar contenedor de botones.
            ListView.LayoutParams paramsContainer = new ListView.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, Gravity.NO_GRAVITY);
            //Agrega contenedor con botones.
            addContentView(dataContainer, paramsContainer);


        } catch (Exception e){

        }



    }
    */




}
