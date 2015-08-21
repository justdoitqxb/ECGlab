package com.busycoder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BeansMapper {
    public Object mapBean(ResultSet re) throws SQLException;	//将一条记录映射成bean
    public void bindBean(PreparedStatement pstmt) throws SQLException;	//将bean写入一个记录
}