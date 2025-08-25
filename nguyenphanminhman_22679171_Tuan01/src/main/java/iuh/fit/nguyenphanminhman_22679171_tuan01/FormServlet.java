package iuh.fit.nguyenphanminhman_22679171_tuan01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class FormServlet extends HttpServlet {

    // Xu ly post gui form
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Lay data tu form
        String name = req.getParameter("fullname");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobby");
        String country = req.getParameter("country");
        String birthdate = req.getParameter("birthdate");

        // take a file
        Part  filePart = req.getPart("picture");
        String fileName = filePart.getSubmittedFileName();

        // save in uploads folder
        String uploadPath = System.getProperty("user.home") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // save a file in folder
        filePart.write(uploadPath + File.separator + fileName);


        // Output:
        PrintWriter out = resp.getWriter();

        out.println("<h1>Form Example</h1>");
        out.println("Name:" + name + "<br>");
        out.println("Password:" + password + "<br>");
        out.println("Gender:" + gender + "<br>");
        out.println("Hobbies" + (hobbies != null ? String.join(", ", hobbies) : "None") + "<br>");
        out.println("Country:" + country + "<br>");
        out.println("Birthdate:" + birthdate + "<br>");
        out.println("Saved file:" + fileName + "<br>");
        out.println("Uploaded Path:" + uploadPath + "<br>");



    }
}
