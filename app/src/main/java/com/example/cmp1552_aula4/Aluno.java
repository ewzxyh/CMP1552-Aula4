package com.example.cmp1552_aula4;

public class Aluno {
    private String nome;
    private String grade;

    public Aluno(String nome, String grade) {
        this.nome = nome;
        this.grade = grade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}