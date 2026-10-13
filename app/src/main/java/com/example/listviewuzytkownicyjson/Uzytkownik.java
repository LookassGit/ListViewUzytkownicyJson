package com.example.listviewuzytkownicyjson;

import com.google.gson.annotations.SerializedName;

public class Uzytkownik {
    @SerializedName("firstName")
    private String nazwa;
    @SerializedName("secondName")
    private String nazwisko;
    @SerializedName("email")
    private String email;
    @SerializedName("userId")
    private int id;

    public Uzytkownik(String nazwa, String nazwisko, String email, int id) {
        this.nazwa = nazwa;
        this.nazwisko = nazwisko;
        this.email = email;
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + " " + nazwisko + "\nEmail: " + email + "\nId:" + id;
    }
}
