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
public class Student extends Person {

    private String stage;
    private ArrayList<Borrowing> BorrSV = new ArrayList<>();

    
    
    public void setBorrSV(Borrowing BorrSE) {
        BorrSV.add(BorrSE);
    }

    public void removeBorrSV(Borrowing BorrSE) {
        BorrSV.remove(BorrSE);
    }

    public ArrayList<Borrowing> getBorrSV() {
        return this.BorrSV;
    }

    public void Set_stage(String St) {
        this.stage = St;
    }

    public String Get_stage() {
        return this.stage;
    }

}
