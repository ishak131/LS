/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.system;

import java.util.*;

/**
 *
 * @author Ishak
 */
public abstract class SelectTheUser {

    public static void student(ArrayList<Student> StudentVector, ArrayList<Book> BooksVector, ArrayList<Borrowing> GiveBackBorrowing) {
        Scanner input = new Scanner(System.in);
        String UN, PW, x = "1";
        boolean exist = false;

        System.out.println("Enter your email");
        UN = input.nextLine();
        for (Student S : StudentVector) {
            if (UN.equals(S.getUser_name())) {
                System.out.println("Write user name");
                exist = true;
            }
        }
        if (exist == true) {
            do {
                System.out.println("Enter your password");
                PW = input.nextLine();

                for (Student S : StudentVector) {
                    if (PW.equals(S.getPassword())) {
                        System.out.println();
                        exist = false;
                        break;
                    }
                }
                if (exist == true) {
                    System.out.println("Wrong password \n Do you want try agin \n if you want write yes ");
                    if (input.nextLine().equals("yes")) {
                        exist = true;
                    } else {
                        return;
                    }
                }
            } while (false);
        } else {
            System.out.println(" Not found try another user name \n if you want enter yes ");
            if (input.equals("yes")) {
                student(StudentVector, BooksVector, GiveBackBorrowing);
            } else {
                return;
            }
        }
        Student S1 = null;
        for (Student S : StudentVector) {
            if (S.getUser_name().equals(UN)) {
                S1 = S;
                break;
            }
        }

        while (!"0".equals(x)) {

            System.out.println(" 1 - Show Book");
            System.out.println(" 2 - Show all my borrowing");
            System.out.println(" 3 - Show my giving back for a book");
            System.out.println(" 4 - Show all books");
            System.out.println(" 5 - Show all borrowable books");

            x = input.next();

            switch (x) {
                case "1":
                    try {

                        Display.ShowB(BooksVector);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }
                    break;
                case "2":
                    Display.ShowAllmyBorr(S1.getBorrSV());
                    break;
                case "3":
                    Display.ShowBorr(StudentVector, GiveBackBorrowing, S1.Get_name());
                    break;
                case "4":
                    Display.ShowAllB(BooksVector);
                    break;
                case "5":
                    Display.ShowAllBableB(BooksVector);
                    break;
                case "6":
                    Display.ShowAllBorrB(BooksVector);
                    break;
                default:
                    if (!"0".equals(x)) {
                        System.out.println("this is not one of the choices please try again");
                    }
                    break;
            }

        }

    }

    public static void librarian(ArrayList<Student> StudentVector, ArrayList<Book> BooksVector, ArrayList<Borrowing> GiveBackBorrowing) {

        Scanner input = new Scanner(System.in);
        String ch = "no";
        do {
            System.out.println(" Write the password");
            ch = input.next();
            if (!ch.equals("yes")) {
                System.out.println(" do you want to try again \n if you want write yes");
                if (!input.next().equals("yes")) {
                    return;
                }
            }
        } while (!ch.equals("yes"));
        String x = "1";
        while (!"0".equals(x)) {

            System.out.println(" 1 - New Book");
            System.out.println(" 2 - Show Book");
            System.out.println(" 3 - Delete Book");
            System.out.println(" 4 - New Student");
            System.out.println(" 5 - Show Student");
            System.out.println(" 6 - Delete Student");
            System.out.println(" 7 - Borrow a book");
            System.out.println(" 8 - Give back a book");
            System.out.println(" 9 - Modify a book");
            System.out.println(" 10 - Modify a student");
            System.out.println(" 11 - Show all Giving back");
            System.out.println(" 12 - Show Given back borrowing for a student");
            System.out.println(" 13 - Show all books");
            System.out.println(" 14 - Show all borrowable books");
            System.out.println(" 15 - Show all borrowed books");

            x = input.next();

            switch (x) {

                case "1":
                    try {

                        Create.Create_B(BooksVector);

                    } catch (InputMismatchException e) {
                        System.out.println("Not a number");
                    }

                    break;
                case "2":

                    try {

                        Display.ShowB(BooksVector);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }

                    break;
                case "3":
                    try {

                        Delete.DeleteB(BooksVector, StudentVector);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }

                    break;
                case "4":
                    Student s1 = Create.Create_S(StudentVector);
                    if (s1 != null) {
                        StudentVector.add(s1);
                        System.out.println(" Do you want to enter a book / Write-- yes --if you want");
                        String yes = input.next();
                        if ("yes".equals(yes)) {
                            int Sindex = StudentVector.indexOf(s1);
                            Create.Create_Borrowing(StudentVector, BooksVector, Sindex);
                        }
                    }
                    break;
                case "5":

                    try {

                        Display.ShowS(StudentVector);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }

                    break;
                case "6":
                    try {

                        Delete.DeleteS(StudentVector, BooksVector);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }

                    break;
                case "7":
                    Create.Create_Borrowing(StudentVector, BooksVector, -2);
                    break;
                case "8":
                    try {

                        Delete.DeleteBorrowing(StudentVector, BooksVector, GiveBackBorrowing, -2);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }

                    break;
                case "9":
                    try {

                        Modify.modifyBook(StudentVector, BooksVector, GiveBackBorrowing);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }
                    break;
                case "10":
                    try {

                        Modify.modifyStudent(StudentVector, GiveBackBorrowing);

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Not Found");
                    }
                    break;

                case "11":
                    Display.ShowBorr(GiveBackBorrowing);
                    break;
                case "12":
                    Display.ShowBorr(StudentVector, GiveBackBorrowing);
                    break;
                case "13":
                    Display.ShowAllB(BooksVector);
                    break;
                case "14":
                    Display.ShowAllBableB(BooksVector);
                    break;
                case "15":
                    Display.ShowAllBorrB(BooksVector);
                    break;
                default:
                    if (!"0".equals(x)) {
                        System.out.println("this is not one of the choices please try again");
                    }
                    break;
            }

        }
    }
}
