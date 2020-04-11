package org.skyrider.movie.service;

import java.util.List;

import org.skyrider.movie.model.Seat;

public interface BookingService {
	
	void allocateSeat(int theatreId,String city,String showTime,int row,int number);
	List<Seat> getUnreservedSeatByScreenId(int theatreId,String showTime);
	List<Seat> getReservedSeatByScreenId(int theatreId,String showTime);
	List<Seat> getBookingInProgressByScreenId(int theatreId,String showTime);
	boolean bookingConfirm(int theatreId,String showTime);
}
