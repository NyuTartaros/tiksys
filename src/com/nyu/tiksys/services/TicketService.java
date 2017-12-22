package com.nyu.tiksys.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService  
@SOAPBinding(style = SOAPBinding.Style.RPC)  
public interface TicketService {
	
	@WebMethod
	public boolean book(@WebParam(name="time") Long time, 
			@WebParam(name="name") String name, 
			@WebParam(name="phoneNo") String phoneNo);
	
	@WebMethod
	public String query(@WebParam(name="date") Long date);
	
	@WebMethod
	public String queryBookedSeat(@WebParam(name="name") String name, 
			@WebParam(name="phoneNo") String phoneNo);
	
	@WebMethod
	public boolean cancelMeal(@WebParam(name="time") Long time, 
			@WebParam(name="name") String name, 
			@WebParam(name="phoneNo") String phoneNo);
	
}
