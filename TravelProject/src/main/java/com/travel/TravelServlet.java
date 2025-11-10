package com.travel;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

public class TravelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String date = request.getParameter("travel_date");
        String source = request.getParameter("source_place");
        String dest = request.getParameter("destination_place");
        String mode = request.getParameter("mode_of_travel");
        String company = request.getParameter("company_type");
        String friends = request.getParameter("friends_names");
        String distance = request.getParameter("distance_km");
        String cost = request.getParameter("cost");

        Connection con = null;
        PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel_db", "root", "Mallibm@321");

            String query = "INSERT INTO travel_details (travel_date, source_place, destination_place, mode_of_travel, company_type, friends_names, distance_km, cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, date);
            pst.setString(2, source);
            pst.setString(3, dest);
            pst.setString(4, mode);
            pst.setString(5, company);
            pst.setString(6, friends);
            pst.setFloat(7, Float.parseFloat(distance));
            pst.setDouble(8, Double.parseDouble(cost));

            int rows = pst.executeUpdate();

            if (rows > 0) {
                out.println("<h3>✅ Travel details added successfully!</h3>");
            } else {
                out.println("<h3>❌ Failed to add travel details.</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            try { pst.close(); con.close(); } catch (Exception e) {}
        }
    }
}

