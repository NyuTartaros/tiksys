package com.nyu.tiksys.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

//import com.sina.sae.util.SaeUserInfo;
 
public class DbHelper {
    private static DataSource dataSource;
    private static Connection connection;
    private DbHelper(){
    }
     
    public static QueryRunner getQueryRunner(){
        if(DbHelper.dataSource==null){
            //≈‰÷√dbcp ˝æ›‘¥
            BasicDataSource dbcpDataSource = new BasicDataSource();
            dbcpDataSource.setUrl("jdbc:mysql://localhost:3306/tiksys");
            dbcpDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dbcpDataSource.setUsername("tiksys");
            dbcpDataSource.setPassword("mycodeis...82465");
            dbcpDataSource.setDefaultAutoCommit(true);
            dbcpDataSource.setMaxActive(100);
            dbcpDataSource.setMaxIdle(30);
            dbcpDataSource.setMaxWait(500);
            
            DbHelper.dataSource = (DataSource)dbcpDataSource;
        }
        return new QueryRunner(DbHelper.dataSource);
    }
    
    public static Connection getConnection(){
    	try {
			connection =  dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return connection;
    }
}