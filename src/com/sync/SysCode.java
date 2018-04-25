package com.sync;

public class SysCode {
	public static final int OK = 0		;//成功
	public static final int VISITOR_NAME_EMPTY = -1	;//进出者姓名为空
	public static final int VISITOR_ID_EMPTY = -2	;//进出者身份证号为空
	public static final int VISITOR_TYPE_ERROR = -3	;//进出人员类型错误
	public static final int TIME_EMPTY = -4	;//进出时间为空
	public static final int CAR_TAG_ERROR = -5	;//车辆进出标记错误
	public static final int PARK_NAME_EMPTY = -6	;//停车场名为空
	public static final int CAR_BRAND_EMPTY = -7	;//车辆号牌为空
	public static final int SAVE_FAILED = -999	;//保存失败
	public static final int NO_TOKEN = -401	;//未获取到TOKEN
	public static final int TOKEN_EXPIRED = -402	;//TOKEN过期
	public static final int NAME_OR_PWD_EMPTY = -404	;//用户名或密码为空
}
