package com.sync;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.models.BaseResponse;
import com.models.LoginResponse;
import com.models.VehicleAccessRecord;
import com.util.HTTPSUtil;

public class Main {
	
	public static Log log = LogFactory.getLog(Main.class.getSimpleName());
	
    
    public static void main(String[] args) throws Exception{
    	DB db = new DB();  
    	log.trace("开始... ");
    	 
        String user = Config.getInstance().getProperty("admin");
        String pwd  = Config.getInstance().getProperty("adminpw");
        
        HTTPSUtil.initAccess(); 
        String token = null;
        
        while(true) {
        	if(token==null) {
                LoginResponse loginResp =  CloudPlatformApi.login(user, pwd);
                token = loginResp.getToken();
        	}
        	
        	if(token!=null) {

                List<VehicleAccessRecord>  intList = DbHelper.getInRecord(db);
                for(int i=0;i<intList.size();i++) {
                	VehicleAccessRecord record = intList.get(i);
                	BaseResponse resp = CloudPlatformApi.save(token, record);

                	int code = resp.getError_code();
                	
                	if(code == SysCode.OK){
                		DbHelper.updateInRecord(db, record, 1);
                	}else if(code==SysCode.NO_TOKEN) {
                		token = null;break;
                	}else if(code== SysCode.TOKEN_EXPIRED) {
                		token = null;break;
                	}else {
                		DbHelper.updateInRecord(db, record, 2);
                	}
                }
            	

                List<VehicleAccessRecord>  list = DbHelper.getOutRecord(db);
                for(int i=0;i<list.size();i++) {
                	VehicleAccessRecord record = list.get(i); 
                	BaseResponse resp = CloudPlatformApi.save(token, record);
                	int code = resp.getError_code();
                	
                	if(code == SysCode.OK){
                		DbHelper.updateOutRecord(db, record, 1);
                	}else if(code==SysCode.NO_TOKEN) {
                		token = null;break;
                	}else if(code== SysCode.TOKEN_EXPIRED) {
                		token = null;break;
                	}else {
                		DbHelper.updateOutRecord(db, record, 2);
                	}
                }
        	}
            
        	Thread.sleep(1000*5*60);
        }
        //log.debug(loginResp.toString());
    } 
   
}
