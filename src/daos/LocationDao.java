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
import java.util.List;
import models.Country;
import models.Location;
import tools.Connections;

/**
 *
 * @author Rizky
 */
public class LocationDao {

    private Connection connection;
    Country country = new Country();
    /**
     * membuat koneksi baru ke dalam database
     */
    public LocationDao() {
        this.connection = new Connections().getConnection();
    }
    
    /**
     * membuat koneksi baru ke dalam database
     * @param connection variabel koneksi
     */
    public LocationDao(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * menampilkan semua data location
     * @return data location dalam bentuk result set, ditampilkan berulang menggunakan
     * while
     */
//    public List<Location> selectLocations() {
//        List<Location> locations = new ArrayList<>();
//        String query = "SELECT l.location_id, l.street_address, l.postal_code, "
//                + "l.city, l.state_province, l.country_id FROM LOCATIONS L ORDER BY LOCATION_ID";
//
//        try {
//            PreparedStatement ps = this.connection.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Location location = new Location();
//                location.setId(rs.getInt("location_id"));
//                location.setStreet(rs.getString("street_address"));
//                location.setPostal(rs.getString("postal_code"));
//                location.setCity(rs.getString("city"));
//                location.setState(rs.getString("state_province"));
//                location.setCountryid(rs.getString("country_id"));
//                locations.add(location);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return locations;
//    }
    
    public List<Location> selectJoinLocations(){
        List<Location> ls = new ArrayList<>();
        String query = "SELECT "
                + "l.location_id, "
                + "l.street_address, "
                + "l.postal_code, "
                + "l.city, "
                + "l.state_province, "
                + "c.country_id, "
                + "c.country_name "
                + "FROM LOCATIONS L JOIN COUNTRIES C "
                + "ON l.country_id=c.country_id "
                + "ORDER BY l.location_id";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt("location_id"));
                location.setStreet(rs.getString("street_address"));
                location.setPostal(rs.getString("postal_code"));
                location.setCity(rs.getString("city"));
                location.setState(rs.getString("state_province"));
                location.setCountry(new Country(rs.getString("country_id"), rs.getString("country_name")));
                ls.add(location);
            }
        } catch (Exception e) {
        }
        return ls;
    }
    
    /**
     * membuat data location yang baru
     * @param location parameter yang diambil dari Model Location.java
     * @return mengembalikan data ke dalam fungsi execCreUpDel
     */
    public boolean createLocation(Location location) {
//        String query = "INSERT INTO LOCATIONS (location_id, street_address, postal_code,"
//                + " city, state_province, country_id) VALUES (?,?,?,?,?,?)";
            String query = "INSERT INTO LOCATIONS (street_address, postal_code,"
                + " city, state_province, country_id, location_id) VALUES (?,?,?,?,?,?)";
        return execCreUpDel(query, location);
    }

    /**
     * mengubah data location
     * @param location parameter yang diambil dari model Location.java
     * @return mengembalikan data ke dalam fungsi execCreUpDel
     */
    public boolean updateLocation(Location location) {
        String query = "UPDATE LOCATIONS SET street_address=?, postal_code=?, city=?, "
                + "state_province=?, country_id=? where location_id=?";
        return execCreUpDel(query, location);
    }
    
    /**
     * menghapus data location
     * @param location parameter yang diambil dari model Location.java
     * @return mengembalikan data ke dalam fungsi execCreUpDel
     */
    public boolean deleteLocation(Location location) {
        String query = "DELETE FROM LOCATIONS WHERE location_id=?";
        return execCreUpDel(query, location);
    }

    /**
     * menampilkan data sesuai id location yang diinputkan
     * @param location parameter yang diambil dari model Location.java
     * @return data location yang sesuai dengan id yang diinputkan
     */
    public Location selectLocById(Location location) {
        Location loc = new Location();
        String query = "SELECT * FROM LOCATIONS WHERE location_id=?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, location.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loc.setId(rs.getInt(1));
                loc.setStreet(rs.getString("street_address"));
                loc.setCity(rs.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loc;
    }
    
    /**
     * mencari data location sesuai inputan
     * @param key parameter yang digunakan untuk mencari data
     * @return data location yang sesuai dengan inputan, ditampilkan melalui Result set
     * yang ditampilkan berulan dengan while
     */
    public List<Location> searchLocation(String key){
        List<Location> ls = new ArrayList<>();
        String query = "SELECT "
                + "l.location_id, "
                + "l.street_address, "
                + "l.postal_code, "
                + "l.city, "
                + "l.state_province, "
                + "c.country_id, "
                + "c.country_name "
                + "FROM LOCATIONS L JOIN COUNTRIES C "
                + "ON l.country_id=c.country_id "
                + "WHERE l.location_id LIKE ? OR l.street_address LIKE ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location location = new Location();
                location.setId(rs.getInt(1));
                location.setStreet(rs.getString(2));
                location.setPostal(rs.getString(3));
                location.setCity(rs.getString(4));
                location.setState(rs.getString(5));
                location.setCountry(new Country(rs.getString("country_id"), rs.getString("country_name")));
                ls.add(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    /**
     * fungsi untuk eksekusi perintah create, update, dan delete pada data locations.
     * @param query mengambil perintah query sebelumnya yang ada di function create,
     * update, ataupun delete
     * @param location parameter yang diambil dari model location.java
     * @return mengembalikan nilai T/F dari eksekusi query tsb.
     */
    public boolean execCreUpDel(String query, Location location) {
        boolean result = false;
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
//            if (location.getStreet() == null && location.getCity() == null) {
//                //delete function
//                ps.setInt(1, location.getId());
//            } else if (location.getCity() == null) {
//                //untuk update
//                ps.setString(1, location.getStreet());
//                ps.setInt(2, location.getId());
//            } else {
//                //untuk insert
//                ps.setInt(1, location.getId());
//                ps.setString(2, location.getStreet());
//                ps.setString(3, location.getPostal());
//                ps.setString(4, location.getCity());
//                ps.setString(5, location.getState());
//                ps.setString(6, location.getCountryid());
//            }
            if (location.getStreet() == null) {
                //delete function
                ps.setInt(1, location.getId());
            } else {
                //untuk insert update
                ps.setString(1, location.getStreet());
                ps.setString(2, location.getPostal());
                ps.setString(3, location.getCity());
                ps.setString(4, location.getState());
                ps.setString(5, location.getCountry().getId());
                ps.setInt(6, location.getId());
            }
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
