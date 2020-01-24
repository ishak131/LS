package library.system;

import java.util.*;

public abstract class Modify {

    public static void modifyBook(ArrayList<Student> SV, ArrayList<Book> BV, ArrayList<Borrowing> GBBorr) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Write Book name ");
        String oldBN = input.nextLine();
        int index = Find.FindB(BV, oldBN);
        if (index >= 0) {
            System.out.println("1 - name");
            System.out.println("2 - type");
            System.out.println("3 - aouther");
            System.out.println("4 - numberOfCopies");
            System.out.println("5 - pricePerHoure");
            System.out.println("6 - Exit");

            String select = input.next();
            switch (select) {
                case "1":
                    System.out.println(" Enter Book name ");
                    String newBN = input.nextLine();
                    BV.get(index).setName(newBN);
                    modifyBookInStandBorr(oldBN, newBN, SV, BV, GBBorr);
                    break;
                case "2":
                    BV.get(index).setType();
                    break;
                case "3":
                    System.out.println(" Enter Book author");
                    BV.get(index).setAouther(input.next());
                    break;
                case "4":
                    System.out.println(" Enter Book copies");
                    int RCN,
                     CN = input.nextInt();
                    BV.get(index).setNumberOfCopies(CN);
                    RCN = BV.get(index).getNumberOfCopies() - BV.get(index).getBorrowed();
                    BV.get(index).setRemain(RCN);

                    break;
                case "5":
                    System.out.println(" Enter Book price per day ");
                    BV.get(index).setPricePerHoure(input.nextInt());
                    break;
                default:
                    System.out.println("This is not of the choices please try again");

            }
        } else {
            System.out.println("ther is no book with this name");
        }
        System.out.println("Do you want to modify another book ");
        if (input.next().equals("yes")) {
            modifyBook(SV, BV, GBBorr);
        }

    }

    private static void modifyBookInStandBorr(String oldBN, String newBN, ArrayList<Student> SV, ArrayList<Book> BV,
            ArrayList<Borrowing> GBBorr) {

        for (Student S : SV) {
            int SI = SV.indexOf(S);
            ArrayList<Borrowing> GBBorrSV = S.getBorrSV();
            for (Borrowing Borr : GBBorrSV) {
                int BorrI = GBBorrSV.indexOf(Borr);
                if (Borr.getBookName() == oldBN) {
                    SV.get(SI).getBorrSV().get(BorrI).setBookName(newBN);
                }
            }
        }
        for (Book B : BV) {
            if (B.getName() == oldBN) {
                B.setName(newBN);
            }
        }
        for (Borrowing Borr : GBBorr) {
            if (Borr.getBookName().equals(newBN)) {
                Borr.setBookName(newBN);
            }
        }
    }

    public static void modifyStudent(ArrayList<Student> SV, ArrayList<Borrowing> GBBorr) {
        Scanner input = new Scanner(System.in);

        System.out.println(" Write Student name ");
        String oldSN = input.nextLine();
        int index = Find.FindS(SV, oldSN);
        if (index >= 0) {

            System.out.println("1 - first name");
            System.out.println("2 - last name");
            System.out.println("3 - stage");
            System.out.println("4 - gender");
            System.out.println("5 - email");
            System.out.println("6 - password");

            String select = input.next();
            switch (select) {
                case "1":
                    System.out.println(" Enter first name ");
                    String full,
                     FN = input.next();
                    full = FN + " " + SV.get(index).getS_name();
                    int Sindex = Find.FindS(SV, full);
                    if (Sindex == -1) {
                        SV.get(index).setF_name(FN);
                        SV.get(index).Set_name(full);
                        modifyStudentInStandBorr(oldSN, full, SV, GBBorr);
                    } else {
                        System.out.println(" Sorry this name already exist");
                    }
                    break;
                case "2":
                    System.out.println(" Enter second name ");
                    String Full,
                     SN = input.next();
                    Full = SV.get(index).getF_name() + " " + SN;
                    int Bindex = Find.FindS(SV, Full);
                    if (Bindex == -1) {
                        SV.get(index).setS_name(SN);
                        SV.get(index).Set_name(Full);
                        modifyStudentInStandBorr(oldSN, Full, SV, GBBorr);

                    } else {
                        System.out.println(" Sorry this name already exist");
                    }
                    break;
                case "3":
                    System.out.println(" Enter stage");
                    SV.get(index).Set_stage(input.next());
                    break;
                case "4":
                    System.out.println(" Enter gender");
                    SV.get(index).Set_gender(input.next());
                    break;
                case "5":
                    System.out.println(" Enter email ");
                    SV.get(index).setEmail(input.nextLine());
                    break;
                case "6":
                    System.out.println(" Enter password");
                    SV.get(index).setPassword(input.nextLine());
                    break;
                default:
                    System.out.println("This is not of the choices please try again");
            }
        } else {
            System.out.println("ther is no Student with this name");
        }
        System.out.println("Do you want to modify another book ");
        if (input.next().equals("yes")) {
            modifyStudent(SV, GBBorr);
        }
    }

    private static void modifyStudentInStandBorr(String oldSN, String newSN, ArrayList<Student> SV, ArrayList<Borrowing> GBBorr) {

        for (Student S : SV) {
            int SI = SV.indexOf(S);
            ArrayList<Borrowing> GBBorrSV = S.getBorrSV();
            for (Borrowing Borr : GBBorrSV) {
                int BorrI = GBBorrSV.indexOf(Borr);
                if (Borr.getStudentName() == oldSN) {
                    SV.get(SI).getBorrSV().get(BorrI).setStudentName(newSN);
                }
            }
        }

        for (Borrowing Borr : GBBorr) {
            if (Borr.getStudentName().equals(newSN)) {
                Borr.setStudentName(newSN);
            }
        }
    }

}
