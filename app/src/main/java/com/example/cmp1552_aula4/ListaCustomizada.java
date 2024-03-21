package com.example.cmp1552_aula4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListaCustomizada extends ArrayAdapter<Aluno> {
    private final int resourceLayout;
    private float fontSize = 14;
    public ListaCustomizada(@NonNull MainActivity context, int resource, ArrayList<Aluno> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
    }

    public void setFontSize(float size) {
        this.fontSize = size;
        notifyDataSetChanged(); // Notifica que os dados mudaram para atualizar a view
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resourceLayout, null);
        }

        Aluno aluno = getItem(position);

        if (aluno != null) {
            TextView nomeText = convertView.findViewById(R.id.nomeAluno);
            TextView gradeText = convertView.findViewById(R.id.gradeAluno);
            nomeText.setText(aluno.getNome());
            gradeText.setText(aluno.getGrade());

            // Aplicar o tamanho da fonte
            nomeText.setTextSize(fontSize);
            gradeText.setTextSize(fontSize);
        }

        return convertView;
    }
}