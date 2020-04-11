package org.skyrider.movie.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resrveId;
	
	
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name = "theaterId", insertable = false, updatable = false),
		  @JoinColumn(name = "showTime", insertable = false, updatable = false)
		})
	private Theater theater;
	
	@ManyToOne
    @JoinColumn(name="seatId", nullable=false)
	private Seat seats;

	public int getResrveId() {
		return resrveId;
	}

	public void setResrveId(int resrveId) {
		this.resrveId = resrveId;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Seat getSeats() {
		return seats;
	}

	public void setSeats(Seat seats) {
		this.seats = seats;
	}
	
	

}
