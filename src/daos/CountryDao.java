/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Country;
import tools.Connections;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS
 */
public class CountryDao {

    private Connection connection;

    public CountryDao() {
        this.connection = new Connections().getConnection();
    }

//    public List<Country> selectCountries() {
//        List<Country> countrys = new ArrayList<>();
//        String query = "Select * from countries order by 1";
//
//        try {
//            PreparedStatement ps = this.connection.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Country country = new Country();
//                country.setId(rs.getString(1));
//                country.setName(rs.getString("country_name"));
//                country.setRegion_id(rs.getInt(3));
//                countrys.add(country);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return countrys;
//    }
    public List<Country> selectCountries() {
        List<Country> countrys = new ArrayList<>();
//        String query="Select c.country_id,c.country_name,r.region_name from countries c JOIN regions r ON c.region_id=r.region_id";
        String query = "Select"
                + " c.country_id,c.country_name,r.region_name,r.region_id "
                + "from "
                + " countries c "
                + "JOIN"
                + " regions r "
                + "ON"
                + " c.region_id = r.region_id "
                + "order by 1";

        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getString(1));
                country.setName(rs.getString(2));
                country.setRegion(new Region(rs.getInt("region_id"), rs.getString("region_name")));
                countrys.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;
    }

    public boolean createCountry(Country country) {
        boolean result = false;
        String query = "Insert into countries(country_name,region_id,country_id) "
                + "values(?,?,?)";
        return execute(query, country);
    }

    public boolean updateCountry(Country country) {
        boolean result = false;
        String query = "Update countries set country_name = ? , region_id= ? "
                + "where country_id = ? ";
        return execute(query, country);
    }

    public boolean deleteCountry(Country country) {
        boolean result = false;
        String query = "Delete from countries where country_id= ?";
        return execute(query, country);
    }

    public List<Country> searchCountry(String key) {
        List<Country> country = new ArrayList<>();
        String query = "Select"
                + " c.country_id,c.country_name,r.region_name,r.region_id "
                + "from "
                + " countries c "
                + "JOIN"
                + " regions r "
                + "ON"
                + " c.region_id = r.region_id "
                + "where"
                + " country_id like ? "
                + "OR "
                + " lower(country_name) like ? "
                +"OR "
                + " region_name like ? ";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //next itu untuk looping selanjutnya (karna yg di next adlh rs.next dan rs itu
                Country country1 = new Country();
                country1.setId(rs.getString(1)); // 1 itu untuk Column Index
                country1.setName(rs.getString("country_name")); //ini panggil nama column
                country1.setRegion(new Region(rs.getInt("region_id"), rs.getString("region_name")));
                country.add(country1); //add itu untuk list
            }

        } catch (Exception e) {
        }

        return country;

    }

    public Country selectById(String id) {
        Country country = new Country();
        String query = "select * from countries where country_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                country.setId(rs.getString(1));
                country.setName(rs.getString("country_name"));
                country.setRegion(new Region(rs.getInt("region_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    public Country selectByName(String name) {
        Country country = new Country();
        String query = "select * from countries where country_name = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                country.setId(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    private boolean execute(String query, Country country) {
        boolean result = false;
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            if (country.getName() == null) {
                ps.setString(1, country.getId());
            } else {
                ps.setString(1, country.getName());
                ps.setInt(2, country.getRegion().getId());
                ps.setString(3, country.getId());
            }
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
