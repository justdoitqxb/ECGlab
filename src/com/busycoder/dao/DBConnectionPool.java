package com.busycoder.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBConnectionPool {

	public Connection getConnection() throws NamingException, SQLException{
		InitialContext initC = new InitialContext();	//创建InitialContext对象
		DataSource ds = (DataSource)initC.lookup("java:comp/env/jdbc/ECGlab");	//tomcat服务器配置文件中数据源名称
        return ds.getConnection();
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
