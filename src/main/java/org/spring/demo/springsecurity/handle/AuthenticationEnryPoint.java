package org.spring.demo.springsecurity.handle;

import com.google.gson.Gson;

import org.spring.demo.springsecurity.rest.ResponseResult;
import org.spring.demo.springsecurity.rest.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEnryPoint implements AuthenticationEntryPoint {

	@Autowired
	Gson gson;

	// 未登录时返回给前端数据
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {
		ResponseResult<Object> result = new ResponseResult<Object>().setCode(ResultCode.UNAUTHORIZED);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(gson.toJson(result));
	}
}
