package com.renatojbl99.lofinotes;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.renatojbl99.lofinotes.DataBase.DataHelper;
import com.renatojbl99.lofinotes.DataBase.FeedDB;
import com.renatojbl99.lofinotes.DataBase.NotesList;

public class LocalVariables {

    //public static long numberOfNotes=0;

    public static long getNumberOfNotes(Context context){
        // TODO: Create the connection
        DataHelper conn = new DataHelper(context);
        SQLiteDatabase dbR = conn.getReadableDatabase();


        long count = DatabaseUtils.queryNumEntries(dbR, FeedDB.NOTES_TABLE_NAME);
        dbR.close();
        return count;
    }


    //
    public static NotesList notesList;



}
