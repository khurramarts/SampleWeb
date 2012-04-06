package com.veriqual.ws;

import java.util.List;

import javax.jws.WebService;

import com.veriqual.core.Account;

@WebService
public interface AccountWS {	
	
	public Account findAccountByEmailAddress(String emailAddress);
	
	public Account findAccountById(Integer userId);
	
	public List<Account> findAllAccounts();
	
	public Integer createAccount(Account account);
	
	public void deleteAccount(Account account);
	
	public void updateAccount(Account account);
	
	

}
