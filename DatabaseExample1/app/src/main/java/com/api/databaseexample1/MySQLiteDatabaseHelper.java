package com.api.databaseexample1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iSaleem on 7/27/17.
 */

public class MySQLiteDatabaseHelper extends SQLiteOpenHelper{

    public static final String STUDENT_TABLE  = "STUDENTS";
    public static final String STUDENT_NAME_COLUMN  = "STUDENT_NAME";
    public static final String STUDENT_ID_COLUMN  = "_id";


    public MySQLiteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + " ( " + STUDENT_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                ","+ STUDENT_NAME_COLUMN + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENTS ");
        this.onCreate(db);
    }
}
