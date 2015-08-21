package com.busycoder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.busycoder.bean.User;

public class UserDao extends BaseDao{
	
    public void save(final User model){
    	String sql="insert into ECG_user(username,password) values(?,?)"; 
    	super.updateBySQL(sql,new BeansMapper() {
			@Override
			public Object mapBean(ResultSet re) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void bindBean(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1,model.getUserName());
	            pstmt.setString(2,model.getPassword());
			}            
        } );
    }
    
    public void update(final User model){
    	String sql="update ECG_user set username=?,password=?"; 
        super.updateBySQL(sql,new BeansMapper() {
		@Override
		public Object mapBean(ResultSet re) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void bindBean(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1,model.getUserName());
            pstmt.setString(2,model.getPassword());
		} 
        });
    } 
    
    public void delete(int id){
    	String sql="delete from ECG_user where userId="+id;  
        updateBySQL(sql);
    } 
    
    public User get(int id){
         String sql="select * from ECG_user where userId="+id;
         List<Object> models = queryBySQL(sql, new BeansMapper(){
			@Override
			public Object mapBean(ResultSet re) throws SQLException {
				// TODO Auto-generated method stub
				User model = new User();
				model.setUserName(re.getString("username"));
				model.setPassword(re.getString("password"));
				return model;
			}

			@Override
			public void bindBean(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
			}
         });
         if(models == null || models.isEmpty()) {
        	 return null;
         }
         else {
        	 return (User)models.get(0);
         }
    }
    
    public List<User> queryAll(){
    	List<User> users = new ArrayList<User>();
    	String sql = "select * from ECG_user";
    	List<Object> models = super.queryBySQL(sql, new BeansMapper(){
			@Override
			public Object mapBean(ResultSet re) throws SQLException {
				// TODO Auto-generated method stub
				User model = new User();
				model.setUserName(re.getString("username"));
				model.setPassword(re.getString("password"));
				return model;
			}

			@Override
			public void bindBean(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
			}
         });
    	for(Object obj:models){
    		users.add((User)obj);
    	}
    	return users;
    }
    
public User login(final String username, final String password){
		String sql = "select * from ecg_user where username=? and password=?";
		Object model = queryOneBySQL(sql, new BeansMapper(){
			@Override
			public Object mapBean(ResultSet re) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserName(re.getString("username"));
				user.setPassword(re.getString("password"));
				return user;
			}

			@Override
			public void bindBean(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1,username);
	            pstmt.setString(2,password);
			}
         });
        return (User)model;
   }
}
