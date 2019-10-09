package com.exampel;

public class User {

    private String namn;
    private String telefonnr;

    //Konstruktor

    public User(String namn, String telefonnr) {
        this.namn = namn;
        this.telefonnr = telefonnr;
    }
    public  String getNamn(){
        return namn;
    }
    public String getTelefonnr(){
        return telefonnr;
    }
  }
