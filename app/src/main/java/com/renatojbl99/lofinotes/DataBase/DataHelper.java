package com.renatojbl99.lofinotes.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    // Constructor
    public DataHelper(Context context) {
        super(context, FeedDB.DATA_BASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(FeedDB.CREATE_NOTES_TABLE);
        System.out.println("\n\n\nTABLES CREATED WITH SUCCESS");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL(FeedDB.DROP_TABLE+ FeedDB.NOTES_TABLE_NAME);
        onCreate(database);
    }

    @Override
    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        super.onDowngrade(database, oldVersion, newVersion);
    }
}
