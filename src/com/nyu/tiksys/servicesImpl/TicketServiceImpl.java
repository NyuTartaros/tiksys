package com.nyu.tiksys.servicesImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.jws.WebService;

import com.alibaba.fastjson.JSON;
import com.nyu.tiksys.dao.TicketDao;
import com.nyu.tiksys.services.TicketService;

@WebService(endpointInterface = "com.nyu.tiksys.services.TicketService")  
public class TicketServiceImpl implements TicketService{

	TicketDao ticketDao = new TicketDao();
	
	@Override
	public boolean book(Long time, String name, String phoneNo) {
		// TODO Auto-generated method stub
		try {
			if(ticketDao.bookTicket(new Timestamp(time), name, phoneNo)) {
				ticketDao.minusOneTicket(new Timestamp(time));
				System.out.println("Booked a ticket for "+name+", tel: "+phoneNo+" at "+new Timestamp(time).toString()+".");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error when booking tickets for "+name+", tel: "+phoneNo+" at "+new Timestamp(time).toString()+".");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String query(Long date) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Quering remaining tickets in "+new Date(date).toString()+".");
			return JSON.toJSONString(ticketDao.queryRemainTickets(new Date(date)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error when quering remaining tickets.");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String queryBookedSeat(String name, String phoneNo) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Quering booked meal seats for "+name+", tel: "+phoneNo+".");
			return JSON.toJSONString(ticketDao.queryBookedSeat(name, phoneNo));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error when quering booked meal seats for "+name+", tel: "+phoneNo+".");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancelMeal(Long time, String name, String phoneNo) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Canceling meal seat on "+new Timestamp(time).toString()+" for "+name+", tel: "+phoneNo+".");
			return ticketDao.cancelMeal(new Timestamp(time), name, phoneNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error when canceling meal seat on "+new Timestamp(time).toString()+" for "+name+", tel: "+phoneNo+".");
			e.printStackTrace();
		}
		return false;
	}
	

}
