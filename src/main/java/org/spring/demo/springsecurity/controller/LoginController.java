package org.spring.demo.springsecurity.controller;

import org.spring.demo.springsecurity.rest.ResponseResult;
import org.spring.demo.springsecurity.rest.ResultCode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	/**
	 * 登录失败返回 401 以及提示信息.
	 *
	 * @return the rest
	 */
	@PostMapping("/failure")
	public ResponseResult<Object> loginFailure() {
		return new ResponseResult<Object>().setCode(ResultCode.FAIL).setMsg("登录失败");
	}

	/**
	 * 登录成功后拿到个人信息.
	 *
	 * @return the rest-
	 */
	@PostMapping("/success")
	public ResponseResult<Object> loginSuccess() {
		// 登录成功后用户的认证信息 UserDetails会存在 安全上下文寄存器 SecurityContextHolder 中
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.getUsername();
		// 脱敏
		return new ResponseResult<Object>().setCode(ResultCode.SUCCESS).setMsg("登录成功").setData(username);
	}
}
