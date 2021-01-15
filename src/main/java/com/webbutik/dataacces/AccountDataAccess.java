package com.webbutik.dataacces;

import java.util.List;

import com.webbutik.domain.Account;


public interface AccountDataAccess {

	public void insert(Account account);
	public void delete(int id);
	public Account find(int id);
	public List<Account> findByName(String name);
	public List<Account> findAll();
	public void updateEmail(String email);
	public void updatePassword(String password);
}
