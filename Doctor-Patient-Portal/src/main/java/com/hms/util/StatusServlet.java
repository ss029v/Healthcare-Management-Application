package com.hms.util;

import com.hms.db.DBConnection; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        
        StringBuilder statusMsg = new StringBuilder();
        statusMsg.append("Server: OK (Running)\n");
        statusMsg.append("Time: ").append(System.currentTimeMillis()).append("\n");

        // --- Database Keep-Alive Logic ---
        try {
            // 1. Get the connection (This triggers the self-healing logic we wrote in DBConnection)
            Connection conn = DBConnection.getConn();
            
            if (conn != null) {
                // 2. Fire a tiny query to keep the connection "warm"
                String keepAliveSql = "SELECT 1";
                
                // Use try-with-resources to close Statement/ResultSet automatically
                // BUT DO NOT close 'conn' because it is shared by your whole app!
                try (PreparedStatement ps = conn.prepareStatement(keepAliveSql);
                     ResultSet rs = ps.executeQuery()) {
                    
                    if (rs.next()) {
                        statusMsg.append("Database: OK (Alive)");
                    }
                }
            } else {
                statusMsg.append("Database: FAIL (Connection null)");
            }
        } catch (Exception e) {
            statusMsg.append("Database: ERROR (").append(e.getMessage()).append(")");
            e.printStackTrace(); // Log the error on the server console
        }

        // Send final response to the browser/uptime bot
        resp.getWriter().println(statusMsg.toString());
    }
}
