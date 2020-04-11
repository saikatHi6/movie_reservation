package org.skyrider.movie.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="theater")
@IdClass(TheaterPK.class)
public class Theater implements Serializable{
	
	

	public Theater(int theaterId, String theaterName, String cityName, String showTime) {
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.cityName = cityName;
		this.showTime = showTime;
	}

	
	
	public Theater() {
		super();
	}



	@Id
	private int theaterId;
	
	@Column
	private String theaterName;
	
	@Column
	private String cityName;
	
	@Column
	@Id
	private String showTime;
	
	@OneToMany(mappedBy="theater")
	private Set<Seat> seats;
	
	@OneToMany(mappedBy="theater")
	private Set<Reservation> reservation;
	

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	
	
	
}
