package com.dikkenboerden;

public class Slot {
	private int score;
	private String state;
	
	Slot() {
		this.setState("EMPTY");
	}

	public int getScore() {
		int retVal;
		
		retVal = this.score;
		if (this.state == "EMPTY") {
			retVal = 0;
		} 
		return retVal;
	}

	public void setScore(int score) {
		if (this.state == "EMPTY") {
			this.score = score;
			setState("OCCUPIED");
		}
	}

	public String getState() {

		return state;
	}

	private void setState(String state) {
		this.state = state;
	}

}
