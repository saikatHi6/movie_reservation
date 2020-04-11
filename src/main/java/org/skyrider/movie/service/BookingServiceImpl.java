package org.skyrider.movie.service;

import java.util.List;

import org.skyrider.movie.dao.BookingDao;
import org.skyrider.movie.model.SEAT_STATUS;
import org.skyrider.movie.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	
	

	@Override
	public List<Seat> getUnreservedSeatByScreenId(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return bookingDao.getSeatStatus(theatreId, showTime, SEAT_STATUS.UN_BOOKED.ordinal());
	}

	@Override
	public List<Seat> getReservedSeatByScreenId(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return bookingDao.getSeatStatus(theatreId, showTime, SEAT_STATUS.BOOKED.ordinal());
	}

	@Override
	public List<Seat> getBookingInProgressByScreenId(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return bookingDao.getSeatStatus(theatreId, showTime, SEAT_STATUS.IN_PROGRESS.ordinal());
	}

	@Override
	public void allocateSeat(int theatreId, String city, String showTime, int row, int number) {
		// TODO Auto-generated method stub
		bookingDao.allocateSeatInProgress(theatreId, showTime, row, number, SEAT_STATUS.IN_PROGRESS.ordinal());
		bookingDao.getLockOnSeatByTheterIdShowTime(theatreId, showTime, row, number);
	}

	@Override
	public boolean bookingConfirm(int theatreId, String showTime) {
		// TODO Auto-generated method stub
		return false;
	}

}
