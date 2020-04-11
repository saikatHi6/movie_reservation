package org.skyrider.movie.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class Seat implements Serializable{
	
	
	
	
	
	
	

	public Seat(int seatId, int row, int number, Theater theater, int seatStatus) {
		this.seatId = seatId;
		this.row = row;
		this.number = number;
		this.theater = theater;
		this.seatStatus = seatStatus;
	}



	public Seat() {
		super();
	}



	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seatId;
	
	@Column
	private int row;
	
	@Column
	private int number;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "showTime", insertable = false, updatable = false),
		  @JoinColumn(name = "theaterId", insertable = false, updatable = false)
		  
		})
	private Theater theater;
	
	@OneToMany(mappedBy="seats")
	private Set<Reservation> reservation;
	
	
	@Column
	private int seatStatus; 

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	public int getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(int seatStatus) {
		this.seatStatus = seatStatus;
	}
	
	
	
	
}
