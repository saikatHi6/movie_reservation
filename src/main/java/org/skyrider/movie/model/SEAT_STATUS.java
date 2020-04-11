package org.skyrider.movie.model;

public enum SEAT_STATUS {
	UN_BOOKED(0),IN_PROGRESS(1),BOOKED(2);
	
	int stat;

	private SEAT_STATUS(int stat) {
		this.stat = stat;
	}
	
	
	
	
}
