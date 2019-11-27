/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import oracle.sql.DATE;

/**
 *
 * @author DELL
 */
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Date hire;
    private int salary;
    private int commission;
    private Employee manager;
    private Job job;
    private Department department;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String firstname) {
        this.firstname = firstname;
    }
    

    public Employee(int id, String firstname, String lastname, String email, String phone, Date hire, int salary, int commission, Employee manager, Job job, Department department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.hire = hire;
        this.salary = salary;
        this.commission = commission;
        this.manager = manager;
        this.job = job;
        this.department = department;
    }

   
    

    public Employee(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }
    

    public Employee(int id, String firstname, String lastname, String email, String phone, Date hire, int salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.hire = hire;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getHire() {
        return hire;
    }

    public void setHire(Date hire) {
        this.hire = hire;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    

    
    

    
    
   
    
}
