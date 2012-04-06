package com.veriqual.ws;


import java.util.List;

import javax.jws.WebService;

import com.veriqual.core.Account;
import com.veriqual.service.AccountService;

@WebService(endpointInterface = "com.veriqual.ws.AccountWS")
public class AccountWSImpl implements AccountWS {
	
	private AccountService accountService;	
	
	public Account findAccountByEmailAddress(String emailAddress) {	
		Account account = getAccountService().findAccountByEmailAddress(emailAddress);	
		return account;
	}
	
	@Override
	public Account findAccountById(Integer userId) {
		Account account = getAccountService().findAccountById(userId);
		return account;
	}

	@Override
	public List<Account> findAllAccounts() {
		List<Account> accounts = getAccountService().getAccountList();
		return accounts;
	}

	@Override
	public Integer createAccount(Account account) {		
		getAccountService().createAccount(account);
		return account.getUserid();
	}

	@Override
	public void deleteAccount(Account account) {
		getAccountService().deleteAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		getAccountService().updateAccount(account);
	}
	
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {	
		this.accountService = accountService;
	}

	
	

	
}
