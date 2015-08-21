package com.busycoder.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BeansMapper {
    public Object mapBean(ResultSet re) throws SQLException;	//��һ����¼ӳ���bean
    public void bindBean(PreparedStatement pstmt) throws SQLException;	//��beanд��һ����¼
}