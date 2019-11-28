/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author DELL
 */
public class Connections {

    private Connection connection = null;

    /**
     * fungsi ini untuk mengkoneksikan databasenya, contohnya disini adalah
     * mengkoneksikan dengan database HR jgn lupa alter session agar table dapat
     * diakses
     *
     * @return menggembalikan nilai this.connection
     */
    public Connection getConnection() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setDriverType("thin");
            dataSource.setServerName("localhost");
            dataSource.setPortNumber(1521);
            dataSource.setServiceName("xe");
            dataSource.setDatabaseName("HR");

            dataSource.setUser("system");
            dataSource.setPassword("jafar");
            this.connection = dataSource.getConnection();
            this.connection.createStatement().execute("alter session set current_schema=HR");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return this.connection;
    }

}
