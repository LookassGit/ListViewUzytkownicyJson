package com.example.listviewuzytkownicyjson;

public class Uzytkownik {
    private String nazwa, nazwisko, email;
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

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
