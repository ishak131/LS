/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.system;

import java.util.*;

/**
 *
 * @author Magic
 */
public abstract class Create {

    public static Student Create_S(ArrayList<Student> StudentVector) {
        Scanner input = new Scanner(System.in);
        Student s1 = new Student();
        String Full_name, F_name, S_name;
        System.out.println(" Enter student name ");

        F_name = input.next();
        S_name = input.next();
        Full_name = F_name + " " + S_name;
        int Sindex = Find.FindS(StudentVector, Full_name);
        if (Sindex > -1) {
            System.out.println("This name already exist");
            return null;

        } else {
            s1.setF_name(F_name);
            s1.setS_name(S_name);
            s1.Set_name(Full_name);
            System.out.println(Full_name);
            System.out.println(" Enter student gender ");
            s1.Set_gender(input.next());
            try {
                System.out.println(" Enter student age ");
                s1.Set_age(input.nextInt());
            } catch (Exception e) {
                System.out.println(" Not a number");
                return null;
            }
            System.out.println(" Enter student stage ");
            s1.Set_stage(input.next());
            System.out.println(" Enter student email");
            s1.setEmail(input.next());
            System.out.println(" Enter student password");
            s1.setPassword(input.next());
            return s1;
        }
    }

    public static void Create_B(ArrayList<Book> BV) {

        Scanner input = new Scanner(System.in);
        Book B1 = new Book();
        int x;
        System.out.println(" Enter Book name ");
        String BN = input.nextLine();
        int Bindex = Find.FindB(BV, BN);
        if (Bindex > -1) {
            System.out.println("Sorry this book is already exist \n Do you want to try again \n if you want write yes");
            if (input.next().equals("yes")) {
                Create_B(BV);
            }
            return;
        }
        B1.setName(BN);
        B1.setType();
        if (B1.getType() == null) {
            return;
        }
        System.out.println(" Enter Book copies");

        x = input.nextInt();
        if (x < 1) {
            System.out.println("not real number");
            return;
        }
        B1.setNumberOfCopies(x);
        B1.setRemain(x);
        System.out.println(" Enter Book author");
        B1.setAouther(input.next());
        System.out.println(" Enter Book price per day ");
        int pPD = input.nextInt();
        if (pPD < 1) {
            System.out.println("not real number");
            return;
        }
        B1.setPricePerHoure(pPD);
        BV.add(B1);
        System.out.println("Book " + B1.getName() + " created ");
        System.out.println("Do you want to enter another book \n write yes if you want");
        if (input.next().equals("yes")) {
            Create_B(BV);
        }
    }

    public static void Create_Borrowing(ArrayList<Student> S, ArrayList<Book> B, int Sindex) {

        Scanner input = new Scanner(System.in);

        if (Sindex < 0) {

            if (Sindex == -2) {
                System.out.println(" Write student name ");
                Sindex = Find.FindS(S, input.nextLine());
            }
            if (Sindex == -1) {
                System.out.println("Sorry ther is no student with this name");
                System.out.println("Do you want to enter another name  / if you want write Yes ");

                if ("Yes".equals(input.next())) {
                    System.out.println(" Write student name ");
                    Sindex = Find.FindS(S, input.nextLine());
                }
            }
        }
        if (Sindex != -1) {

            int BBN, RBN, Bindex;
            System.out.println(" Write Book name ");
            String BN = input.nextLine();
            Bindex = Find.FindB(B, BN);

            if (Bindex == -1) {
                System.out.println("Sorry ther is no book with this name");

            } else {

                BBN = B.get(Bindex).getBorrowed();
                RBN = B.get(Bindex).getRemain();
                if (RBN == 0) {
                    System.out.println("Sorry ther is no more copies");
                } else {
                    System.out.println("Enter number of days");
                    Borrowing Borr = new Borrowing();
                    int NOfD = input.nextInt();
                    if (NOfD > 20) {
                        System.out.println("Sorry you cant Borrow any thing for more than 20 days \n  "
                                + "Book for 20  as maximum "
                                + "Booklet and Magazine for 15 as maximum");
                    } else if (NOfD < 1) {
                        System.out.println("Please enter real number or number that more than 0 days");
                    } else if (NOfD > 15 && (B.get(Bindex).getType() == "Booklet" || B.get(Bindex).getType() == "Magazine")) {
                        System.out.println("Sorry you cant Borrow Booklet or Magazine for more than 15 days \n  "
                                + "Booklet and Magazine for 15 as maximum");
                    } else {
                        Borr.setNumberOfBorrwingDays(NOfD);
                        Borr.setGivingBackDate(NOfD);
                        B.get(Bindex).setBorrowed(++BBN);
                        B.get(Bindex).setRemain(--RBN);
                        String sn = S.get(Sindex).Get_name();
                        Borr.setBookName(BN);
                        Borr.setStudentName(sn);
                        Borr.setPricePerDay(B.get(Bindex).getPricePerDay());
                        S.get(Sindex).setBorrSV(Borr);

                    }
                }

            }
            System.out.println("Do you want to borrow another book \n if you want write yes ");
            if (input.next().equals("yes")) {
                Create_Borrowing(S, B, Sindex);
            }
        }
    }
}
