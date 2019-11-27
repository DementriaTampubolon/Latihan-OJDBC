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
import models.Employee;
import models.Location;
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
//        String query = "select d.department_id , d.department_name, e.first_name, l.location_id, l.city, e.employee_id  from employees e left join departments d on e.employee_id = d.manager_id join locations l on l.location_id = d.location_id order by 1";
        String query = "select d.department_id , d.department_name, e.first_name, l.city, e.employee_id, l.location_id from departments d left join employees e on d.manager_id = e.employee_id join locations l on d.location_id = l.location_id order by 1";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt(1));
                department.setName(rs.getString(2));
                department.setManId(new Employee(rs.getInt("employee_id"), rs.getString("first_Name")));
                department.setLocId(new Location(rs.getInt("location_id"), rs.getString("city")));
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
    public boolean deleteDepartment(Department department) {
//        boolean result = false;
        String query = "DELETE FROM DEPARTMENTS WHERE department_id = ? ";
//        try {
//            PreparedStatement ps = this.connection.prepareStatement(query);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return executeUpCre(query, department);
    }

    /**
     *
     * @param id
     * @return
     */
    public Department selectById(int id) {
        Department department = new Department();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("department_name"));
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
        String query = "select d.department_id , d.department_name, e.first_name, l.city, e.employee_id, l.location_id  from departments d left join employees e on d.manager_id = e.employee_id join locations l on d.location_id = l.location_id WHERE d.department_id LIKE ? OR d.department_name LIKE ? OR d.manager_id LIKE ? OR d.location_id LIKE ? OR e.first_name LIKE ? OR l.city LIKE ?";
//        String query = "select d.department_id , d.department_name, e.first_name, l.city, e.employee_id, l.location_id  from departments d left join employees e on d.manager_id = e.employee_id join locations l on d.location_id = l.location_id WHERE regexp_like (d.department_id || d.department_name || e.first_name || d.location_id, '?', 'i'), d.department_id LIKE ? OR d.department_name LIKE ? OR d.manager_id LIKE ? OR d.location_id LIKE ? OR e.first_name LIKE ? OR l.city LIKE ? order by 1";
//        String query = "select d.department_id , d.department_name, e.first_name, l.city, e.employee_id, l.location_id from departments d left join employees e on d.manager_id = e.employee_id join locations l on d.location_id = l.location_id WHERE regexp_like (d.department_id || d.department_name || e.first_name || d.location_id, '?,?,?,?', 'i') order by 1";
//        String query = "select d.department_id , d.department_name, e.first_name, l.city, e.employee_id, l.location_id \n"
//                + "from departments d \n"
//                + "left join employees e \n"
//                + "on d.manager_id = e.employee_id \n"
//                + "join locations l \n"
//                + "on d.location_id = l.location_id\n"
//                + "WHERE regexp_like (d.department_id || d.department_name || e.first_name || l.city, '(?)', 'i')";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ps.setString(4, "%" + key + "%");
            ps.setString(5, "%" + key + "%");
            ps.setString(6, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt(1));                                     // can use "department_id" using String column type
                department.setName(rs.getString("department_name"));
                department.setManId(new Employee(rs.getInt("employee_id"), rs.getString("first_Name")));
//                department.setManId(new Employee(rs.getInt("first_name")));
                department.setLocId(new Location(rs.getInt("location_id"), rs.getString("city")));
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
            if (department.getName() == null) {
                ps.setInt(1, department.getId());
            } else {
                ps.setString(1, department.getName());
                ps.setInt(2, (int) department.getManId().getId());
                ps.setInt(3, (int) department.getLocId().getId());
                ps.setInt(4, (int) department.getId());
            }
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

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

}
