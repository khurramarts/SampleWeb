package com.veriqual.rs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;





@XmlRootElement(name = "AccountList")
public class AccountList {
	
		
	List <Account> accounts;
	
	 
	
	@XmlElement(name="account")
    @XmlElementWrapper(name="accounts")
	public List<Account> getAccounts() {
	
		if (accounts == null) {
			accounts = new ArrayList<Account>();
		}	
		return this.accounts;	
	}

}