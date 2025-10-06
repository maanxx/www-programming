package iuh.fit.nguyenphanminhman_22679171_week03.servlet;

import iuh.fit.nguyenphanminhman_22679171_week03.model.Account;
import iuh.fit.nguyenphanminhman_22679171_week03.util.AccountUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/registerform")

public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountUtil accountUtil;

    @Resource(name = "jdbc/accounts")
    private DataSource dataSource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            accountUtil = new AccountUtil(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        int day = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));

        LocalDate localDate = LocalDate.of(year, month, day);
        java.sql.Date dob = java.sql.Date.valueOf(localDate);

        // Lưu ý: Đảm bảo constructor Account phù hợp với số lượng tham số!
        Account account = new Account(firstname, lastname, email, password, dob);

        try {
            accountUtil.addAccount(account);
            List<Account> accounts = accountUtil.getAccounts();
            req.setAttribute("accounts", accounts);
            RequestDispatcher rd = req.getRequestDispatcher("account.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Có thể hiển thị form đăng ký ở đây nếu muốn
    }
}
