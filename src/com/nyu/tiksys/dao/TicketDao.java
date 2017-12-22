package com.nyu.tiksys.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nyu.tiksys.entity.BookedSeatRecord;
import com.nyu.tiksys.entity.RemainTicketRecord;
import com.nyu.tiksys.util.DbHelper;

public class TicketDao {
	// Create a QueryRunner that will use connections from the given DataSource
	private QueryRunner runner = DbHelper.getQueryRunner();
	
	public ArrayList<RemainTicketRecord> queryRemainTickets(Date date) throws SQLException{
		String sql = "select * from train where time>?";
		Timestamp timestamp = new Timestamp(date.getTime());
		return (ArrayList<RemainTicketRecord>) runner.query(sql, new BeanListHandler<RemainTicketRecord>(RemainTicketRecord.class), timestamp);
	}
	
	public boolean bookTicket(Timestamp time, String name, String phoneNo) throws SQLException {
		String sql = "insert into ticketRecord values(?,?,?,TRUE)";
		if(runner.update(sql, time, name, phoneNo) > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean minusOneTicket(Timestamp time) {
		String sql ="update train set remainTicketNum = remainTicketNum-1 where time=?";
		try {
			runner.update(sql,time);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<BookedSeatRecord> queryBookedSeat(String name, String phoneNo) throws SQLException{
		String sql = "select * from ticketRecord where name=? and phoneNo=?";
		return (ArrayList<BookedSeatRecord>) runner.query(sql, new BeanListHandler<BookedSeatRecord>(BookedSeatRecord.class),
				name, phoneNo);
	}
	
	public boolean cancelMeal(Timestamp time, String name, String phoneNo) throws SQLException{
		String sql = "update ticketRecord set haveMeal=FALSE where time=? and name=? and phoneNo=?";
		if( runner.update(sql, time, name, phoneNo) > 0) {
			return true;
		}else{
			return false;
		}
	}
}
