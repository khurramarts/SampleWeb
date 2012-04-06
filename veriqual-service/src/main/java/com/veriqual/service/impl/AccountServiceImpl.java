package com.veriqual.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.veriqual.core.Account;
import com.veriqual.core.AccountExample;
import com.veriqual.core.AccountExample.Criteria;
import com.veriqual.dao.mybatis.AccountMapper;
import com.veriqual.service.AccountService;

public class AccountServiceImpl implements AccountService {
	
	private AccountMapper accountMapper;

	@Override
	@Transactional(readOnly=true)
	public Account findAccountById(int accountId) {		
		return getAccountMapper().selectByPrimaryKey(accountId);
	}

	@Override
	@Transactional(readOnly=true)
	public Account findAccountByEmailAddress(String emailAddress) {		
		AccountExample accountExample = new AccountExample(); 
		Criteria criteria = accountExample.createCriteria();
		criteria.andEmailEqualTo(emailAddress);
		List<Account> accounts = getAccountMapper().selectByExample(accountExample);
		Account account = null;
		if(accounts.size() > 0) {
			account = accounts.get(0);
		}
		
		return account;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountList() {		
		AccountExample accountExample = new AccountExample(); 
		Criteria criteria = accountExample.createCriteria();
		criteria.andUseridIsNotNull();
		List<Account> accounts = getAccountMapper().selectByExample(accountExample);
		return accounts;
	}

	@Override
	@Transactional
	public void createAccount(Account account) {
		getAccountMapper().insert(account);
	}

	@Override
	@Transactional
	public void updateAccount(Account account) {
		getAccountMapper().updateByPrimaryKey(account);
		
	}

	@Override
	@Transactional
	public void deleteAccount(Account account) {
		getAccountMapper().deleteByPrimaryKey(account.getUserid());
		
	}

	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}	
	
	
	
		
	

}
