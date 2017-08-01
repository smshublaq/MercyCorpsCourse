package com.api.myfirebaseexample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class FirebaseActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
          databaseReference = FirebaseDatabase.
                getInstance().getReference("Students");


        databaseReference.child("name").setValue("hossam");
        databaseReference.child("myObject").setValue(new Employee("ayman","321321"));

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                Toast.makeText(FirebaseActivity.this, name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        //databaseReference.child("name").addValueEventListener(valueEventListener);
        databaseReference.child("name").addListenerForSingleValueEvent(valueEventListener);
        databaseReference.child("name").removeValue();
        databaseReference.child("name").removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

            }
        });
        HashMap<String,Object> map = new HashMap<>();
        map.put("emp",new Employee("ahmed","123"));
        map.put("age",22);
        databaseReference.setValue(map);


        addNewPost("XYZ","yousef","eyad","hello fire base");

        /*
        FirebaseAuth.getInstance().createUserWithEmailAndPassword("aa@gmail.com","123123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(FirebaseActivity.this, task.getResult().getUser().getUid(), Toast.LENGTH_SHORT).show();
            }
        });
        */
        
        FirebaseAuth.getInstance().signInWithEmailAndPassword("aa@gmail.com","123123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(FirebaseActivity.this, task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
            }
        });
        //databaseReference.removeEventListener(valueEventListener);
        
    }

    public void addNewPost(String uid , String author,String title,String body){
        String key = databaseReference.child("Posts").push().getKey();
        Post post = new Post(uid,author,title,body);


        Map<String,Object> postValues = post.toMap();


        Map<String,Object> childUpdates = new HashMap<>();

        childUpdates.put("/Posts/"+key,postValues);
        childUpdates.put("/user-post/" + uid + "/" + key ,postValues);

        databaseReference.updateChildren(childUpdates);
    }
}
