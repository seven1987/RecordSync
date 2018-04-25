package com.models;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseResponse {
	private int error_code; //	�����	String	0Ϊ�ɹ���������Ϊʧ�ܣ���Ӧ״̬��˵����
	private String error_message; //	������Ϣ	String	������Ϣ��UTF8 
	
	public static BaseResponse parseJson(String json) {
		BaseResponse resp = new BaseResponse();
		try {
			JSONObject jobject = new JSONObject(json);
			resp.error_code = jobject.optInt("error_code");
			resp.error_message = jobject.optString("error_message"); 
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
	
}
