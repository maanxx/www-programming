package iuh.fit.nguyenphanminhman_22679171_week03.util;

import iuh.fit.nguyenphanminhman_22679171_week03.model.Account;

import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.sql.DataSource;

public class AccountUtil {
    private DataSource datasource;

    public AccountUtil(DataSource datasource) throws Exception {
        this.datasource = datasource;
    }

    // Lấy danh sách account
    public List<Account> getAccounts() throws Exception {
        List<Account> accounts = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = datasource.getConnection();
            String sql = "SELECT * FROM accounts ORDER BY ID";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String fname = rs.getString("FIRSTNAME");
                String lname = rs.getString("LASTNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                Date dateOfBirth = rs.getDate("DATEOFBIRTH");
                Account acc = new Account(id, fname, lname, email, password, dateOfBirth);
                accounts.add(acc);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Đóng tài nguyên
            if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException ignored) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
        }
        return accounts;
    }

    // Thêm account
    public void addAccount(Account acc) throws Exception {
        String sql = "INSERT INTO accounts (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = datasource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getFirstname());
            ps.setString(2, acc.getLastname());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPassword());
            ps.setDate(5, (java.sql.Date) acc.getDateOfBirth());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
        }
    }
}
