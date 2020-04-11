package org.skyrider.movie.model;

import java.io.Serializable;

public class TheaterPK implements Serializable{
	
	protected int theaterId;
	protected String showTime;
	
	
	
	public TheaterPK() {
	}



	public TheaterPK(int theaterId, String showTime) {
		this.theaterId = theaterId;
		this.showTime = showTime;
	}
	
	

}
