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
    private Employee manId;
    private Location locId;

    public Department() {
    }

    public Department(int id) {
        this.id = id;
    }

    public Department(String name) {
        this.name = name;
    }
    

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(int id, String name, Employee manId, Location locId) {
        this.id = id;
        this.name = name;
        this.manId = manId;
        this.locId = locId;
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

    public Employee getManId() {
        return manId;
    }

    public void setManId(Employee manId) {
        this.manId = manId;
    }

    public Location getLocId() {
        return locId;
    }

    public void setLocId(Location locId) {
        this.locId = locId;
    }
    
    
}
