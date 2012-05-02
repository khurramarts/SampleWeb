package com.veriqual.eip;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;


public class CreateSOAPMessageProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		 
		String xml = exchange.getIn().getBody(String.class);		
		String soapMessage = 
				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body><ns1:createAccount xmlns:ns1=\"http://ws.veriqual.com/\">" +
				"<arg0 xmlns:ns2=\"http://ws.veriqual.com/\">" + xml +
				"</arg0></ns1:createAccount></soap:Body></soap:Envelope>";		
		
		// Camel will convert string to Document object for me
		exchange.getOut().setBody(soapMessage, Document.class);
	}
	
	
}
