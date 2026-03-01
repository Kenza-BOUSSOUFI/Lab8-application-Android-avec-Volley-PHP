package com.example.projet_lab8_ws;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projet_lab8_ws.beans.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AddStudent extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNom, editTextPrenom;
    private Spinner spinnerVille;
    private RadioButton radioButtonMale, radioButtonFemale;
    private Button buttonAjouter, buttonViewList;
    private RequestQueue requestQueue;

    private static final String INSERT_URL = "http://10.0.2.2/Lab8-application-Android-avec-Volley-PHP/Ws/createStudent.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editTextNom = findViewById(R.id.nom);
        editTextPrenom = findViewById(R.id.prenom);
        spinnerVille = findViewById(R.id.ville);
        radioButtonMale = findViewById(R.id.male);
        radioButtonFemale = findViewById(R.id.female);
        buttonAjouter = findViewById(R.id.add);
        buttonViewList = findViewById(R.id.view_list_button);

        requestQueue = Volley.newRequestQueue(this);
        buttonAjouter.setOnClickListener(this);
        buttonViewList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            envoyerDonneesStudent();
        } else if (v.getId() == R.id.view_list_button) {
            startActivity(new Intent(this, StudentListActivity.class));
        }
    }

    private void envoyerDonneesStudent() {
        StringRequest request = new StringRequest(Request.Method.POST, INSERT_URL,
                response -> {
                    Log.d("RESPONSE", response);
                    Type type = new TypeToken<Collection<Student>>() {}.getType();
                    Collection<Student> students = new Gson().fromJson(response, type);
                    for (Student e : students) {
                        Log.d("ETUDIANT", e.toString());
                    }
                },
                error -> Log.e("ERREUR_VOLLEY", "Erreur lors de la création", error)) {

            @Override
            protected Map<String, String> getParams() {
                String sexe = radioButtonMale.isChecked() ? "homme" : "femme";
                Map<String, String> params = new HashMap<>();
                params.put("nom", editTextNom.getText().toString());
                params.put("prenom", editTextPrenom.getText().toString());
                params.put("ville", spinnerVille.getSelectedItem().toString());
                params.put("sexe", sexe);
                return params;
            }
        };
        requestQueue.add(request);
    }
}
