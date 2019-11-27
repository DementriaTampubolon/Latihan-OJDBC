/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * class ini adalah class model untuk tabel "Region" seluruh nama kolom yang ada
 * di database dideklarasikan
 *
 * @author DELL
 */
public class Region {

    private int id;
    private String name;

    public Region() {
    }

    public Region(int id) {
        this.id = id;
    }

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * method untuk mengambil nilai id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method ini digunakan untuk menetapkan nilai id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method untuk mengambil isi name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method ini digunakan untuk menetapkan isi name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
