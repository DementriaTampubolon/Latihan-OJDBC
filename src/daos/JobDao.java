/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import tools.Connections;

/**
 *
 * @author USER
 */
public class JobDao {

    private Connection connection;

    public JobDao(Connection connection) {
        this.connection = connection;
    }

    public JobDao() {
        this.connection = new Connections().getConnection();
    }

    public List<Job> selectJob() {
        List<Job> jobs = new ArrayList<Job>();
        String query = "select * from jobs order by job_id ASC";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getString("job_id"));
                job.setTitle(rs.getString("job_title"));
                job.setMin_salary(rs.getInt("min_salary"));
                job.setMax_salary(rs.getInt("max_salary"));
                jobs.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public boolean createJob(Job job) {

        String query = "insert into jobs ( job_title, min_salary, max_salary, job_id) values (?,?,?,?)";
        return execute(query, job);

    }

    public boolean updateJob(Job job) {

        String query = "update jobs set job_title= ?, min_salary = ?,max_salary = ? where job_id = ?";
        return execute(query, job);
    }

    public boolean deleteJob(Job job) {

        String query = "delete from jobs where job_id=?";
        return execute(query, job);
    }

    public Job selectById(String id) {
        Job job = new Job();
        String query = "select * from jobs where job_id=?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                job.setId(rs.getString("job_id"));
                job.setTitle(rs.getString("job_title"));
                job.setMin_salary(rs.getInt(3));
                job.setMax_salary(rs.getInt(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }

    public List<Job> searchJob(String key) {
        List<Job> jobs = new ArrayList<>();
        String query = "Select job_id, job_title, min_salary, max_salary from jobs where job_id like ? or job_title like ? or min_salary like ? or max_salary like ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ps.setString(4, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setId(rs.getString("job_id"));
                job.setTitle(rs.getString("job_title"));
                job.setMin_salary(rs.getInt("min_salary"));
                job.setMax_salary(rs.getInt("max_salary"));

                jobs.add(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    private boolean execute(String query, Job job) {
        boolean result = false;
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            if (job.getTitle() == null) {
                ps.setString(1, job.getId());
            } else {
                ps.setString(1, job.getTitle());
                ps.setInt(2, (int) job.getMin_salary());
                ps.setInt(3, (int) job.getMax_salary());
                ps.setString(4, job.getId());
            }
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Job selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
