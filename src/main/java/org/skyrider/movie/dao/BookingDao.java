package org.skyrider.movie.dao;

import java.util.List;

import org.skyrider.movie.model.Seat;
import org.skyrider.movie.model.Theater;

public interface BookingDao {

	void allocateSeat(int theatreId,String city,String showTime,int[][] seatPositions);
	Theater getTheatreById(int theatreId);
	Theater getTheatreByCity(String cityName);
	
	
	List<Seat> getUnreservedSeatByScreenId(int theatreId,String showTime);
	List<Seat> getReservedSeatByScreenId(int theatreId,String showTime);
	List<Seat> getBookingInProgressByScreenId(int theatreId,String showTime);
	List<Seat> getSeatStatus(int theatreId,String showTime,int status);
	Seat getLockOnSeatByTheterIdShowTime(int theatreId, String showTime, int row, int number);
	int allocateSeatInProgress(int theatreId, String showTime, int row, int number, int status);
	
	
}
