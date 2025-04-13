package Employee_Directory;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String status = request.getParameter("status") != null ? "Present" : "Absent";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "root", "your_password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO attendance (name, roll, status) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, roll);
            ps.setString(3, status);
            ps.executeUpdate();

            request.getRequestDispatcher("attendance-success.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().println("Error saving attendance: " + e.getMessage());
        }
    }
}
