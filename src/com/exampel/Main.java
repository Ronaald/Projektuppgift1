package com.exampel;
import java.util.Scanner;

/**
 * Programmet handlar om att lägga till, söka, updatera och ta bort studenter
 * i programmet kan man även lägga till favorit och även visa vanliga studenter
 * samt favorit studenter.
 *
 * @author  Ronald Salazar
 * @version 1.0
 * @since   2019-10-09
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentController student = new StudentController();

    public static void main(String[] args) {


        boolean quit = false;
        startaSida();
        printActions();
        while (!quit) {
            System.out.println("\n Välj 7 för att visa val");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nStäng ner...");
                    quit = true;
                    break;

                case 1:
                    student.printUser();
                    break;

                case 2:
                    addNewStudent();
                    break;

                case 3:
                    updateUser();
                    break;

                case 4:
                    removeUser();
                    break;
                case 5:
                    queryUser();
                    break;
                case 6:
                    student.printFavorit();
                    break;
                case 7:
                    printActions();
                    break;



            }
        }
    }

    /**
     * Lägger till student
     */
    private static void addNewStudent() {
        System.out.println("Skriv in namnet på användare: ");
        String namn = scanner.nextLine();
        System.out.println(" Skriv in telefonnr till användare: ");
        String telefonnr = scanner.nextLine();
        System.out.println(" Skriv in kursen till användare: ");
        String kurs = scanner.nextLine();
        System.out.println(" Skriv in betyg till användare: ");
        String betyg = scanner.nextLine();
        Student newStudent = Student.createStudent(namn, telefonnr, kurs, betyg, ""); // Vi skapar ett objekt direkt där vi kommer åt metoden createStudent i Student klassen
        if (student.addNewStudent(newStudent)) {
            System.out.println("Ny kontakt tillad: \nNamn: " + namn + "\nTelefon: " + telefonnr + "\nKurs: " + kurs + "\nBetyg: " + betyg);

        } else {
            System.out.println("Kan inte lägga till, " + namn + "finns redan");
        }
    }

    /**
     * Hämtar en tillagd student för att uppdatera och det är här vi lägger till studenten som favorit.
     */
    private static void updateUser() {
        System.out.println("Skriv in namnet på kontakten som skall uppdateras: ");
        String namn = scanner.nextLine();
       User existingStudentRecord = student.queryUser(namn);
        if (existingStudentRecord == null) {
            System.out.println("Kan inte hitta kontaken");
            return;
        }
        System.out.println("Skriv in nytt namn för kontaken: ");
        String newNamn = scanner.nextLine();
        System.out.println("Skriv in nytt telefonnummer: ");
        String newtelefonnr = scanner.nextLine();
        System.out.println(" Skriv in kursen: ");
        String newkurs = scanner.nextLine();
        System.out.println(" Skriv in betyg: ");
        String newbetyg = scanner.nextLine();
        System.out.println(" Lägg till som favorit: ");
        String newFavorit = scanner.nextLine();
        Student newStudent = Student.createStudent(newNamn, newtelefonnr, newkurs, newbetyg, newFavorit);

        if (student.updateUser((Student) existingStudentRecord, newStudent)) {
            System.out.println("Kontakten är uppdaterad!!" );

        }
        else {
            System.out.println("Gick inte att uppdatera");
        }
    }

    /**
     * Letar efter inlagd student för att sedan radera studenten ur listan.
     */
    private static void removeUser() {
        System.out.println("Skriv in namnet på kontakten som skall tas bort: ");
        String namn = scanner.nextLine();
        User existingUserRecord = student.queryUser(namn);
        if (existingUserRecord == null) {
            System.out.println("Kan inte hitta kontakten");
            return;
        }
        if (student.removeUser(existingUserRecord)) {
            System.out.println("Kontakten har tagits bort");
        } else {
            System.out.println("Kan inte ta bort kontakten");
        }
    }


    /**
     * Kontrollerar om studenten existerar.
     */
    private static void queryUser() {
        System.out.println("Skriv in namnet på kontakten: ");
        String namn = scanner.nextLine();
        Student existingStudentRecord = student.queryUser(namn);
        if (existingStudentRecord == null) {
            System.out.println("Kan inte hitta kontakten");
            return;
        }
        System.out.println("Namn: " + existingStudentRecord.getNamn() + "\ntelefonnr är " + existingStudentRecord.getTelefonnr()
                + "\nkurs är " + existingStudentRecord.getKurs() + "\nbetyg är " + existingStudentRecord.getBetyg());
    }

    private static void startaSida() {
        System.out.println("Startar sidan");
    }

    /**
     * Val man gör med siffror för olika alternativ.
     */
    private static void printActions() {
        System.out.println("\nVälj:\n");
        System.out.println("0  - Stäng av\n" +
                "1  - Visa Studenter\n" +
                "2  - Lägga till en ny student\n" +
                "3  - Uppdatera en student\n" +
                "4  - Ta bort en student\n" +
                "5  - Söka efter en student\n" +
                "6  - Visa favorit studenter\n" +
                "7  - Visa en lista över alla val.");


    }

}
