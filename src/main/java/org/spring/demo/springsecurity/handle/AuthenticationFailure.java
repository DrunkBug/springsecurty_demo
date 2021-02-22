package org.spring.demo.springsecurity.handle;

import com.google.gson.Gson;

import org.spring.demo.springsecurity.rest.ResponseResult;
import org.spring.demo.springsecurity.rest.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录失败返回给前端消息
@Component
public class AuthenticationFailure implements AuthenticationFailureHandler {
	@Autowired
	Gson gson;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
		ResponseResult<Object> result = null;
		if (e instanceof UsernameNotFoundException) {
			result = new ResponseResult<Object>().setCode(ResultCode.FAIL).setMsg("用户名错误");
		} else if (e instanceof BadCredentialsException) {
			result = new ResponseResult<Object>().setCode(ResultCode.FAIL).setMsg("密码错误");
		} else {
			result = new ResponseResult<Object>().setCode(ResultCode.FAIL).setMsg(e.getMessage());
		}
		// 处理编码方式，防止中文乱码的情况
		response.setContentType("text/json;charset=utf-8");
		// 返回给前台
		response.getWriter().write(gson.toJson(result));
	}
}
