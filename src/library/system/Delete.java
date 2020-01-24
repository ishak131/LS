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
public abstract class Delete {

    public static void DeleteS(ArrayList<Student> SV, ArrayList<Book> BV) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Write student name ");
        String SN = input.nextLine();
        int index = Find.FindS(SV, SN);
        ArrayList<Borrowing> BorrSV = SV.get(index).getBorrSV();
        for (int i = 0; i < BorrSV.size(); i++) {
            for (int j = 0; j < BorrSV.size(); j++) {
                if (BV.get(i).getName() == BorrSV.get(j).getBookName()) {
                    int BBN = BV.get(i).getBorrowed(),
                            RBN = BV.get(i).getRemain();
                    BV.get(i).setBorrowed(--BBN);
                    BV.get(i).setRemain(++RBN);

                }
            }
        }
        SV.remove(index);
    }

    public static void DeleteB(ArrayList<Book> BV, ArrayList<Student> S) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Write Book name ");
        String BN = input.nextLine();
        int index = Find.FindB(BV, BN);
        BV.remove(index);
        for (int i = 0; i < S.size(); i++) {
            ArrayList<Borrowing> BrrSV = S.get(i).getBorrSV();
            for (Borrowing BSV : BrrSV) {
                if (BSV.getBookName() == BN) {
                    S.get(i).removeBorrSV(BSV);
                }
            }

        }
    }

    public static void DeleteBorrowing(ArrayList<Student> S, ArrayList<Book> B, ArrayList<Borrowing> BorrGBV, int Sindex) {

        Scanner input = new Scanner(System.in);

        if (Sindex == -1) {
            System.out.println("Sorry ther is no student with this name");
            System.out.println("Do you want to find another student / if you want write Yes ");
            Sindex = Find.FindS(S, input.nextLine());
            DeleteBorrowing(S, B, BorrGBV, Sindex);

        } else {
            if (Sindex == -2) {
                System.out.println("Write student name");
                String SN = input.nextLine();
                Sindex = Find.FindS(S, SN);
            }
            if(S.get(Sindex).getBorrSV().size()<1){
                System.out.println("there is no books to give back");
                return;
            }
            ArrayList<Borrowing> BorrSV = S.get(Sindex).getBorrSV();
            System.out.println("Choose one of these to give back");
            BorrSV.forEach((Borr) -> {
                System.out.println(BorrSV.indexOf(Borr) + 1 + "-" + Borr.getBookName());
            });
            int BBN, RBN;
            int Borrindex = input.nextInt() - 1;
            Borrowing Borr = BorrSV.get(Borrindex);
            String BN = BorrSV.get(Borrindex).getBookName();
            int Bindex = Find.FindB(B, BN);
            System.out.println("Book index " + Bindex);
            if (Bindex > -1) {

                BBN = B.get(Bindex).getBorrowed();
                RBN = B.get(Bindex).getRemain();
                B.get(Bindex).setBorrowed(--BBN);
                B.get(Bindex).setRemain(++RBN);
                Borr.setActualGBD();
                BorrGBV.add(Borr);
                S.get(Sindex).removeBorrSV(Borr);
                System.out.println(S.get(Sindex).Get_name() + "'s Bill for borrowing " + B.get(Bindex).getName());
                System.out.println(" Borrwing date : " + Borr.getBorrwingDate());
                System.out.println(" Giving back date : " + Borr.getGivingBackDate());
                System.out.println(" Actual giving back date : " + Borr.getActualGBD());
                System.out.println(" Initial price : " + Borr.getBorrowingPrice());
                System.out.println(" Fine : " + Borr.getFine());
                System.out.println(" Discount : " + Borr.getDiscount());
                System.out.println(" Final price : " + Borr.getFinalPrice());
                if (S.get(Sindex).getBorrSV().size() > 0) {
                    System.out.println("Do you want to give back another book / if you want write yes ");
                    if (input.next().equals("yes")) {
                        DeleteBorrowing(S, B, BorrSV, Sindex);
                    }
                } else {
                    System.out.println("No more books to give back");
                }
            } else {

                System.out.println("Sorry ther is no book with this name");
                System.out.println("Do you want to give back another book / if you want write yes ");
                if ("yes".equals(input.next())) {
                    Bindex = Find.FindB(B, input.nextLine());

                }

            }
        }
    }
}
