package com.dikkenboerden;

public class MyTurn {

	private MyFrame myFrame;
	
	MyTurn() {
		this.myFrame = new MyFrame();
	}

	public MyFrame play(int firstScore, int secondScore) {
		 // first throw
		if (firstScore == 10) {
			this.myFrame.setBonus("STRIKE");
			this.myFrame.setPins1(firstScore);
			//this.myFrame.addScore(10);
			return this.myFrame; // ok STRIKE finish the game
		} 
		
		// ok score is less than 10
		//this.myFrame.addScore(firstScore);
		this.myFrame.setPins1(firstScore);
		
		// second throw if applicable
		//this.myFrame.addScore(secondScore);
		this.myFrame.setPins2(secondScore);
		if (myFrame.getScore() == 10) { // total of first and second
			this.myFrame.setBonus("SPARE");
		}
		
		return this.myFrame;
	}
	
}
