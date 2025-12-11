
//package com.hms.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DBConnection {
//
//	private static Connection conn;
//	
//	public static Connection getConn() {
//		
//		try {
//			
//			//step:1 for connection - load the driver class 
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			//step:2- create a connection
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","Zx@12345");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODOxxxxxxx: handle exception
//		}
//		
//		return conn;
//	}
//}

package com.hms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn;

    public static Connection getConn() {
        try {
            // CRITICAL FIX:
            // We verify the connection is actually alive before returning it.
            // 1. conn == null: First time startup
            // 2. conn.isClosed(): Standard closure
            // 3. !conn.isValid(2): Checks if Aiven/Network dropped the link (timeout 2 seconds)
            if (conn == null || conn.isClosed() || !conn.isValid(2)) {
                
                Class.forName("com.mysql.cj.jdbc.Driver");

                String host = System.getenv("MYSQLHOST");
                String port = System.getenv("MYSQLPORT");
                String dbName = System.getenv("MYSQLDATABASE");
                String user = System.getenv("MYSQLUSER");
                String password = System.getenv("MYSQLPASSWORD");

                // Local fallback for dev
                if (host == null) host = "localhost";
                if (port == null) port = "3306";
                if (dbName == null) dbName = "hospitaldb";
                if (user == null) user = "root";
                if (password == null) password = "Zx@12345";

                // UPDATED URL: Added autoReconnect and tcpKeepAlive
                String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + 
                             "?useSSL=false&serverTimezone=UTC&autoReconnect=true&tcpKeepAlive=true";
                
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private DBConnection() {}
}

