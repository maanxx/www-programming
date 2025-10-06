package iuh.fit.nguyenphanminhman_22679171_week03.servlet;

import iuh.fit.nguyenphanminhman_22679171_week03.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

@WebServlet("/student")
@MultipartConfig
public class StudentServlet extends HttpServlet {
    public StudentServlet() {

    }
    @Override
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirthStr = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("mobile");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String[] hobbies = request.getParameterValues("hobbies");

        // Xử lý ngày sinh (giả định input là yyyy-MM-dd)
        LocalDate dateOfBirth = null;
        if (dateOfBirthStr != null && !dateOfBirthStr.isEmpty()) {
            dateOfBirth = LocalDate.parse(dateOfBirthStr);
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(dateOfBirth);
        student.setGender(gender);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setAddress(address);
        student.setCity(city);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);
        student.setHobbies(hobbies);
        System.out.println("Hobbies: " + Arrays.toString(hobbies));
        request.setAttribute("student", student);

        request.getRequestDispatcher("/student-result.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
