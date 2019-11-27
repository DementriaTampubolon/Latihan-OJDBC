/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDao;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;

/**
 *
 * @author DELL
 */
public class EmployeeController {

    private EmployeeDao dao;

    public EmployeeController() {
        this.dao = new EmployeeDao();
    }

    public EmployeeController(EmployeeDao dao) {
        this.dao = dao;
    }

    public List<Employee> getAll() {
        return this.dao.selectEmployess();
    }

    public String create(String id, String firstname, String lastname,
            String email, String phone, String hire, String salary,
            String commision, String manager, String job, String department) throws ParseException {

//        try {
//            String jenis = "yyyy-MM-dd";
//            SimpleDateFormat dm =new SimpleDateFormat(jenis);
//            String tgl = String.valueOf(dm.format(date))
//        } catch (Exception e) {
//        }
        String startDate = hire;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(startDate);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        return this.dao.createEmployee(new Employee(Integer.parseInt(id), firstname,
                lastname, email, phone, sqlStartDate, Integer.parseInt(salary),
                Integer.parseInt(commision), new Employee(Integer.parseInt(manager)),
                new Job(job), new Department(Integer.parseInt(department))))
                ? "Success to Create Employee" : "Failed to Create Employee";
    }
////
//

    public String update(String id, String firstname, String lastname,
            String email, String phone, String hire, String job, String salary,
            String commision, String manager, String department) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(hire);
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

        return this.dao.updateEmployee(new Employee(Integer.parseInt(id), firstname,
                lastname, email, phone, sqlStartDate, Integer.parseInt(salary),
                Integer.parseInt(commision), new Employee(Integer.parseInt(manager)),
                new Job(job), new Department(Integer.parseInt(department))))
                ? "Success to Update Employee" : "Failed to Update Employee Because Data Already Update";
    }
//

    public String delete(String id) {
        return this.dao.deleteEmployee(new Employee(Integer.parseInt(id)))
                ? "Success to Delete Employee" : "Failed to Delete Employee Because Data Already Update";
    }
//

    public Employee selectById(String id) {
        return this.dao.selectById(Integer.parseInt(id));

    }

    public Employee selectByName(String name) {
        return this.dao.selectByName(name);

    }
//

    public List<Employee> search(String key) {
        return this.dao.searchEmployee(key);
    }

}
