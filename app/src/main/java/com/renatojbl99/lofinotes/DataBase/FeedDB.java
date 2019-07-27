package com.renatojbl99.lofinotes.DataBase;

public class FeedDB {

// TODO: DataHelper Entries
    public static final String DATA_BASE_NAME = "LoFiNotes";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS ";

// Todo: Note Table

    public static final String NOTES_TABLE_NAME = "Notes";
    public static final String N_COLUMN_NOTE_ID = "NoteId";
    public static final String N_COLUMN_TEXT = "Text";

    // Todo: Create table Note
    public static final String CREATE_NOTES_TABLE = "CREATE TABLE `"+ NOTES_TABLE_NAME +"` (`" +
            N_COLUMN_NOTE_ID+"` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, `"+
            N_COLUMN_TEXT+"` TEXT NOT NULL" +
            ");";





/*
// Todo: Note Table

    public static final String NOTES_TABLE_NAME = "Note";
    public static final String N_COLUMN_NOTE_ID = "NoteId";
    public static final String N_COLUMN_MODIFICATIONS = "Modifications";

    // Todo: Create table Note
    public static final String CREATE_NOTES_TABLE = "CREATE TABLE `"+ NOTES_TABLE_NAME +"` (`" +
            N_COLUMN_NOTE_ID+"` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, `"+
            N_COLUMN_MODIFICATIONS+"` INTEGER NOT NULL"+
            ");";



// Todo: Modifications Table

    public static final String MODIFICATIONS_TABLE_NAME = "Modifications";
    public static final String M_COLUMN_MODIFI_ID = "ModificationsId";
    public static final String M_COLUMN_NOTE_ID = "NoteId"; // Foreign key
    public static final String M_COLUMN_TEXT = "Text";
    public static final String M_COLUMN_DATE = "Date";


    // Todo: Create table Modifications
    public static final String CREATE_MODIFICATIONS_TABLE = "CREATE TABLE `"+ MODIFICATIONS_TABLE_NAME +"` (`" +
            M_COLUMN_MODIFI_ID+"` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, `"+
            M_COLUMN_NOTE_ID+"` INTEGER NOT NULL, `" +
            M_COLUMN_TEXT+"` TEXT NOT NULL, `" +
            M_COLUMN_DATE+"` TEXT NOT NULL" +
            ");";

*/





}
