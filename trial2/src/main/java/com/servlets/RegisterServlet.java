package com.servlets;

import com.config.DatabaseConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Database insertion
        try (Connection conn = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log error properly in production
            request.setAttribute("errorMessage", "Database error occurred.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }

}
