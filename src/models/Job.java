/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author USER
 */
public class Job {

    private String id;
    private String title;
    private int min_salary;
    private int max_salary;

    public Job(String id) {
        this.id = id;
    }

    public Job() {
        
    }
    

    public Job(String id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Job(String id, String title, int min_salary, int max_salary) {
        this.id = id;
        this.title = title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getMin_salary() {
        return min_salary;
    }

    public long getMax_salary() {
        return max_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

   
}
