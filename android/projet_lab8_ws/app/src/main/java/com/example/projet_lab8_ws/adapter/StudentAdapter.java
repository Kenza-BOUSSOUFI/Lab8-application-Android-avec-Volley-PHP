package com.example.projet_lab8_ws.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projet_lab8_ws.R;
import com.example.projet_lab8_ws.beans.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Student student = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_student, parent, false);
        }
        // Lookup view for data population
        TextView tvNom = convertView.findViewById(R.id.nomTextView);
        TextView tvPrenom = convertView.findViewById(R.id.prenomTextView);
        TextView tvVille = convertView.findViewById(R.id.villeTextView);
        // Populate the data into the template view using the data object
        tvNom.setText(student.getNom());
        tvPrenom.setText(student.getPrenom());
        tvVille.setText(student.getVille());
        // Return the completed view to render on screen
        return convertView;
    }
}
