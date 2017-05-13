package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewNote, textView2;
    EditText editTextNote;
    RadioGroup radioGroupStars;
    Button buttonInsertNote, buttonShowList;

    int numStars = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNote = (TextView) findViewById(R.id.textViewNote);
        editTextNote = (EditText) findViewById(R.id.editTextNote);
        textView2 = (TextView) findViewById(R.id.textView2);
        radioGroupStars = (RadioGroup) findViewById(R.id.radioGroupStars);
        buttonInsertNote = (Button) findViewById(R.id.buttonInsertNote);
        buttonShowList = (Button) findViewById(R.id.buttonShowList);


        radioGroupStars.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radio1) {
                    numStars = 1;
                } else if (checkedId == R.id.radio2) {
                    numStars = 2;
                } else if (checkedId == R.id.radio3) {
                    numStars = 3;
                } else if (checkedId == R.id.radio4) {
                    numStars = 4;
                } else if (checkedId == R.id.radio5) {
                    numStars = 5;
                }
            }
        });

        buttonInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                db.insertNote(editTextNote.getText().toString(), numStars);
                db.close();
                Toast.makeText(getApplicationContext(), "Inserted!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("revisionNote", editTextNote.getText().toString());
                i.putExtra("starRating", numStars);
                startActivity(i);
            }
        });
    }


}
