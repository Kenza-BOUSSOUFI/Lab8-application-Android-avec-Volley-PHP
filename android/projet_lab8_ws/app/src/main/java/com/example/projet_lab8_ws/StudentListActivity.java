package com.example.projet_lab8_ws;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projet_lab8_ws.adapter.StudentAdapter;
import com.example.projet_lab8_ws.beans.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private ListView listView;
    private List<Student> studentList;
    private StudentAdapter adapter;
    private RequestQueue requestQueue;

    private static final String LOAD_URL = "http://10.0.2.2/Lab8-application-Android-avec-Volley-PHP/Ws/loadStudents.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = findViewById(R.id.listView);
        studentList = new ArrayList<>();
        adapter = new StudentAdapter(this, studentList);
        listView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);

        loadStudents();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            final Student student = studentList.get(position);
            // Logique de modification à implémenter
            Log.d("ACTION", "Clic sur l'étudiant pour modification: " + student.getId());
        });
    }

    private void loadStudents() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, LOAD_URL,
                response -> {
                    Type type = new TypeToken<Collection<Student>>() {}.getType();
                    studentList.clear();
                    studentList.addAll(new Gson().fromJson(response, type));
                    adapter.notifyDataSetChanged();
                },
                error -> Log.e("VOLLEY_ERROR", "Erreur lors du chargement", error));
        requestQueue.add(stringRequest);
    }
}
