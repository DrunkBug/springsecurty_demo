package org.spring.demo.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.spring.demo.springsecurity.dao.UserJpa;
import org.spring.demo.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService{
	@Autowired
	private UserJpa userJpa;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userJpa.getOneByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("用户名错误！");
		}

		// 获取用户权限，并把其添加到GrantedAuthority中
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		grantedAuthorities.add(grantedAuthority);

		// 方法的返回值要求返回UserDetails这个数据类型， UserDetails是接口，找它的实现类就好了
		// new org.springframework.security.core.userdetails.User(String username,String
		// password,Collection<? extends GrantedAuthority> authorities) 就是它的实现类
		return new org.springframework.security.core.userdetails.User(userName, user.getPasswrod(), grantedAuthorities);
	}

}
