package org.spring.demo.springsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements Cloneable{
	@Id
	@GeneratedValue
	private String uuid;

	@Column(name = "userName")
	private String userName;


	@Column(name = "password")
	private String passwrod;


	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}


}
