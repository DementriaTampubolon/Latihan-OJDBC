/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP
 */
public class Department {
    private int id;
    private String name;
    private int manId;
    private int locId;

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }

    public Department(String name) {
        this.name = name;
    }
    

    public Department(int id, String name, int manId, int locId) {
        this.id = id;
        this.name = name;
        this.manId = manId;
        this.locId = locId;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }
    
    
}
