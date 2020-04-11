package org.skyrider.movie.controller;

import java.util.Arrays;
import java.util.List;

import org.skyrider.movie.model.Seat;
import org.skyrider.movie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/movie/booking")
	public ResponseEntity<?>  seatBooking(@RequestBody Seat seat){
		
		bookingService.allocateSeat(seat.getTheater().getTheaterId(), seat.getTheater().getCityName(), seat.getTheater().getShowTime(),seat.getRow(),seat.getNumber() );
		
		Seat[] seats = new Seat[4];
		Arrays.sort(seats,(a,b)->a.getRow()-b.getRow());	

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/movie/booking/confirm")
	public ResponseEntity<List<Seat>> bookingConfirm(@RequestParam("theatreId") int theatreId,@RequestParam("showTime") String showTime){
		List<Seat> listSeat = bookingService.getUnreservedSeatByScreenId(theatreId, showTime);

		return new ResponseEntity<List<Seat>>(listSeat, HttpStatus.OK);
	}

	
	
	@GetMapping("/movie/booking/unreserved")
	public ResponseEntity<List<Seat>> getUnreservedSeat(@RequestParam(value = "theatreId") int theatreId,@RequestParam(value = "showTime") String showTime){
		List<Seat> listSeat = bookingService.getUnreservedSeatByScreenId(theatreId, showTime);

		return new ResponseEntity<List<Seat>>(listSeat, HttpStatus.OK);
	}

	@GetMapping("/movie/booking/reserved")
	public ResponseEntity<List<Seat>> getReservedSeat(@RequestParam("theatreId") int theatreId,@RequestParam("showTime") String showTime){
		List<Seat> listSeat = bookingService.getReservedSeatByScreenId(theatreId, showTime);

		return new ResponseEntity<List<Seat>>(listSeat, HttpStatus.OK);

	}

	@GetMapping("/movie/booking/inprogress")
	public ResponseEntity<List<Seat>> getInprogreSeat(@RequestParam("theatreId") int theatreId,@RequestParam("showTime") String showTime){

		List<Seat> listSeat = bookingService.getBookingInProgressByScreenId(theatreId, showTime);

		return new ResponseEntity<List<Seat>>(listSeat, HttpStatus.OK);
	}




}
