package com.shuvam.REST.Entity;

public class Student {
    private String firstName;
    private String lastName;
    public Student(){

    }
    public Student(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setFirstName(String fName){
        this.firstName=fName;
    }
    public void setLastName(String lName){
        this.lastName=lName;
    }
}
