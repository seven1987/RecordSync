package com.sync;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class Config {
	public static Config sConfig=null;
	HashMap<String,String> map =new HashMap<String,String>();
	
	public static Config getInstance(){
		if(sConfig==null) {
			sConfig = new  Config();
			sConfig.init();
		}
		return sConfig;
	}
	
	private Config() {
	} 

	public String getProperty(String key) {
		return map.get(key);
	}
	
    public void init() {
    	Properties prop = new Properties();   
         try{
             //读取属性文件a.properties
        	 Properties datas = new Properties();
        	 BufferedReader   in = new BufferedReader(new InputStreamReader(new  FileInputStream(new File("config.properties")), "UTF-8"));

             //InputStream in = new BufferedInputStream (new FileInputStream("config.properties" ));
             prop.load(in);     ///加载属性列表
             Iterator<String> it=prop.stringPropertyNames().iterator();
             while(it.hasNext()){
                 String key=it.next();
                 map.put(key, prop.getProperty(key));
                 //System.out.println(key+":"+prop.getProperty(key));
             }
             in.close();
         }
         catch(Exception e){
             System.out.println(e);
         } 
    }
}
