package com.py.todo;
public class todo {


    String titledoes;
    String datedoes;
    String descdoes;
    String id;


    public todo() {
    }

    public todo(String titledoes, String datedoes, String descdoes, String id) {
        this.titledoes = titledoes;
        this.datedoes = datedoes;
        this.descdoes = descdoes;
        this.id = id;

    }

    public String getid() {
        return id;
    }

    public void setid(String titledoes) {
        this.id = id;
    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }

    public String getDescdoes() {
        return descdoes;
    }

    public void setDescdoes(String descdoes) {
        this.descdoes = descdoes;
    }
}