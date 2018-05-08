package com.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.sync.Config;

public class VehicleAccessRecord {
	public long ID;
	public int TYPE	;//�������	INTEGER	4	����	0:���� 1:����
	public Date SJ	;//����ʱ��	DateTime		����	����ʱ�� YYYY-MM-dd HH:mm:ss UTC+08:00
	public String TCCM	;//ͣ������	String	128	����	
	public String CLHP	;//��������	String	10	����	
	public String XZQH	;//��������	String	24	����	��������
	public String SSFXSJDM	;//�������������оִ���	String	12	����	Excel���ձ��ѯ
	public String SSFXSJMC	;//�������������о�����	String	120	����	Excel���ձ��ѯ
	public String SSPCSDM	;//���������ɳ�������	String	12	����	Excel���ձ��ѯ
	public String SSPCSMC	;//���������ɳ�������	String	120	����	Excel���ձ��ѯ
	public String ZP	;//��Ƭ��Ϣ	String	2MB		Jpg��ʽ��ʹ��base64ת�봫��
	
	public VehicleAccessRecord() { 
        TCCM		= Config.getInstance().getProperty("TCCM");// ����������
        XZQH		= Config.getInstance().getProperty("XZQH");//�껨��
        SSFXSJDM    = Config.getInstance().getProperty("SSFXSJDM");//430111000000
        SSFXSJMC	= Config.getInstance().getProperty("SSFXSJMC");//�껨�־�
        SSPCSDM	    = Config.getInstance().getProperty("SSPCSDM");//430111610000
        SSPCSMC	    = Config.getInstance().getProperty("SSPCSMC");//�������ɳ���
	}
	
	public   String toString() {
		JSONObject jobject = new JSONObject( );
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
		try {
			jobject.put("TYPE", TYPE);
			jobject.put("SJ",  SJ==null?"":time.format(SJ)) ;
			jobject.put("TCCM", TCCM);
			jobject.put("CLHP", CLHP);
			jobject.put("XZQH", XZQH);
			jobject.put("SSFXSJDM", SSFXSJDM);
			jobject.put("SSFXSJMC", SSFXSJMC);
			jobject.put("SSPCSDM", SSPCSDM);
			jobject.put("SSPCSMC", SSPCSMC);
			jobject.put("ZP", ZP);
			return jobject.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ""; 
	}
	
	
	public long getID() {
		return ID;
	}


	public void setID(long iD) {
		ID = iD;
	}


	public int getTYPE() {
		return TYPE;
	}
	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}
	public Date getSJ() {
		return SJ;
	}
	public void setSJ(Date sJ) {
		SJ = sJ;
	}
	public String getTCCM() {
		return TCCM;
	}
	public void setTCCM(String tCCM) {
		TCCM = tCCM;
	}
	public String getCLHP() {
		return CLHP;
	}
	public void setCLHP(String cLHP) {
		CLHP = cLHP;
	}
	public String getXZQH() {
		return XZQH;
	}
	public void setXZQH(String xZQH) {
		XZQH = xZQH;
	}
	public String getSSFXSJDM() {
		return SSFXSJDM;
	}
	public void setSSFXSJDM(String sSFXSJDM) {
		SSFXSJDM = sSFXSJDM;
	}
	public String getSSFXSJMC() {
		return SSFXSJMC;
	}
	public void setSSFXSJMC(String sSFXSJMC) {
		SSFXSJMC = sSFXSJMC;
	}
	public String getSSPCSDM() {
		return SSPCSDM;
	}
	public void setSSPCSDM(String sSPCSDM) {
		SSPCSDM = sSPCSDM;
	}
	public String getSSPCSMC() {
		return SSPCSMC;
	}
	public void setSSPCSMC(String sSPCSMC) {
		SSPCSMC = sSPCSMC;
	}
	public String getZP() {
		return ZP;
	}
	public void setZP(String zP) {
		ZP = zP;
	}
	
	
}
