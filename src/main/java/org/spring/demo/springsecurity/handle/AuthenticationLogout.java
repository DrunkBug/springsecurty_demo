package org.spring.demo.springsecurity.handle;

import com.google.gson.Gson;

import org.spring.demo.springsecurity.rest.ResponseResult;
import org.spring.demo.springsecurity.rest.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationLogout implements LogoutSuccessHandler {
	@Autowired
	Gson gson;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		ResponseResult<Object> result = new ResponseResult<Object>().setCode(ResultCode.LOGOUT_SUCCESS);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(gson.toJson(result));
	}
}
