package com.veriqual.rs;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;







@Path("/account")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class AccountRSImpl implements AccountRS {
	
	@Override
	@GET
    @Path("/{id}")
	public Account findAccountById(@PathParam("id") Integer userId) {
		Account account = new Account();	
		account.setUserid(userId);	
		return account;
	}	
}
