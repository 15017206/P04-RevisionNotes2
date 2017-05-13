package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.myapplicationdev.android.p04_revisionnotes.R.string.stars;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {

    ArrayList<Note> notes;
    Context context;
    int resource;
    TextView textViewNote;
    ImageView iv1, iv2, iv3, iv4, iv5;

    public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> objects) {
        super(context, resource, objects);
        notes = objects;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

//findViewById - from row.xml
        textViewNote = (TextView) rowView.findViewById(R.id.textViewNote);
        iv1 = (ImageView) rowView.findViewById(R.id.imageView1star);
        iv2 = (ImageView) rowView.findViewById(R.id.imageView2star);
        iv3 = (ImageView) rowView.findViewById(R.id.imageView3star);
        iv4 = (ImageView) rowView.findViewById(R.id.imageView4star);
        iv5 = (ImageView) rowView.findViewById(R.id.imageView5star);


        //Match the UI components with Java variables
        Note CurrentNote = notes.get(position);

//        Check if the property for starts >= 5, if so, "light" up the stars
//        if (stars >= 5) {
//            iv5.setImageResource(android.R.drawable.btn_star_big_on);
//            iv4.setImageResource(android.R.drawable.btn_star_big_on);
//            iv3.setImageResource(android.R.drawable.btn_star_big_on);
//            iv2.setImageResource(android.R.drawable.btn_star_big_on);
//            iv1.setImageResource(android.R.drawable.btn_star_big_on);
//        } else if (stars >= 4) {
//            iv4.setImageResource(android.R.drawable.btn_star_big_on);
//            iv3.setImageResource(android.R.drawable.btn_star_big_on);
//            iv2.setImageResource(android.R.drawable.btn_star_big_on);
//            iv1.setImageResource(android.R.drawable.btn_star_big_on);
//        } else if (stars >= 3) {
//            iv3.setImageResource(android.R.drawable.btn_star_big_on);
//            iv2.setImageResource(android.R.drawable.btn_star_big_on);
//            iv1.setImageResource(android.R.drawable.btn_star_big_on);
//        } else if (stars >= 2) {
//            iv2.setImageResource(android.R.drawable.btn_star_big_on);
//            iv1.setImageResource(android.R.drawable.btn_star_big_on);
//        } else if (stars >= 1) {
//            iv1.setImageResource(android.R.drawable.btn_star_big_on);
//
//
//        }
        return rowView;
    }
}



