package com.dikkenboerden;

public class MyFrame {
	
	private Slot slot1;
	private Slot slot2;
	private Slot slot3;
		
	private String bonus;
	
	MyFrame () {
		this.setBonus("NONE");
		this.slot1 = new Slot();
		this.slot2 = new Slot();
		this.slot3 = new Slot();
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	
	public int getScore() {
		return getPins1() + getPins2() + getBonuspins();
	}

	public void setPins1(int pins1) {
		slot1.setScore(pins1);
	}

	public void setPins2(int pins2) {
		this.slot2.setScore(pins2);
	}
	
	public void setBonuspins(int bonuspins) {
		if (this.slot2.getState() == "EMPTY") {
			this.slot2.setScore(bonuspins);
		} else {
			this.slot3.setScore(bonuspins);
		}
	}
	
	public int getPins1() {
		return this.slot1.getScore();
	}
	
	public int getPins2() {
		return this.slot2.getScore();
	}

	public int getBonuspins() {
		return this.slot3.getScore();
	}
	
	public void printScores() {
		System.out.println("(" + getPins1()+ "," + getPins2() + "," + getBonuspins() + ") = " + (getPins1() + getPins2() + getBonuspins()));
	}
}
