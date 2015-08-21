package com.busycoder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnection {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");	//指定连接类型
             }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
             }
    }
        private static String url="jdbc:mysql://localhost/ecglab";
        private static String userName="root";
        private static String password="123456";
        
   public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, userName, password);
        }
        
   public void closeConnection(Connection conn){
            try {
                if(conn != null) {
                    conn.close();
                    conn = null;
                     }
                 }
            catch (SQLException ex) {
                ex.printStackTrace();
                 }
         }
   public void closeStatement(Statement stmt){
         try {
              if(stmt != null) {
              stmt.close();
              stmt = null;
                 }
            }
         catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
   public void closeResultSet(ResultSet re){
         try {
              if(re != null) {
              re.close();
              re = null;
                 }
              }
         catch (SQLException ex) {
               ex.printStackTrace();
            }
       }
}
