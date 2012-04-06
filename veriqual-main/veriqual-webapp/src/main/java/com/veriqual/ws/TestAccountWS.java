package com.veriqual.ws;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.veriqual.core.Account;

public class TestAccountWS {
	

	//JAX-WS Proxy client
public static void main(String[] args) throws Exception {
		
		URL wsdlURL = new URL("http://localhost:8080/inventory/AccountWSImpl?wsdl");
		QName SERVICE_NAME = new QName("http://ws.veriqual.com/", "AccountWSImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		AccountWS accountWS = service.getPort(AccountWS.class);
		Account account = new Account ();
		account.setFirstname("Mukhtiar");
		account.setLastname("Ahmed");
		account.setAddr1("Office # 205 Siddique Trade Center");
		account.setAddr2("Main Boulevard Gulberg");
		account.setCity("Lahore");
		account.setCountry("Pakistan");
		account.setEmail("mukhtiar.ahmed@veriqual.com");
		account.setPhone("03002610463");
		account.setState("Punjab");
		account.setStatus("Y");
		account.setZip("3434");
		
		Integer accountId = accountWS.createAccount(account);		
		System.out.println("accountId : " + accountId);	
		
		
		account = accountWS.findAccountById(accountId);
		System.out.println("accountId : " + account.getUserid());		
		
		account = accountWS.findAccountByEmailAddress(account.getEmail());		
		System.out.println("email : " + account.getEmail());
		
		
		List<Account> accounts = accountWS.findAllAccounts();
		for(Account a : accounts) {
			System.out.println("accountId : " + a.getUserid());
			System.out.println("email : " + a.getEmail());
		}		
		
		accountWS.updateAccount(account);
		
		accountWS.deleteAccount(account);
		
	
			
		
		
		
		
	}

}
