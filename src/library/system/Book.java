/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.system;

import java.util.*;

/**
 *
 * @author romany
 */
public class Book {

    Scanner input = new Scanner(System.in);
    private String name, type, aouther;
    private int numberOfCopies, borrowed, remain;
    private double pricePerDay;

    Book() {

        remain = numberOfCopies;
        borrowed = 0;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerHoure(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        System.out.println("Choose type");
        System.out.println("1- Book");
        System.out.println("2- Magazine");
        System.out.println("3- Booklet");
        switch (input.next()) {
            case "1":
                this.type = "Book";
                break;
            case "2":
                this.type = "Magazine";
                break;
            case "3":
                this.type = "Booklet";
                break;
            default:
                System.out.println("This is not one of the choices \n Do you want to try again ? \n if so write yes");
                
                if (input.next().equals("yes")) {
                    setType();
                }
        }
       
    }

    public String getAouther() {
        return aouther;
    }

    public void setAouther(String aouther) {
        this.aouther = aouther;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(int borrowed) {
        if (borrowed < this.numberOfCopies && borrowed >= 0) {
            this.borrowed = borrowed;
        } else {
            System.out.println("Sorry it is not available");
        }
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        if (remain > 0 && remain <= this.numberOfCopies) {
            this.remain = remain;
        }
    }

}
