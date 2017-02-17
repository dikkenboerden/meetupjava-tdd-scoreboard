package com.dikkenboerden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Player {
	// each player can have 10 frames
	private int turns;
	private String name;
	
	List <MyFrame> myScores = new ArrayList<MyFrame>();
	
	Player(String name) {
		this.setName(name);
		this.setTurns(0);
	}
	
	public void plays (int chance1, int chance2) {
		// tbd add a frame to the list
		this.setTurns(this.getTurns() + 1);
		// tbd if turns > 10 throw exception 
		MyTurn myTurn = new MyTurn();
		myScores.add(myTurn.play(chance1,chance2)); 
	}
	
	
	private void reCalculateScore() {
		Iterator<MyFrame> it = myScores.iterator();
		MyFrame frame;
		Map <Integer,MyFrame> bonusFrames = new HashMap<>();
		//int frameCounter = 0;
		//System.out.println("recalc");
		int bonusFrameCounter = 0;
		
		while (it.hasNext()) {
			frame = it.next();
			//frameCounter++;
			
			if (bonusFrameCounter > 0) {
				// of this current frame add pin1 and pin2 to the previous bonus frame(s)
				
				int j;
				for (j=0; j <= 2; j++) {
					if (bonusFrameCounter-j > 0) {
						//System.out.println("bonusFrameCounter-j:" + (bonusFrameCounter-j) +  ";" + frame.getPins1() + "/" + frame.getPins2());
						
						// if this is a bonus frame then leave slot2 empty
						bonusFrames.get(bonusFrameCounter-j).setBonuspins(frame.getPins1()); // pin1 and pin2 
						
						if (frame.getBonus() != "STRIKE") {
							bonusFrames.get(bonusFrameCounter-j).setBonuspins(frame.getPins2()); // pin1 and pin2 
						}
					}					
				}
			}
			
			if (frame.getBonus() == "STRIKE") {
				bonusFrames.put(++bonusFrameCounter, frame); // = frame; // add the points of the next consecutive frames to this frame
			}
		} // end while
		
//		for (Map.Entry<Integer, MyFrame> entry : bonusFrames.entrySet())
//		{
//		    System.out.println("BONUSFRAME:" + entry.getKey());
//		    entry.getValue().printScores();
//		}
	}
	
	public int getScore() {
		Iterator<MyFrame> it = myScores.iterator();
		MyFrame frame;
		int totalScore = 0;
		
		reCalculateScore();
		
		//System.out.println("----------");
		
		while (it.hasNext()) {
			frame = it.next();

			totalScore = totalScore + frame.getScore(); 
		}
		
		return totalScore;
	}

	
	public int getTurns() {
		return turns;
	}

	private void setTurns(int turns) {
		this.turns = turns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
