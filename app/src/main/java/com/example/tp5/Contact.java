package com.example.tp5;

public class Contact {
    String id ;
    String phone;
    String Nom;

    public Contact(String id, String phone, String nom) {
        this.id = id;
        this.phone = phone;
        Nom = nom;
    }
public Contact(String phone,String nom) {
    this.phone=phone;
    this.Nom=nom;}
public Contact(int i, String nom, String s) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
