package com.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author zhangw
 *
 */
public class CarCome {
	public static String tableName = "dbo.MYCARCOMERECORD";
	 
	private long ID ;             //;             // bigint NOT NULL IDENTITY(1,1) ,
	private String CardNO;             // varchar(30) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	private String CPH;             // varchar(20) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String CardType;             // varchar(20) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private Date   InTime;             // datetime NULL ,
	private Date OutTime;             // datetime NULL ,
	private String InGateName;             // varchar(100) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String OutGateName;             // varchar(100) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String InOperatorCard;             // varchar(30) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String OutOperatorCard;             // varchar(30) COLLATE Chinese_PRC_CI_AS NULL ,
	private String InOperator;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String OutOperator;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
	private String InPic;             // varchar(255) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String InUser;             // varchar(255) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String OutPic;             // varchar(255) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String OutUser;             // varchar(255) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String ZJPic;             // varchar(255) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private BigDecimal SFJE;             // money NULL DEFAULT ((0)) ,
	private BigDecimal Balance;             // money NULL DEFAULT ((0)) ,
	private BigDecimal YSJE;             // money NULL DEFAULT ((0)) ,
	private Date SFTime;             // datetime NULL ,
	private String SFOperator;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String SFOperatorCard;             // varchar(30) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String SFGate;             // varchar(100) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String OvertimeSymbol;             // varchar(10) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private Date OvertimeSFTime;             // datetime NULL ,
	private String BigDecimal;             // money NULL DEFAULT ((0)) ,
	private int CarparkNO;             // int NULL DEFAULT ((0)) ,
	private int BigSmall;             // int NULL DEFAULT ((0)) ,
	private String FreeReason;             // varchar(100) COLLATE Chinese_PRC_CI_AS NULL DEFAULT '' ,
	private String StayTime;             // varchar(30) COLLATE Chinese_PRC_CI_AS NULL ,
	private String Temp1;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
	private String Temp2;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
	private String Temp3;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
	private String Temp4;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
	private String Temp5;             // varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,
	private boolean bMorePaingCar;             // bit NULL DEFAULT ((0)) ,
	private boolean bDZ;             // bit NULL DEFAULT ((0)) ,
	private String strDZ;             // varchar(500) COLLATE Chinese_PRC_CI_AS NULL 
	public static String getTableName() {
		return tableName;
	}
	public static void setTableName(String tableName) {
		CarCome.tableName = tableName;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getCardNO() {
		return CardNO;
	}
	public void setCardNO(String cardNO) {
		CardNO = cardNO;
	}
	public String getCPH() {
		return CPH;
	}
	public void setCPH(String cPH) {
		CPH = cPH;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public Date getInTime() {
		return InTime;
	}
	public void setInTime(Date inTime) {
		InTime = inTime;
	}
	public Date getOutTime() {
		return OutTime;
	}
	public void setOutTime(Date outTime) {
		OutTime = outTime;
	}
	public String getInGateName() {
		return InGateName;
	}
	public void setInGateName(String inGateName) {
		InGateName = inGateName;
	}
	public String getOutGateName() {
		return OutGateName;
	}
	public void setOutGateName(String outGateName) {
		OutGateName = outGateName;
	}
	public String getInOperatorCard() {
		return InOperatorCard;
	}
	public void setInOperatorCard(String inOperatorCard) {
		InOperatorCard = inOperatorCard;
	}
	public String getOutOperatorCard() {
		return OutOperatorCard;
	}
	public void setOutOperatorCard(String outOperatorCard) {
		OutOperatorCard = outOperatorCard;
	}
	public String getInOperator() {
		return InOperator;
	}
	public void setInOperator(String inOperator) {
		InOperator = inOperator;
	}
	public String getOutOperator() {
		return OutOperator;
	}
	public void setOutOperator(String outOperator) {
		OutOperator = outOperator;
	}
	public String getInPic() {
		return InPic;
	}
	public void setInPic(String inPic) {
		InPic = inPic;
	}
	public String getInUser() {
		return InUser;
	}
	public void setInUser(String inUser) {
		InUser = inUser;
	}
	public String getOutPic() {
		return OutPic;
	}
	public void setOutPic(String outPic) {
		OutPic = outPic;
	}
	public String getOutUser() {
		return OutUser;
	}
	public void setOutUser(String outUser) {
		OutUser = outUser;
	}
	public String getZJPic() {
		return ZJPic;
	}
	public void setZJPic(String zJPic) {
		ZJPic = zJPic;
	}
	public BigDecimal getSFJE() {
		return SFJE;
	}
	public void setSFJE(BigDecimal sFJE) {
		SFJE = sFJE;
	}
	public BigDecimal getBalance() {
		return Balance;
	}
	public void setBalance(BigDecimal balance) {
		Balance = balance;
	}
	public BigDecimal getYSJE() {
		return YSJE;
	}
	public void setYSJE(BigDecimal ySJE) {
		YSJE = ySJE;
	}
	public Date getSFTime() {
		return SFTime;
	}
	public void setSFTime(Date sFTime) {
		SFTime = sFTime;
	}
	public String getSFOperator() {
		return SFOperator;
	}
	public void setSFOperator(String sFOperator) {
		SFOperator = sFOperator;
	}
	public String getSFOperatorCard() {
		return SFOperatorCard;
	}
	public void setSFOperatorCard(String sFOperatorCard) {
		SFOperatorCard = sFOperatorCard;
	}
	public String getSFGate() {
		return SFGate;
	}
	public void setSFGate(String sFGate) {
		SFGate = sFGate;
	}
	public String getOvertimeSymbol() {
		return OvertimeSymbol;
	}
	public void setOvertimeSymbol(String overtimeSymbol) {
		OvertimeSymbol = overtimeSymbol;
	}
	public Date getOvertimeSFTime() {
		return OvertimeSFTime;
	}
	public void setOvertimeSFTime(Date overtimeSFTime) {
		OvertimeSFTime = overtimeSFTime;
	}
	public String getBigDecimal() {
		return BigDecimal;
	}
	public void setBigDecimal(String bigDecimal) {
		BigDecimal = bigDecimal;
	}
	public int getCarparkNO() {
		return CarparkNO;
	}
	public void setCarparkNO(int carparkNO) {
		CarparkNO = carparkNO;
	}
	public int getBigSmall() {
		return BigSmall;
	}
	public void setBigSmall(int bigSmall) {
		BigSmall = bigSmall;
	}
	public String getFreeReason() {
		return FreeReason;
	}
	public void setFreeReason(String freeReason) {
		FreeReason = freeReason;
	}
	public String getStayTime() {
		return StayTime;
	}
	public void setStayTime(String stayTime) {
		StayTime = stayTime;
	}
	public String getTemp1() {
		return Temp1;
	}
	public void setTemp1(String temp1) {
		Temp1 = temp1;
	}
	public String getTemp2() {
		return Temp2;
	}
	public void setTemp2(String temp2) {
		Temp2 = temp2;
	}
	public String getTemp3() {
		return Temp3;
	}
	public void setTemp3(String temp3) {
		Temp3 = temp3;
	}
	public String getTemp4() {
		return Temp4;
	}
	public void setTemp4(String temp4) {
		Temp4 = temp4;
	}
	public String getTemp5() {
		return Temp5;
	}
	public void setTemp5(String temp5) {
		Temp5 = temp5;
	}
	public boolean isbMorePaingCar() {
		return bMorePaingCar;
	}
	public void setbMorePaingCar(boolean bMorePaingCar) {
		this.bMorePaingCar = bMorePaingCar;
	}
	public boolean isbDZ() {
		return bDZ;
	}
	public void setbDZ(boolean bDZ) {
		this.bDZ = bDZ;
	}
	public String getStrDZ() {
		return strDZ;
	}
	public void setStrDZ(String strDZ) {
		this.strDZ = strDZ;
	}
			 
	
}
