package com.webbutik.SpringBootWebbButik.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Represents a user's account. 
 * <p>
 * @author Erik Sandström
 * </p>
 */
@Entity
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String surname;
	private String email;
	private String password;
	private boolean accessLevel;
	
	
	public Account(String firstName, String surname, String email, String password) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.accessLevel = false;
	}
	
	public Account() {
		
	}
	
	public String toString() {
		return "Name: " + firstName + " " + surname + "   Email:" + email;
	}
}
