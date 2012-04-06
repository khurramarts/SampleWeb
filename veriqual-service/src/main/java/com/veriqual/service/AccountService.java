package com.veriqual.service;

import java.util.List;

import com.veriqual.core.Account;

public interface AccountService {
	
	public Account findAccountById(int AccountId);

	public Account findAccountByEmailAddress(String emailAddress);

	public void createAccount(Account Account);

	public void updateAccount(Account Account);

	public void deleteAccount(Account Account);	
		
	public List<Account> getAccountList();
	
	

}
