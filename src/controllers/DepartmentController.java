/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDao;
import java.util.List;
import models.Department;
import models.Region;

/**
 *
 * @author HP
 */
public class DepartmentController {

    private DepartmentDao dao;

    public DepartmentController() {
        this.dao = new DepartmentDao();
    }

    public DepartmentController(DepartmentDao dao) {
        this.dao = dao;
    }

    public String create(String id, String name, String manid, String locid) {
//        String message="Failed to Create Region";
//        Region region = new Region();
//        int ids = Integer.parseInt(id);
//        region.setId(ids);
//        region.setName(name);
//        if(this.dao.createRegion(new Region(Integer.parseInt(id), name))){
//            message="Success to Create Region";
//        }
//        return this.dao.createRegion(new Region(Integer.parseInt(id), name)) ?
        return this.dao.createDepartment(new Department(Integer.parseInt(id), name, Integer.parseInt(manid), Integer.parseInt(locid)))
                ? "Success to Create Department" : "Failed to Create Department";
    }

    public String update(String id, String name, String manid, String locid) {
        return this.dao.updateDepartment(new Department(Integer.parseInt(id), name, Integer.parseInt(manid), Integer.parseInt(locid)))
                ? "Success to Update Department" : "Failed to Update Department";
    }

    public String delete(String id) {
        //return this.dao.deleteDepartment(new Department(Integer.parseInt(id))) ? "sukses dong" : "gagal dong";
        return this.dao.deleteDepartment(Integer.parseInt(id))
                ? "Success to Delete Department" : "Failed to Delete Department";

    }

    public List<Department> getAll() {

        return this.dao.selectDepartments();
    }

    public Department selectById(String id) {

        return this.dao.selectById(Integer.parseInt(id));
    }

    public Department selectByName(String name) {

        return this.dao.selectByName(name);
    }

    public List<Department> search(String key) {

        return this.dao.searchDepartment(key);
    }

}
