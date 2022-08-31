package fr.m2i.premierspring.models;

public class CoucouModel {

    String coucou = "Coucou le monde";

    public String getCoucou() {
        return coucou;
    }

    public void setCoucou(String coucou) {
        this.coucou = coucou;
    }

    public CoucouModel() {
    }

    @Override
    public String toString() {
        return  coucou;
    }
}
