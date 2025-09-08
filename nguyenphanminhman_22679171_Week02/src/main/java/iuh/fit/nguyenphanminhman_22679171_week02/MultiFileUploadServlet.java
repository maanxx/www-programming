package iuh.fit.nguyenphanminhman_22679171_week02;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/uploadmulti")
@MultipartConfig
        (
                fileSizeThreshold = 1024 * 1024,
                maxFileSize = 1024 * 1024 * 10,
                maxRequestSize = 1024 * 1024 * 50
        )
public class MultiFileUploadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public MultiFileUploadServlet() {};

  private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // save folder on webapp folder
        String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIR;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // taking files from request
        for (Part part : req.getParts()) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                part.write(uploadPath + File.separator + fileName);
            }
        }
        resp.setContentType("text/html");
        resp.getWriter().println("<h3>FILE UPLOADED SUCCESSFULLY: " + uploadPath + "</h3>");
    }

    private String getFileName(Part part) {
        String contenDisp = part.getHeader("content-disposition");
        String[] tokens = contenDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() -1);
            }
        }
        return null;
    }

}