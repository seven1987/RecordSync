package com.models;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginResponse {
	private int error_code; //	错误号	String	0为成功，其他则为失败（对应状态码说明）
	private String error_message; //	错误信息	String	文字信息，UTF8
	private String token  ; //	String	加密Token
	
	public static LoginResponse parseJson(String json) {
		LoginResponse resp = new LoginResponse();
		try {
			JSONObject jobject = new JSONObject(json);
			resp.error_code = jobject.optInt("error_code");
			resp.error_message = jobject.optString("error_message");
			resp.token = jobject.optString("token");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return resp;
	}
	
	public   String toString() {
		JSONObject jobject = new JSONObject( );
		try {
			jobject.put("error_code", error_code);
			jobject.put("error_message", error_message);
			jobject.put("token", token);
			return jobject.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ""; 
	}
	
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
