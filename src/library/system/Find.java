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
public abstract class Find {

    public static int FindS(ArrayList<Student> SV,String ST_name ) {
        int index = -1;
        for (Student s : SV) {
            if (s.Get_name().equals(ST_name)) {
                index = SV.indexOf(s);
                break;
            }
        }
        return index;
    }

    public static int FindB(ArrayList<Book> BV , String B_name) {
        
        int index = -1;
        for (Book B : BV) {
            if (B.getName().equals(B_name)) {

                index = BV.indexOf(B);
                break;
            }
        }
            return index;
    }
}


