package com.sync;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.models.LoginResponse;
import com.models.BaseResponse;
import com.models.VehicleAccessRecord;
import com.util.HttpUrlConnectionUtil;

public class CloudPlatformApi {
	public static Log log = LogFactory.getLog(CloudPlatformApi.class.getSimpleName());
	public static String URL_LOGIN = "/ccp/login";
	public static  String URL_SAVE_VEHICLE_ACCESS_RECORD = "/ccp/saveVehicleAccessRecord";
	
	public static String getHost() {
		return Config.getInstance().getProperty("cloudHost");
	}
	
	public static LoginResponse login(String username,String password) throws JSONException {	 
		String url = getHost()+URL_LOGIN; 
		JSONObject object = new JSONObject(); 
		object.put("username", username);
		object.put("password", password); 

    	log.info("login username:"+username+"password:"+password);
    	log.trace("login username:"+username+"password:"+password);
    	
		String resp = HttpUrlConnectionUtil.httpRequestToString(url, object.toString()); 
		LoginResponse loginResp = LoginResponse.parseJson(resp);

		if(loginResp.getError_code()!=SysCode.OK) {
			log.error(loginResp.toString());
		}
		return loginResp;
	}
	
	public static BaseResponse save(String token,VehicleAccessRecord record) { 
		Map<String,String> headers  = new HashMap<String,String>(); 

    	log.info("send info"+record.toString());
		String url = getHost()+URL_SAVE_VEHICLE_ACCESS_RECORD;
		headers.put("auth-token", token);
		
		String resp = HttpUrlConnectionUtil.httpRequestToString(url, record.toString(),headers);
		
		BaseResponse baseResp = BaseResponse.parseJson(resp);
		
		if(baseResp.getError_code()!=SysCode.OK) {
			log.error(baseResp.toString());
		}
		return baseResp;
	}
}
