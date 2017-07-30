package com.api.databaseexample1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by iSaleem on 7/27/17.
 */

public class DB {
    private final Context context;
    MySQLiteDatabaseHelper mySQLiteDatabaseHelper;
    private SQLiteDatabase db;

    DB(Context context){
        mySQLiteDatabaseHelper = new MySQLiteDatabaseHelper(context,"mydb",null,4);
        this.context = context;
    }

    public DB open(){
        db = mySQLiteDatabaseHelper.getWritableDatabase();
        return this;
    }
    public DB addStudent(String studentName){
        db.beginTransaction();
        ContentValues values = new ContentValues();

        values.put(MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN,studentName);
        long id = db.insert(MySQLiteDatabaseHelper.STUDENT_TABLE,MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN,values);
        db.beginTransaction();
        return this;
    }

    public long addStudentMorePerformance(String studentName){
        SQLiteStatement sqLiteStatement = db.compileStatement(
                "insert into " + MySQLiteDatabaseHelper.STUDENT_TABLE +
                        "("+ MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN+ ")"
                        + " values(?)");
        sqLiteStatement.bindString(1,studentName);
        return sqLiteStatement.executeInsert();
    }

    public Cursor getStudents(){
        //Cursor cursor = db.rawQuery("select " + MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN + " from " + MySQLiteDatabaseHelper.STUDENT_TABLE ,null);
        Cursor cursor = db.rawQuery("select _id,STUDENT_NAME from " + MySQLiteDatabaseHelper.STUDENT_TABLE ,null);
        return cursor;
    }
    public Cursor getStudent(int id){
        Cursor cursor = db.rawQuery("select STUDENT_NAME from STUDENTS where ID = ?",new String[]{id+""});
        return cursor;
    }

    public int updateStudent(String studentId,String studentName){
        ContentValues values = new ContentValues();
        values.put(MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN,studentName);
        return db.update(MySQLiteDatabaseHelper.STUDENT_TABLE,
                values,MySQLiteDatabaseHelper.STUDENT_ID_COLUMN
                        + "=?",new String[]{studentId});
    }

    public int deleteStudent(String studentId){
        return db.delete(MySQLiteDatabaseHelper.STUDENT_TABLE,
                MySQLiteDatabaseHelper.STUDENT_ID_COLUMN + "=?" ,
                new String[]{studentId});
    }

    public void close(){
        db.close();
    }
}
