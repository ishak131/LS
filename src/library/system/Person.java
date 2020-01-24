/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.system;

/**
 *
 * @author Magic
 */
public abstract class Person {
    
    private String F_name ,S_name ,Full_name ,gender,Email,user_name,password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private int age;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
     
    public void Set_name(String Name){
        this.Full_name = Name; 
        setUser_name(F_name+S_name+"@maktaba.com");
    }
    
    public String Get_name(){
       return this.Full_name; 
    }
    
    public void Set_gender(String Gender){
        this.gender = Gender; 
    }
    
    public String Get_gender(){
       return this.gender; 
    }
    
    public void Set_age(int Age){
        this.age = Age; 
    }
    
    public int Get_age(){
       return this.age; 
    }

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    public void setS_name(String S_name) {
        this.S_name = S_name;
    }

    public String getF_name() {
        return F_name;
    }

    public String getS_name() {
        return S_name;
    }
    
    
}
