package com.py.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edittask extends AppCompatActivity {

    EditText title,desc,date;

    Button btnsaveupdate,btndelete;
    Databasehelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittask);

        mydb = new Databasehelper(this);

        title = (EditText) findViewById(R.id.titledoes);
        desc = (EditText) findViewById(R.id.descdoes);
        date = (EditText) findViewById(R.id.datedoes);

        btndelete = (Button) findViewById(R.id.btndelete);
        btnsaveupdate = (Button) findViewById(R.id.btnSaveupdate);

        title.setText(getIntent().getStringExtra("titledoes"));
        desc.setText(getIntent().getStringExtra("descdoes"));
        date.setText(getIntent().getStringExtra("datedoes"));

        final String id = getIntent().getStringExtra("id");

        btnsaveupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated = mydb.update(id,title.getText().toString(),date.getText().toString(),desc.getText().toString());
                Intent a = new Intent(Edittask.this,MainActivity.class);
                startActivity(a);
                if (isupdated == true)
                    Toast.makeText(Edittask.this, "Updated", Toast.LENGTH_SHORT).show();

            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer isdeleted = mydb.delete(id);
                Intent a = new Intent(Edittask.this,MainActivity.class);
                startActivity(a);
                if (isdeleted > 0)
                    Toast.makeText(Edittask.this, "Deleted", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
