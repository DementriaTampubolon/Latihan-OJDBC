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
import models.Region;
import tools.Connections;

/**
 * class ini untuk membuat query insert, update, delete, select, select by id
 * dan search
 *
 * @author DELL
 */
public class RegionDao {

    private Connection connection;

    /**
     * method untuk menambahkan koneksinya tanpa parameter
     */
    public RegionDao() {
        this.connection = new Connections().getConnection();
    }

    /**
     * method untuk menambahkan koneksinya menggunakan parameter
     *
     * @param connection
     */
    public RegionDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * method untuk menampilkan seluruh region karena ingin menampilkan seluruh
     * yang ada tidak tipe datanya yg pasti maka digunkan list region karena
     * ingin menampilkan banyak row data dibutuhkan penampung menggunakan
     * perulangan sebanyak next yaitu sebanyak data yang ada pada set id boleh
     * menggunakan region_id seperti set name
     *
     * @return
     */
    public List<Region> selectRegions() {
        List<Region> regions = new ArrayList<>();
        String query = "select * from regions order by 1";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Region region = new Region();
                region.setId(rs.getInt(1));
                region.setName(rs.getString("region_name"));
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    /**
     * method ini digunakan untuk menambah region (insert query) method ini non
     * void menggunakan tipe data boolean karena hasil yang keluar hanya akan
     * true(berhasil) atau false(gagal) insert ada dua jenis query, yang
     * menggunakan tanda tanya kita harus set prepared statementnya
     *
     * @param id
     * @param name
     * @return result
     */
    //public boolean createRegion(int id, String name) {
    public boolean createRegion(Region region) {

        String query = "insert into regions (region_name, region_id) values (?,?)";
        return execute(query, region);

    }

    /**
     * method untuk update
     *
     * @param id
     * @param name
     * @return result
     */
    //public boolean updateRegion(int id, String name) {
    public boolean updateRegion(Region region) {

        String query = "update regions set region_name=? where region_id=?";
        return execute(query, region);
    }
    
    

    /**
     * method ini digunakan untuk menghapus region method ini non void
     * menggunakan tipe data boolean karena hasil yang keluar hanya akan
     * true(berhasil) atau false(gagal) hapus
     *
     * @param id
     * @return result
     */
    public boolean deleteRegion(Region region) {

        String query = "delete from regions where region_id=?";
        return execute(query,region);
    }

    /**
     * method untuk menampilkan region berdasarkan id tertentu method ini non
     * void dengan tipe data Region pada set id boleh menggunakan region_id
     * seperti set name
     *
     * @param id
     * @return region
     */
    public Region selectById(int id) {
        Region region = new Region();
        String query = "select * from regions where region_id=?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                region.setId(rs.getInt(1));
                region.setName(rs.getString("region_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }

    /**
     * method untuk mencari region method ini non void menggunakan tipe list
     * region pada set id boleh menggunakan region_id seperti set name
     *
     * @param key
     * @return regions
     */
    public List<Region> searchRegion(String key) {
        List<Region> regions = new ArrayList<>();
        String query = "Select * from regions where region_id like ? or region_name like ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Region region = new Region();
                region.setId(rs.getInt(1));
                region.setName(rs.getString("region_name"));
                regions.add(region);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    /**
     * menggabungkan trycatch antara fungsi create update
     *
     * @param query
     * @param name
     * @param id
     * @return result
     */
//    public boolean execute(String query, String name, int id) {
    public boolean execute(String query, Region region) {

        boolean result = false;
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            if (region.getName() == null) {
                ps.setInt(1, region.getId());
            } else {
                ps.setString(1, region.getName());
                ps.setInt(2, region.getId());
            }
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
