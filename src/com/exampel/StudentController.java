package com.exampel;
import java.util.ArrayList;

/**
 * Programmet handlar om att lägga till, söka, updatera och ta bort studenter
 * i programmet kan man även lägga till favorit och även visa vanliga studenter
 * samt favorit studenter.
 * StudentController används för att spara i arraylistan.
 *
 * @author  Ronald Salazar
 * @version 1.0
 * @since   2019-10-09
 */
public class StudentController {

    private ArrayList<Student> myStudent;

    //Konstruktor
    public StudentController() {
        this.myStudent = new ArrayList<Student>();

    }

    /**
     * Letar efter student för att inte ha dubbleter.
     * @param student
     * @return true eller false
     */
    public boolean addNewStudent(Student student) {
        if (findStudent(student.getNamn()) >= 0) {
            System.out.println("Personen är redan sparad.");
            return false;
        }
        myStudent.add(student);
        return true;
    }

    /**
     * Hämtar en inlagd student, som sedan kan redigeras och uppdateras.
     * @param oldUser
     * @param newUser
     * @return true eller false
     */
    public boolean updateUser(Student oldUser, Student newUser) {
        int foundPosition = findStudent(oldUser);
        if (foundPosition < 0) {
            System.out.println(oldUser.getNamn() + "gick inte att hitta");
            return false;
        }
        this.myStudent.set(foundPosition, newUser);
        System.out.println(oldUser.getNamn() + "har uppdaterats med " + newUser.getNamn());
        return true;
    }

    /**
     * Letar efter student, om studenten finns så kan man ta bort.
     * @param user
     * @return true eller false
     */
    public boolean removeUser(User user) {
        int foundPosition = findStudent(user);
        if (foundPosition < 0) {
            System.out.println(user.getNamn() + "gick inte att hitta");
            return false;
        }
        this.myStudent.remove(foundPosition);
        System.out.println(user.getNamn() + "har tagits bort");
        return true;
    }

    /**
     * Metod för att hitta en inlagd student.
     * @param student
     * @return true eller false
     */

    private int findStudent(User student) {
        return this.myStudent.indexOf(student);
    }

    //overload av metoden finduser
    private int findStudent(String userNamn) {
        for (int i = 0; i < this.myStudent.size(); i++) {
            Student student = this.myStudent.get(i);
            if(student.getNamn().equals(userNamn)){
            return i;
        }
    }
    return -1;
}
public String queryUser(Student student) {
    if(findStudent(student) >=0) {
        return student.getNamn();
    }
    return null;
}
public Student queryUser(String namn) {
    int position = findStudent(namn);
    if (position >= 0) {
        return this.myStudent.get(position);
    }
    return null;
}

    /**
     * Metod som skriver ut en lista över alla studenter och även favorit studenter.
     */
    public void printUser() {
        System.out.println("Student Lista: ");
        for (int i = 0; i < this.myStudent.size(); i++) {
            String showFavorit = "";
            if( this.myStudent.get(i).getFavorit().equals("Ja")){
                showFavorit = " \nFavorit? " +
                        this.myStudent.get(i).getFavorit();
            }
            System.out.println((i + 1) + "." +
                    this.myStudent.get(i).getNamn() + "\ntillhör kursen " +
                    this.myStudent.get(i).getKurs() + showFavorit);
        }
}

    /**
     * Metod som endast skriver ut favorit studenter.
     */
    public void printFavorit() {
        System.out.println("Favorit Lista: ");
        for (int i = 0; i < this.myStudent.size(); i++) {
           if(this.myStudent.get(i).getFavorit().equals("Ja")){
            System.out.println((i + 1) + "." +
                    this.myStudent.get(i).getNamn() + " tillhör kursen " +
                    this.myStudent.get(i).getKurs() + " \nFavorit " +
                    this.myStudent.get(i).getFavorit());
        }
    }

}
}
