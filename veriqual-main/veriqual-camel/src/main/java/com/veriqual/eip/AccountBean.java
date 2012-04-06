package com.veriqual.eip;

import java.util.List;

import org.apache.camel.model.dataformat.SoapJaxbDataFormat;

import com.sun.xml.internal.ws.resources.SoapMessages;
import com.veriqual.core.Account;

public class AccountBean {
	
	public Object message(Object obj) {
		SoapJaxbDataFormat soap = new SoapJaxbDataFormat("");
		
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
