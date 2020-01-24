package library.system;

import java.util.*;

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> StudentVector = new ArrayList<>();
        ArrayList<Book> BooksVector = new ArrayList<>();
        ArrayList<Borrowing> GiveBackBorrowing = new ArrayList<>();
        String ch = "1";
        while (!"0".equals(ch)) {
            System.out.println(" Choose a character  ");
            System.out.println(" 1- student  ");
            System.out.println(" 2- librarian");
            ch = input.next();
            switch (ch) {
                case "1":
                    SelectTheUser.student(StudentVector, BooksVector, GiveBackBorrowing);
                    break;
                case "2":
                    SelectTheUser.librarian(StudentVector, BooksVector, GiveBackBorrowing);
                    break;
                default:
                    if (!"0".equals(ch)) {
                        System.out.println("this is not one of the choices please try again");
                    }
                    break;
            }
        }
    }

}
