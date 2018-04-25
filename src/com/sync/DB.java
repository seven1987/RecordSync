package com.sync;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
	private final String SQL_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    
	private Connection conn=null;
    
	public DB() {
		try {
			Class.forName(SQL_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
   //静态代码块（将加载驱动、连接数据库放入静态块中）
	@Deprecated
    public  void init() { 
		String host = Config.getInstance().getProperty("databaseIP");
		String dbName =  Config.getInstance().getProperty("databaseName");
		String dbUser =  Config.getInstance().getProperty("databaseUserName");
		String dbPw   =  Config.getInstance().getProperty("databaseUserPW");
		String url = "jdbc:sqlserver://"+host+";DatabaseName="+dbName;
		
		try {
	        //1.加载驱动程序
	        Class.forName(SQL_DRIVER);
	        //2.获得数据库的连接
	        conn=(Connection)DriverManager.getConnection(url,dbUser,dbPw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

    //对外提供一个方法来获取数据库连接
    public   Connection open(){
    	try {
			if(conn==null || conn.isClosed()) {
				String host = Config.getInstance().getProperty("databaseIP");
				String dbName =  Config.getInstance().getProperty("databaseName");
				String dbUser =  Config.getInstance().getProperty("databaseUserName");
				String dbPw   =  Config.getInstance().getProperty("databaseUserPW");
				String url = "jdbc:sqlserver://"+host+";DatabaseName="+dbName;
				
				conn=(Connection)DriverManager.getConnection(url,dbUser,dbPw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
        return conn;
    }
    
    public void close() {
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public  void showTables() {
    	conn = open();
    	 // 1、获取数据库所有表
        StringBuffer sbTables = new StringBuffer();
        List<String> tables = new ArrayList<String>();
        sbTables.append("-------------- 数据库中有下列的表 ----------\n");
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet rs = dbMetaData.getTables(null, null, null,new String[] { "TABLE" });
            while (rs.next()) {// ///TABLE_TYPE/REMARKS
                sbTables.append("表名：" + rs.getString("TABLE_NAME") + "\n");
                sbTables.append("表类型：" + rs.getString("TABLE_TYPE") + "\n");
                sbTables.append("表所属数据库：" + rs.getString("TABLE_CAT") + "\n");
                sbTables.append("表所属用户名：" + rs.getString("TABLE_SCHEM")+ "\n");
                sbTables.append("表备注：" + rs.getString("REMARKS") + "\n");
                sbTables.append("------------------------------\n");
                tables.add(sbTables.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println(tables.toString());
    }
}
