package library.system;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDateTime;

public class Borrowing {

    private String studentName, bookName;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd / MM / yy");
    private LocalDateTime borrwingDate, givingBackDate, actualGBD;
    private double finalPrice, borrowingPrice, fine, discount, numberOfBorrwingDays,
            pricePerDay, actualNOfDs;

    Scanner input = new Scanner(System.in);

    Borrowing() {
        this.borrwingDate = LocalDateTime.now();
    }

    public double getActualNOfDs() {
        return actualNOfDs;
    }

    public void setActualNOfDs(double actualNOfDs) {
        this.actualNOfDs = actualNOfDs;
    }

    public double getBorrowingPrice() {
        return borrowingPrice;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(int DBAGBDandGBD) {
        this.fine = DBAGBDandGBD * pricePerDay;
    }

    public void setBorrowingPrice(double pricePerDay) {
        this.borrowingPrice = pricePerDay * numberOfBorrwingDays;

    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int DBAGBDandGBD) {
        double discount = (DBAGBDandGBD -1) * pricePerDay;
        if (discount >= 0) {
            this.discount = discount;
        } else {
            this.discount = 0;
        }

    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int DB_BDandGBD) {
        this.finalPrice = DB_BDandGBD * pricePerDay;
    }

    public double getNumberOfBorrwingDays() {
        return numberOfBorrwingDays;
    }

    public void setNumberOfBorrwingDays(int numberOfBorrwingDays) {
        try {
            this.numberOfBorrwingDays = numberOfBorrwingDays;

        } catch (InputMismatchException e) {
            System.out.println("Not a number \n Do want to try again \n if so write yes");
            if (input.next() == "yes") {
                setNumberOfBorrwingDays(input.nextInt());

            }
        }
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
        setBorrowingPrice(pricePerDay);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;

    }

    public LocalDateTime getBorrwingDate() {
        return borrwingDate;
    }

    public LocalDateTime getGivingBackDate() {
        return givingBackDate;
    }

    public void setGivingBackDate(int NOfD) {
        this.givingBackDate = borrwingDate.plusDays(NOfD);
    }

    public LocalDateTime getActualGBD() {
        return actualGBD;
    }

    public void setActualGBD() {
        this.actualGBD = LocalDateTime.now();
        int durationBetweenAGBDandGBD = actualGBD.compareTo(givingBackDate);
        if (durationBetweenAGBDandGBD == 0) {
            setFine(0);
            setDiscount(0);

        } else if (durationBetweenAGBDandGBD < 0) {

            setFine(0);
            setDiscount(Math.abs(durationBetweenAGBDandGBD));

        } else {
            setFine(Math.abs(durationBetweenAGBDandGBD));
            setDiscount(0);

        }

        int dB_BDandGBD = actualGBD.compareTo(borrwingDate);
        setFinalPrice(dB_BDandGBD);
        setActualNOfDs(dB_BDandGBD);
    }

}
