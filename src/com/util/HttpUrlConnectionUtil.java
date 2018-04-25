package com.util;
 
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream; 
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL; 
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
 

/**
 * <pre>
 * 功能：httpUrlConnection访问远程接口工具
 * 日期：2015年3月17日 上午11:19:21
 * </pre>
 */
public class HttpUrlConnectionUtil {
	public static Log log = LogFactory.getLog(HttpUrlConnectionUtil.class.getSimpleName());

	public static String httpRequestToString(String url,    String params ) {
		return httpRequestToString( url, params,null);
	}
    /**
     * <pre>
     * 方法体说明：向远程接口发起请求，返回字符串类型结果
     * @param url 接口地址
     * @param requestMethod 请求方式
     * @param params 传递参数     重点：参数值需要用Base64进行转码
     * @return String 返回结果
     * </pre>
     */
    public static String httpRequestToString(String url, 
           String params,Map<String,String> headers){

        String result = null;
        try {
            InputStream is = httpRequestToStream(url, params,headers);
            byte[] b = new byte[is.available()];
            is.read(b);
            result = new String(b);
        } catch (IOException e) {
            log.error("http error:"+e.getMessage());
        }
        return result;
    }
 
    /**
     * <pre>
     * 方法体说明：向远程接口发起请求，返回字节流类型结果
     * 作者：itar
     * 日期：2015年3月17日 上午11:20:25
     * @param url 接口地址
     * @param requestMethod 请求方式
     * @param params 传递参数     重点：参数值需要用Base64进行转码
     * @return InputStream 返回结果
     * </pre>
     */
    public static InputStream httpRequestToStream(String url,  
            String json,Map<String,String> headers){

        InputStream is = null;
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");  
            conn.setRequestProperty("Accept", "application/json"); 
            if(headers!=null){  
                for(String key : headers.keySet()){  
                    conn.setRequestProperty(key, headers.get(key));  
                }  
            }  
            //设置连接超时时间
            conn.setConnectTimeout(50000);  
            //设置读取返回内容超时时间
            conn.setReadTimeout(50000);
            
            //设置向HttpURLConnection对象中输出，因为post方式将请求参数放在http正文内，因此需要设置为ture，默认false
             
            conn.setDoOutput(true); 
            //设置从HttpURLConnection对象读入，默认为true
            conn.setDoInput(true);
            //设置是否使用缓存，post方式不能使用缓存 
            conn.setUseCaches(false); 
            //设置请求方式，默认为GET
            conn.setRequestMethod("POST");
            	
            //post方式需要将传递的参数输出到conn对象中
             
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(json);
            dos.flush();
            dos.close(); 

            //从HttpURLConnection对象中读取响应的消息
            //执行该语句时才正式发起请求
            is = conn.getInputStream();
        /*} catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();*/
        } catch (IOException e) {
            log.error("http error:"+e.getMessage());
        }  
        return is;
    }
 
}