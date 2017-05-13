package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Note> note = new ArrayList<Note>();
    RevisionNotesArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView
        setContentView(R.layout.activity_second);
        lv = (ListView) findViewById(R.id.lv);
        note = new ArrayList<Note>();
        aa = new RevisionNotesArrayAdapter(this, R.layout.row, note);
        lv.setAdapter(aa);

        Intent j = getIntent();
        int starRating = j.getIntExtra("starRating", 0);
        String revisionNote = j.getStringExtra("revisionNote");

        Toast.makeText(getApplicationContext(), "Star Rating: " + starRating + " RevisionNote: " + revisionNote, Toast.LENGTH_SHORT).show();

        // Create the DBHelper object, passing in the activity's Context
        DBHelper db = new DBHelper(SecondActivity.this);

        // Insert a task
//        ArrayList<String> data = db.getNoteContent();
        ArrayList<Note> data = db.getAllNotes();
        db.close();

        String txt = "";
        for (int i = 0; i < data.size(); i++) {
            Log.d("Database Content", i + ". " + data.get(i));
            txt += i + ". " + data.get(i) + "\n";
            note.add(new Note(data.get(i).getID(), data.get(i).getNoteContent(), data.get(i).getStars()));
        }
    }
}
