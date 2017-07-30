package com.api.databaseexample1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lst = (ListView)findViewById(R.id.lst);

        //MySQLiteDatabaseHelper db = new MySQLiteDatabaseHelper(this,"mydb",null,1);
        //SQLiteDatabase database = db.getWritableDatabase();

        //ContentValues values = new ContentValues();
        //values.put("Student_NAME","ahmed");
        
        //database.insert("STUDENTS",null,values);
        


        //database.close();

        DB db = new DB(this);
        db.open();
        db.addStudent("ahmed");
        Cursor cursor = db.getStudents();
        //cursor.moveToFirst();
        //String name = cursor.getString(cursor.getColumnIndex("STUDENT_NAME"));
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        // old fashion
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        while(cursor.moveToNext()) {

            String name2 = cursor.getString(cursor.getColumnIndex("STUDENT_NAME"));
            adapter.add(name2);
            Toast.makeText(this, name2, Toast.LENGTH_SHORT).show();
        }

        lst.setAdapter(adapter);
        */

        /*
        int affectedRows = db.updateStudent("1","hassan");
        Toast.makeText(this, affectedRows + "", Toast.LENGTH_SHORT).show();
        */

        /*
        int affectedRows = db.deleteStudent("1");
        Toast.makeText(this, affectedRows + "", Toast.LENGTH_SHORT).show();
        */

        /*
        long id = db.addStudentMorePerformance("yousef");
        Toast.makeText(this, id + "", Toast.LENGTH_SHORT).show();

*/

        /*
        String[] from = {
                MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN};

        int[] to = {android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,android.R.layout.simple_list_item_1,
                db.getStudents(),from,to,
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        */

        String[] from = {MySQLiteDatabaseHelper.STUDENT_ID_COLUMN,
                MySQLiteDatabaseHelper.STUDENT_NAME_COLUMN};

        int[] to = {R.id.tvId,R.id.tvName};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,R.layout.my_list_item,
                db.getStudents(),from,to,
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


        lst.setAdapter(adapter);
        //adapter.swapCursor()
        //adapter.changeCursor();
        db.close();

        //new DB(this).open().addStudent("ahmed").close();

        //Toast.makeText(this, "Insert Done", Toast.LENGTH_SHORT).show();
    }
}
