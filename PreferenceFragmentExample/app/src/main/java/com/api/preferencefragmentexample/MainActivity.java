package com.api.preferencefragmentexample;


import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragment = new SettingFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();

        DialogFragment myDialog = new MyDialog();
        myDialog.show(getSupportFragmentManager(),null);

        final String[] items = {"a", "b", "C", "d"};

        /*
        final AlertDialog.Builder alert = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("My App").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })

                .setMultiChoiceItems(items, new boolean[]{true, false, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                })
                .setCancelable(false);
                */

        View myView = LayoutInflater.from(this).inflate(R.layout.my_view,null);
        TextView tv = myView.findViewById(R.id.tv);
        tv.setText("Ahmed");

        /*
        final AlertDialog.Builder alert = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("My App").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })

                .setView(myView)
                .setCancelable(false);
        AlertDialog dialog = alert.create();
        dialog.show();
        */

        Dialog d = new Dialog(this,android.R.style.Theme_NoTitleBar);
        d.setContentView(R.layout.my_view);
        TextView tvContent = d.findViewById(R.id.tv);
        tvContent.setText("ahmed");
        d.show();

    }
}
