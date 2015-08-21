package com.busycoder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class BaseDao {
    protected DBConnectionPool dbConn;
    
    public BaseDao() {
       dbConn = new DBConnectionPool();
    }    
    
    public int updateBySQL(String sql){
    	Connection conn=null;
    	Statement stmt=null;
    	try{
    		conn=dbConn.getConnection();
    		stmt=conn.createStatement();
    		return stmt.executeUpdate(sql);
        }
    	catch(NamingException ne){
    		ne.printStackTrace();
    		return -1;
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		return -1;
        }
    	finally{ 
    		dbConn.closeStatement(stmt);
    		dbConn.closeConnection(conn);
        }
    }
    
    public int updateBySQL(String sql,BeansMapper bind){
    	Connection conn=null;
        PreparedStatement pstmt=null;
        try{
        	conn=dbConn.getConnection();
            boolean autoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);	//数据的一致性
            pstmt=conn.prepareStatement(sql);
            bind.bindBean(pstmt);
            int ef=pstmt.executeUpdate();
            conn.setAutoCommit(autoCommit);
            return ef;
        }
        catch(NamingException ne){
    		ne.printStackTrace();
    		return -1;
    	}
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
        finally{    
            dbConn.closeStatement(pstmt);
            dbConn.closeConnection(conn);
        }
    }
    
    public int[] executeBatch(String[] sqls){
    	Connection conn=null;
        Statement stmt=null;
        try{
            conn=dbConn.getConnection();
            stmt=conn.createStatement();
            for(int i=0;i<sqls.length;i++){
               stmt.addBatch(sqls[i]);
            }
            return stmt.executeBatch();
        }
        catch(NamingException ne){
        	ne.printStackTrace();
        	return null;
     	}
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        finally{
            dbConn.closeStatement(stmt);
            dbConn.closeConnection(conn);
        }
    }           
   // public abstract Object map(ResultSet re);
    public List<Object> queryBySQL(String sql,BeansMapper mapper){
    	Connection conn=null;
        Statement stmt=null;
        ResultSet re=null;
        List<Object> retlist=new ArrayList<Object>();
        try{
        	conn=dbConn.getConnection();
            stmt = conn.createStatement();         
            re=stmt.executeQuery(sql);           
            while(re.next()){
            	Object obj= mapper.mapBean(re);
                retlist.add(obj);
            }
        }
        catch(NamingException ne){
    		ne.printStackTrace();
    	}
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{ 
        	dbConn.closeResultSet(re);
        	dbConn.closeStatement(stmt);
        	dbConn.closeConnection(conn);}
         	return retlist;
    	}
    
    public Object queryOneBySQL(String sql,BeansMapper mapper){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet re=null;
        Object obj = null;
        try{
        	conn=dbConn.getConnection();
        	pstmt = conn.prepareStatement(sql);  
        	mapper.bindBean(pstmt);
        	re=pstmt.executeQuery();
        	if(re.next()){
        		obj = mapper.mapBean(re);
        	}
        }
        catch(NamingException ne){
    		ne.printStackTrace();
    	}
        catch(SQLException ex){
           ex.printStackTrace();
           }
        finally{
        	dbConn.closeResultSet(re);
        	dbConn.closeStatement(pstmt);
        	dbConn.closeConnection(conn);
        }
        return obj;
    }
}