package com.nyu.tiksys.main;

import javax.xml.ws.Endpoint;

import com.nyu.tiksys.servicesImpl.TicketServiceImpl;

public class Tiksys {

	private final static String ADDRESS = "http://172.18.215.131:8899/tiksys/webservice";  
	//private final static String ADDRESS = "http://localhost:8899/tiksys/webservice";  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //IWebService service = new WebServiceImpl();  
	    //Endpoint.publish(ADDRESS, service);  
	    Endpoint.publish(ADDRESS, new TicketServiceImpl());  

	}

}
