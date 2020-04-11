package org.skyrider.movie.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.skyrider.movie.model.SEAT_STATUS;
import org.skyrider.movie.model.Seat;
import org.skyrider.movie.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class BookingDaoImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String FETCH_SEAT_STATUS = "SELECT s.seat_id, s.number, s.row, s.seat_status,s.theater_id,t.theater_name,t.city_name,t.show_time FROM public.seat s,public.theater t where s.theater_id=? and s.show_time=? and s.seat_status=? and s.theater_id = t.theater_id and s.show_time = t.show_time ";
	
	private final static String UPDATE_SEAT_STATUS = "update public.seat set seat_status = ? where theater_id=? and show_time=? and row=? and number=?";

	
	@Override
	public void allocateSeat(int theatreId, String city, String showTime, int[][] seatPositions) {

		
		
	}

	@Override
	public Theater getTheatreById(int theatreId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theater getTheatreByCity(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Seat> getUnreservedSeatByScreenId(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> getReservedSeatByScreenId(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> getBookingInProgressByScreenId(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> getSeatStatus(int theatreId, String showTime, int status) {
		return jdbcTemplate.query(FETCH_SEAT_STATUS, new Object[] {theatreId,showTime,status}, (rs,row)->new Seat(rs.getInt(1), rs.getInt(3), rs.getInt(2), new Theater(rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)),rs.getInt(4)));

	}

	@Override
	@Transactional
	public Seat getLockOnSeatByTheterIdShowTime(int theatreId, String showTime,int row,int number) {

		Map<String, Object> properties = new HashMap<>(); 
		properties.put("javax.persistence.lock.timeout", 5000L);
		
		
		javax.persistence.Query query = em.createQuery("from Seat where theater_id = :theatreId and show_time = :showTime and row = :row and number = :number");
		em.setProperty("javax.persistence.query.timeout", 8000);
		query.setParameter("theatreId", theatreId);
		query.setParameter("showTime", showTime);
		query.setParameter("row", row);
		query.setParameter("number", number);
		//query.setHint("javax.persistence.query.timeout", 8000);
		query.setLockMode(LockModeType.PESSIMISTIC_READ);
		List<Seat> listS =  query.getResultList();
		em.find(Seat.class,listS.get(0).getSeatId(), LockModeType.PESSIMISTIC_READ);
		//em.lock(listS.get(0), LockModeType.PESSIMISTIC_READ);
		
		
		
		
		return listS.get(0);
	}

	@Override
	public int allocateSeatInProgress(int theatreId, String showTime, int row, int number,int status) {
		return jdbcTemplate.update(UPDATE_SEAT_STATUS, new Object[] {status,theatreId,showTime,row,number});
	}

}
