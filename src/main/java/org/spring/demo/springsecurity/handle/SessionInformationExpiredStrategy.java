package org.spring.demo.springsecurity.handle;

import com.google.gson.Gson;

import org.spring.demo.springsecurity.rest.ResponseResult;
import org.spring.demo.springsecurity.rest.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//异地登录、账号下线
@Component
public class SessionInformationExpiredStrategy
		implements org.springframework.security.web.session.SessionInformationExpiredStrategy {
	@Autowired
	Gson gson;

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		ResponseResult<Object> result = new ResponseResult<Object>().setCode(ResultCode.NOT_LOCAL_LOGIN);
		HttpServletResponse response = event.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(gson.toJson(result));
	}
}
