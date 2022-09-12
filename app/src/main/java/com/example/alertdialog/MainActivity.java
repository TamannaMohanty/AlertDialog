package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    UserPojo userPojo;
    UserAdapter userAdapter;
    List<UserPojo> userPojoList=new ArrayList<>();

    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.customGrid);
        userAdapter = new UserAdapter(this, userPojoList);
        gridView.setAdapter(userAdapter);

        loadUserData();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Hello ODS");
                builder.setMessage("Welcome to Simple Alert Dialog");
                builder.setIcon(R.drawable.ic_baseline_announcement_24);
                builder.setCancelable(false);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });

                builder.setNeutralButton("Help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this,"Help",Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();

                    }
                });

                builder.create();
                builder.show();

            }
        });


        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View root = getLayoutInflater().inflate(R.layout.custom_alertdialog, null);
                builder.setView(root);
                builder.setCancelable(false);

                Button cancel = root.findViewById(R.id.cancelbtn);
                Button ok = root.findViewById(R.id.okbtn);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();

                        alertDialog.dismiss();


                    }
                });

                alertDialog = builder.create();
                alertDialog.show();

                return true;
            }
        });







    }

    private void loadUserData() {

        userPojo=new UserPojo(R.drawable.emp1,"Ruk1234","Ruksana","50,000","Android Developer");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.emp2,"Raju4323","Raju","50,000","Android Developer");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.emp3,"Sai2212","Sai","50,000","Android Developer");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.emp4,"Aish5643","Aishwarya","50,000",".Net Developer");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.emp5,"Tama3454","Tamanna","80,000","Android Developer");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.emp1,"Gopi2343","Gopika","50,000",".Net Developer");
        userPojoList.add(userPojo);
        userPojo=new UserPojo(R.drawable.emp2,"Niksan9896","Santosh","500000","cloud Developer");
        userPojoList.add(userPojo);


        userAdapter.notifyDataSetChanged();

    }
}