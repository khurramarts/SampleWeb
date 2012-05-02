package com.veriqual.eip;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;
import com.google.gson.Gson;
import com.veriqual.core.Account;




public class CreateRestMessageProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		 
		String json = exchange.getIn().getBody(String.class);
		Gson gson = new Gson();
		Account account = gson.fromJson(json, Account.class);
				
		String soapMessage = 
				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body><ns1:findAccountById xmlns:ns1=\"http://ws.veriqual.com/\">" +
				"<arg0>" + account.getUserid() +
				"</arg0></ns1:findAccountById></soap:Body></soap:Envelope>";		
		
		// Camel will convert string to Document object for me
		exchange.getOut().setBody(soapMessage, Document.class);
	}
	
	
}
