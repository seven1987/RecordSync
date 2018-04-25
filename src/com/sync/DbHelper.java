package com.sync;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.VehicleAccessRecord;

public class DbHelper {
	
	public static int getMaxNum() {
		String s = Config.getInstance().getProperty("checkMaxNum");
		int ret = 50;
		if(s!=null) { 
			try {
				ret = Integer.valueOf(s);
			}catch(Exception e) {
				ret = 50;
			}
		}
		return ret;
	}
	
	public static int updateInRecord(DB db, VehicleAccessRecord record, int status ) {
		int ret = 0;
    	Connection conn = db.open(); 
		try { 
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ret =  stmt.executeUpdate("update dbo.MYCARCOMERECORD set status="+status+" where ID= "+record.getID());  
			 
			stmt.close();
		} catch (SQLException e) {
			ret = -1;
			e.printStackTrace();
		}finally {
			db.close();
		}
		return ret; 
	}

	public static int updateOutRecord(DB db, VehicleAccessRecord record, int status ) {
		int ret = 0;
    	Connection conn = db.open(); 
		try { 
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ret =  stmt.executeUpdate("update dbo.MYCARGOOUTRECORD set status="+status+" where ID= "+record.getID());  
			 
			stmt.close();
		} catch (SQLException e) {
			ret = -1;
			e.printStackTrace();
		}finally {
			db.close();
		}
		return ret; 
	}
	
    public static List<VehicleAccessRecord> getInRecord(DB db){
    	List<VehicleAccessRecord> list = new ArrayList<VehicleAccessRecord>();
    	 
    	Connection conn = db.open(); 
		try { 
			String sql = "select top "+getMaxNum()+"  ID,CPH,InTime from dbo.MYCARCOMERECORD  where status is null  or status=0 order by ID desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();
	    	 
	    	while(rs.next()) 
	    	{
	    		VehicleAccessRecord record =  new VehicleAccessRecord();
	    		record.setID(rs.getLong(1));
	    		record.setTYPE(0);
	    		record.setCLHP(rs.getString(2));
	    		record.setSJ(rs.getDate(3)); 
	    		list.add(record);
	    	}
	    	
	    	rs.close();
	    	ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
    	
		return list;
    }
    public static List<VehicleAccessRecord> getOutRecord(DB db){
    	List<VehicleAccessRecord> list = new ArrayList<VehicleAccessRecord>();
    	 
    	Connection conn = db.open(); 
		try { 
			String sql = "select top "+getMaxNum()+ " ID,CPH,OutTime from dbo.MYCARGOOUTRECORD  where status is null  or status=0 order by ID desc ";
			PreparedStatement ps = conn.prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();
	    	 
	    	while(rs.next()) 
	    	{
	    		VehicleAccessRecord record =  new VehicleAccessRecord();
	    		record.setID(rs.getLong(1));
	    		record.setTYPE(1);
	    		record.setCLHP(rs.getString(2));
	    		record.setSJ(rs.getDate(3)); 
	    		list.add(record);
	    	}
	    	
	    	rs.close();
	    	ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
    	
		return list;
    }
}
