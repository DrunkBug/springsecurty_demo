package org.spring.demo.springsecurity.dao;

import org.spring.demo.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpa extends JpaRepository<User, String> {


	@Query(value = "select uuid,user_name,password from users where user_name=?1" , nativeQuery = true)
	User getOneByUserName(String Username);
}
