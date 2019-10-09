package com.exampel;

public class Student extends User {
    private String kurs;
    private String betyg;
    private String favorit;

    public Student(String namn, String telefonnr, String kurs, String betyg, String favorit) {

        super(namn, telefonnr);
        this.kurs = kurs;
        this.betyg = betyg;
        this.favorit = favorit;

    }

    public String getKurs() {
        return kurs;
    }

    public String getBetyg() {
        return betyg;
    }

    public static Student createStudent(String namn, String telefonnr, String kurs, String betyg, String favorit) {
        return new Student(namn, telefonnr, kurs, betyg, favorit);
    }
    public String getFavorit() {return favorit; }


    }
