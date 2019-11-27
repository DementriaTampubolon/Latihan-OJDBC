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
import models.Department;
import tools.Connections;

/**
 *
 * @author HP
 */
public class DepartmentDao {

    private Connection connection;

    public DepartmentDao() {
        this.connection = new Connections().getConnection();
    }

    /**
     * Metode ini digunakan untuk menampilkan record secara keselurauhan pada
     * tabel departments.
     *
     * @return mengembalikan nilai region sebagai hasil.
     */
    public List<Department> selectDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS ORDER BY 1";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt(1));
                department.setName(rs.getString(2));
                department.setManId(rs.getInt(3));
                department.setLocId(rs.getInt(4));
                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * 
     * @param department
     * @return 
     */
    public boolean createDepartment(Department department) {
        String query = "INSERT INTO DEPARTMENTS (department_name, manager_id, location_id, department_id) VALUES (?,?,?,?)"; // lebih aman dengan meminimalisir sql injection.        
        return executeUpCre(query, department);
//        try {
//            PreparedStatement ps = this.connection.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setInt(2, manid);
//            ps.setInt(3, locid);
//            ps.setInt(4, id);
//            ps.executeUpdate();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 
     * @param department
     * @return 
     */
    public boolean updateDepartment(Department department) {
        String query = "UPDATE DEPARTMENTS SET department_name = ?, manager_id = ?, location_id = ? WHERE department_id= ?";
        return executeUpCre(query, department);
//        try {
//            PreparedStatement ps = this.connection.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setInt(2, manid);
//            ps.setInt(3, locid);
//            ps.setInt(4, id);
//            ps.executeUpdate();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean deleteDepartment(int id) {
        boolean result = false;
        String query = "DELETE FROM DEPARTMENTS WHERE department_id = ? ";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Department selectByName(String name) {
        Department department = new Department();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_name = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department.setId(rs.getInt(1));
                        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }
    
    public Department selectById(int id) {
        Department department = new Department();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department.setId(1);
                department.setName("department_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public List<Department> searchDepartment(String key) {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_id LIKE ? OR department_name LIKE ? OR manager_id LIKE ?OR location_id LIKE ? ";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ps.setString(4, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt(1));                                     // can use "department_id" using String column type
                department.setName(rs.getString("department_name"));
                department.setManId(rs.getInt(3));
                department.setLocId(rs.getInt(4));
                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    /**
     * 
     * @param query
     * @param department
     * @return 
     */
    public boolean executeUpCre(String query, Department department) {
        boolean result = false;
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, department.getName());
            ps.setInt(2, department.getManId());
            ps.setInt(3, department.getLocId());
            ps.setInt(4, department.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
