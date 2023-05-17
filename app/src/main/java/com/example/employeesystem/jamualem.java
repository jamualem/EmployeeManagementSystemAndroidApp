package com.example.employeesystem;

public class jamualem {
    int id;
    String firstname;
    String middlename;
    String gender;
    String salary;
    String department;

    jamualem(){}
    jamualem(int idk,String firstnamek,String middlenamek,String genderk,String salaryk,String departmentk)
    {
        this.id=idk;
        this.firstname=firstnamek;
        this.middlename=middlenamek;
        this.gender=genderk;
        this.salary=salaryk;
        this.department=departmentk;
    }
    jamualem(String firstnamek,String middlenamek,String genderk,String salaryk,String departmentk){
        this.firstname=firstnamek;
        this.middlename=middlenamek;
        this.gender=genderk;
        this.salary=salaryk;
        this.department=departmentk;
    }
    jamualem(int idk){
        this.id=idk;
    }



    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }


    public String getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }



    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
