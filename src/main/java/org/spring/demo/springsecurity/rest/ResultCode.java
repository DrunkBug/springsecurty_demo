package org.spring.demo.springsecurity.rest;

public enum ResultCode {
	// 成功
	SUCCESS(200, "登录成功"),

	// 失败
	FAIL(400, "登录失败"),

	// 未认证（签名错误）
	UNAUTHORIZED(401, "认证失败"),

	// 接口不存在
	NOT_FOUND(404, "接口不存在"),

	// 服务器内部错误
	INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

	// 注销成功
	LOGOUT_SUCCESS(201, "注销成功"),

	// 异地登录
	NOT_LOCAL_LOGIN(221, "异地登录");

	public int code;
	public String msg;

	ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
