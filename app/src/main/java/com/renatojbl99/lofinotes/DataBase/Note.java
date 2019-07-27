package com.renatojbl99.lofinotes.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Note {
    // Attributes
    private long noteId;
    private String text;


    // Priority attributes
    private boolean created = false;
    private boolean saved = false;


    // Constructor for a saved note with with id
    public Note(long noteId, Context context) {
        setNoteId(noteId);
        setCreated(true);
        setSaved(true);

        loadAttributes(context);

    }


    // Constructor for an unsaved note
    public Note(String text) {
        setText(text);

        setCreated(true);
        setSaved(false); // Cause it is not into the data base

    }


    // Methods set
    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }


    // Methods get
    public long getNoteId() {
        return noteId;
    }

    public String getText() {
        return text;
    }

    public boolean isCreated() {
        return created;
    }

    public boolean isSaved() {
        return saved;
    }

    // Method to save the note into the database
    public void save(Context context){
        if (isCreated() && isSaved()==false) {
            // TODO: Create the connection
            DataHelper connUser = new DataHelper(context);
            SQLiteDatabase dbW = connUser.getWritableDatabase();

            // TODO: Insert the values
            ContentValues valuesForNote = new ContentValues();
            valuesForNote.put(FeedDB.N_COLUMN_TEXT, getText());


            // TODO: Insert the values into the data Base
            Long idResult = dbW.insert(FeedDB.NOTES_TABLE_NAME, FeedDB.N_COLUMN_NOTE_ID, valuesForNote);
            this.setNoteId(idResult);

            // TODO: Send succeed message
            System.out.println("++++++++++++++++++++++++Note saved with succeed.");
            Toast.makeText(context, "Note saved!", Toast.LENGTH_SHORT).show();



            this.setSaved(true);

            dbW.close();

        } else {
            // TODO: Send message error
            System.out.println("++++++++++++++++++++++++The note already has been saved.");
        }
    }

    // Method to create a new update
    public void loadAttributes(Context context){
        if (isCreated() && isSaved()) {
            // TODO: Create the connection
            DataHelper conn = new DataHelper(context);
            SQLiteDatabase dbR = conn.getReadableDatabase();

            // TODO: Set the arguments of search
            String [] projection = {FeedDB.N_COLUMN_TEXT};     // The elements that cursor returns
            String [] argsel = {getNoteId()+""};                                     // What is going to look for
            String selection = FeedDB.N_COLUMN_NOTE_ID+"=?";                         // In what column it is going to search


            try {
                Cursor cursor = dbR.query(FeedDB.NOTES_TABLE_NAME, projection, selection, argsel, null, null, null);  // Consulta

                cursor.moveToFirst();

                String lastText = cursor.getString(0);

                setText(lastText);

                dbR.close();

                // TODO: Send succeed message
                System.out.println("++++++++++++++++++++++++Attributes had been load with succeed.");

            } catch (Exception e){ // TODO: if something went wrong

                // TODO: Send message error
                System.out.println("------------------------'Catch' at method 'loadAttributes' at class 'Note': the note id had not been found.");
                System.out.println(e);

            }

        } else {

            // TODO: Send message error
            System.out.println("------------------------'Else' at method 'loadAttributes' at class 'Note': the note had not been saved yet in order to load the attributes.");

        }




    }




    public void deleteNote(Context context){
        if (isCreated() && isSaved()) {
            // TODO: Create the connection
            DataHelper conn = new DataHelper(context);
            SQLiteDatabase dbW = conn.getWritableDatabase();

            // TODO: Set the arguments of search
            String [] argsel = {getNoteId()+""};
            String selection = FeedDB.N_COLUMN_NOTE_ID+"=?";


            try {
                int count = dbW.delete(FeedDB.NOTES_TABLE_NAME, selection, argsel);

                setSaved(false);

                // TODO: Send succeed message
                System.out.println("++++++++++++++++++++++++The note had been deleted with succeed.");
                dbW.close();
            } catch (Exception e){ // TODO: if note doesn't exist
                // TODO: Send message error
                System.out.println("------------------------'Catch' at method 'deleteNote' at class 'Note': The target note could not been found.");
                System.out.println(e);



            }

        } else {
            // TODO: Send message error
            System.out.println("------------------------'Else' at method 'deleteNote' at class 'Note': The target note appear like don't saved into the data base.");

        }

    }




}
