package com.fe.nguyenphanminhman_tuan5.util;

import org.mariadb.jdbc.Connection;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DBUtil {
    private DataSource dataSource;

    public DBUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection conn ;

        try {
            conn = (Connection) dataSource.getConnection();
        } catch (SQLException ex ) {
            throw new RuntimeException(ex);
        }

        return conn;
    }
}
