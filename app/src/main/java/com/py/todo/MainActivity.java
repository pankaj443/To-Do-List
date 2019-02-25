package com.py.todo;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;
    Button btnAddNew;

    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<todo> list = new ArrayList<todo>();
    todoadapter doesAdapter;
    Databasehelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new Databasehelper(this);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAddNew = findViewById(R.id.btnAddNew);
        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));


        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");

        // customize font
        titlepage.setTypeface(MMedium);
        subtitlepage.setTypeface(MLight);
        endpage.setTypeface(MLight);

        btnAddNew.setTypeface(MLight);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,NewTaskAct.class);
                startActivity(a);
            }
        });

         Cursor res =  mydb.getdata();
         if (res.getCount() == 0){
             Toast.makeText(this, "NO Todo", Toast.LENGTH_SHORT).show();
         }else Toast.makeText(this, "Here are your Todo's", Toast.LENGTH_SHORT).show();


         StringBuffer buffer = new StringBuffer();
         while (res.moveToNext()){
                todo p = new todo(res.getString(1),res.getString(2),res.getString(3));
                Log.i("MSG", String.valueOf(p.datedoes));
                list.add(p);
            // buffer.append("ID :"+ res.getString(0)+"\n");
             //buffer.append("Title :"+ res.getString(1)+"\n");
            // buffer.append("Desc :"+ res.getString(2)+"\n");

         }


        refresh();

        // working with data

        // get data from firebase



    }
    public void refresh(){
        doesAdapter = new todoadapter(MainActivity.this, list);
        ourdoes.setAdapter(doesAdapter);
        doesAdapter.notifyDataSetChanged();
    }
}


