/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author Rizky
 */
public class Location {
    
    private int id;
    private String street,postal,city,state;
    private Country country;

    public Location() {
    }
    
    

    public Location(int id) {
        this.id = id;
    }

    public Location(int id, String street) {
        this.id = id;
        this.street = street;
    }

    public Location(int id, String street, String postal, String city, String state, Country country) {
        this.id = id;
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Location(int id, String street, String postal, String city, String state) {
        this.id = id;
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    
    
    
}
