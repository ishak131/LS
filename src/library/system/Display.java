package library.system;

import java.util.*;

public abstract class Display {

    public static void ShowS(ArrayList<Student> x) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Write student name ");
        int index = Find.FindS(x, input.nextLine());
        ArrayList<Borrowing> BorrSV;
        System.out.println(" Student name is : " + x.get(index).Get_name());
        System.out.println(" Student age is : " + x.get(index).Get_age());
        System.out.println(" Student stage is : " + x.get(index).Get_stage());
        System.out.println(" Student gender is : " + x.get(index).Get_gender());
        System.out.println(" Student email is : " + x.get(index).getEmail());

        BorrSV = x.get(index).getBorrSV();
        System.out.println(" Borrowed books are: ");
        BorrSV.forEach((Borrowing BN) -> {
            System.out.println(BN.getBookName());
            System.out.println(BN.getBorrwingDate());
            System.out.println(BN.getGivingBackDate());
        });

    }

    public static void ShowB(ArrayList<Book> x) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Write Book name ");
        int index = Find.FindB(x, input.nextLine());
        System.out.println(" Book name is : " + x.get(index).getName());
        System.out.println(" Book kind is : " + x.get(index).getType());
        System.out.println(" Book auther is : " + x.get(index).getAouther());
        System.out.println(" Book number of copies is : " + x.get(index).getNumberOfCopies());
        System.out.println(" Book number of borrowed copies  is : " + x.get(index).getBorrowed());
        System.out.println(" Book number of remain copies  is : " + x.get(index).getRemain());

    }
//unused methods

    public static void ShowBorr(ArrayList<Borrowing> GBBorr) {
        GBBorr.forEach((Borr) -> {
            System.out.println("Student name : " + Borr.getStudentName());
            System.out.println("Book name : " + Borr.getBookName());
            System.out.println("Borrowing date : " + Borr.getBorrwingDate());
            System.out.println("Giving back date : " + Borr.getActualGBD());
            System.out.println("Borrowing price : " + Borr.getFinalPrice());
        });
    }
    
     public static void ShowAllmyBorr(ArrayList<Borrowing> GBBorr) {
        GBBorr.forEach((Borr) -> {
            System.out.println("Student name : " + Borr.getStudentName());
            System.out.println("Book name : " + Borr.getBookName());
            System.out.println("Borrowing date : " + Borr.getBorrwingDate());
            System.out.println("Giving back date : " + Borr.getGivingBackDate());
            System.out.println("Borrowing price : " + Borr.getBorrowingPrice());
        });
    }

    public static void ShowBorr(ArrayList<Student> SV, ArrayList<Borrowing> GBBorr) {
        Scanner input = new Scanner(System.in);
        String SN, BN;
        System.out.println("Write student name");
        SN = input.nextLine();
        System.out.println("Write book name");
        BN = input.nextLine();
        int Sindex = Find.FindS(SV, SN);
        if (Sindex < 0) {
            System.out.println("Sorry ther is no student with this name"
                    + "\n Do you want to try another name"
                    + "\n if you want write yes");
            if (input.next().equals("yes")) {
                ShowBorr(SV, GBBorr);
            }
        }

        for (Borrowing Borr : GBBorr) {
            if (Borr.getBookName().equals(BN) && SV.get(Sindex).Get_name().equals(SN)) {
                System.out.println("Book name : " + Borr.getBookName());
                System.out.println("Borrowing date : " + Borr.getBorrwingDate());
                System.out.println("Giving back date : " + Borr.getGivingBackDate());
                System.out.println("Borrowing price : " + Borr.getBorrowingPrice());
                return;

            }
        }
        System.out.println("this book doesn't exist \n do you want to try again\n if you want write yes");
        if (input.next() == "yes") {
            System.out.println("Write student name");
            SN = input.nextLine();
            ShowBorr(SV, GBBorr);
        }
    }

   public static void ShowBorr(ArrayList<Student> SV, ArrayList<Borrowing> GBBorr ,String SN) {
        Scanner input = new Scanner(System.in);
        String BN;
        System.out.println("Write book name");
        BN = input.nextLine();
        int Sindex = Find.FindS(SV, SN);
        if (Sindex < 0) {
            System.out.println("Sorry ther is no student with this name"
                    + "\n Do you want to try another name"
                    + "\n if you want write yes");
            if (input.next().equals("yes")) {
                ShowBorr(SV, GBBorr);
            }
        }

        for (Borrowing Borr : GBBorr) {
            if (Borr.getBookName().equals(BN) && SV.get(Sindex).Get_name().equals(SN)) {
                System.out.println("Book name : " + Borr.getBookName());
                System.out.println("Borrowing date : " + Borr.getBorrwingDate());
                System.out.println("Giving back date : " + Borr.getActualGBD());
                System.out.println("Borrowing price : " + Borr.getFinalPrice());
                return;

            }
        }
        System.out.println("this book doesn't exist \n do you want to try again\n if you want write yes");
        if (input.next() == "yes") {
            System.out.println("Write student name");
            SN = input.nextLine();
            ShowBorr(SV, GBBorr);
        }
    } 

    public static void ShowAllB(ArrayList<Book> b) {
        b.forEach((x) -> {
            System.out.println(" Book name is : " + x.getName());
        });
    }

    public static void ShowAllBableB(ArrayList<Book> b) {
        b.forEach((x) -> {
            if (x.getRemain() > 1) {
                System.out.println(" Book name is : " + x.getName());

            }
        });
    }

    public static void ShowAllBorrB(ArrayList<Book> b) {
        b.forEach((x) -> {
            if (x.getRemain() < x.getNumberOfCopies()) {
                System.out.println(" Book name is : " + x.getName());

            }
        });
    }
}
