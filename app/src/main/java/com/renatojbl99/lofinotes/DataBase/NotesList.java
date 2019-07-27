package com.renatojbl99.lofinotes.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotesList {

    // Attributes

    public ArrayList<String> texts = new ArrayList<>();
    public Boolean modifications = false;


    public NotesList(Context context){
        this.pullArrayList(context);
    }


    // TODO: Method to update the local hashmap
    public void pullArrayList(Context context){
        // Create a connection to the data base
        DataHelper connRecord = new DataHelper(context);
        SQLiteDatabase dbR = connRecord.getReadableDatabase();


        try{

            Cursor cursor = dbR.rawQuery("SELECT * FROM "+ FeedDB.NOTES_TABLE_NAME, null);

            while (cursor.moveToNext()){

                // int noteId = cursor.getInt(0);
                String noteText = cursor.getString(1);

                // Todo: Actualize the hashmap
                texts.add(noteText);
            }
            dbR.close();


        }catch (Exception e){
            System.out.println("Error!: "+e);

        }


    }

    // TODO: Method to write the has map information in to the data base
    public void pushArrayList(Context context){
        if(texts.isEmpty() == false && modifications == true) {
            // Create a connection to the data base
            DataHelper connRecord = new DataHelper(context);
            SQLiteDatabase dbW = connRecord.getWritableDatabase();


            try {

                dbW.delete(FeedDB.NOTES_TABLE_NAME,null,null);  // Todo: Delete all the existing entries

                for(int i = 0; i < texts.size(); i++){
                    // Todo: Create the values
                    ContentValues values = new ContentValues();
                    values.put(FeedDB.N_COLUMN_TEXT, texts.get(i));

                    Long idResult = dbW.insert(FeedDB.NOTES_TABLE_NAME, FeedDB.N_COLUMN_NOTE_ID, values);
                }


                dbW.close();





            } catch (Exception e) {
                System.out.println("Error!: " + e);

            }
        }

    }











}
