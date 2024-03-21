package com.example.cmp1552_aula4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Aluno> alunosList;
    EditText editTextNome, editTextGrade;
    Button buttonAdd;
    ListaCustomizada adapter;

    private float fontSize = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lista);
        editTextNome = findViewById(R.id.editTextNome);
        editTextGrade = findViewById(R.id.editTextGrade);
        buttonAdd = findViewById(R.id.buttonAdd);
        Button btnIncreaseFont = findViewById(R.id.btnIncreaseFont);
        Button btnDecreaseFont = findViewById(R.id.btnDecreaseFont);

        btnIncreaseFont.setOnClickListener(v -> {
            fontSize++; // Aumenta o tamanho da fonte
            adapter.setFontSize(fontSize);
        });

        btnDecreaseFont.setOnClickListener(v -> {
            fontSize--; // Diminui o tamanho da fonte
            adapter.setFontSize(fontSize);
        });

        alunosList = new ArrayList<>();
        adapter = new ListaCustomizada(this, R.layout.layout_lista, alunosList);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString().trim();
            String grade = editTextGrade.getText().toString().trim();
            if (!nome.isEmpty() && !grade.isEmpty()) {
                Aluno newAluno = new Aluno(nome, grade);
                alunosList.add(newAluno);
                adapter.notifyDataSetChanged();
                editTextNome.setText("");
                editTextGrade.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Please enter both name and grade.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
