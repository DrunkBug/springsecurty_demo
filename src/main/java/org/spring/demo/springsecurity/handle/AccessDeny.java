package org.spring.demo.springsecurity.handle;

import org.spring.demo.springsecurity.rest.ResponseResult;
import org.spring.demo.springsecurity.rest.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//无权访问
@Component
public class AccessDeny implements AccessDeniedHandler {
	@Autowired
	Gson gson;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
			throws IOException, ServletException {
		ResponseResult<Object> result = new ResponseResult<Object>().setCode(ResultCode.UNAUTHORIZED).setMsg("权限不足");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(gson.toJson(result));
	}
}
