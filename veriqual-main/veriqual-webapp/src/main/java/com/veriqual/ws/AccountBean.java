package com.veriqual.ws;

import java.util.List;

import com.veriqual.core.Account;

public class AccountBean {
	
	public Object message(Object obj) {
		if(obj.getClass() == Integer.class) {
			System.out.println(((Integer)obj).intValue());
		} else if(obj.getClass() == Account.class) {
			Account account = (Account) obj;
			System.out.println("Id : " + account.getUserid());
			System.out.println("Email : " + account.getEmail());
			
		} else if(obj instanceof List) {
			@SuppressWarnings("unchecked")
			List <Account> list = (List<Account>) obj;
			for(Account account : list) {
				System.out.println("Id : " + account.getUserid());
				System.out.println("Email : " + account.getEmail());
			}
			
		} else {
			System.out.println(obj.getClass());
		}
		
		
		return obj;
	}

}
