package com.dikkenboerden;

//import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyTurnTest {
	
	@Test
	public void posTestFirstFrame() {
		MyTurn turn1 = new MyTurn();
		MyFrame frame1;
		assertNotNull(turn1);
		
		frame1 = turn1.play(1,1);
		assertEquals(2,frame1.getScore());
	}
	
	@Test
	public void negTestFirstFrame() { // throwing in a negative test 
		// assertion on failure
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;

		frame1 = turn1.play(1,1);
		assertNotEquals(1,frame1.getScore());
	}
	
	@Test
	public void posTestFirstFrameStrike10Points() {
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;
		
		frame1 = turn1.play(10,1);
		assertEquals(10,frame1.getScore());
	}
	
	@Test
	public void posTestFirstFrameStrikeBonus() {
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;
		
		frame1 = turn1.play(10,0);
		assertEquals("STRIKE",frame1.getBonus());
	}

	@Test
	public void negTestFirstFrameStrikeBonus() {
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;
		
		frame1 = turn1.play(10,0);
		assertNotEquals("SPARE",frame1.getBonus());
	}
	
	@Test
	public void posTestFirstFrameSpare10Points() {
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;
		
		frame1 = turn1.play(2,8);
		assertEquals(10,frame1.getScore());
	}
	
	@Test
	public void posTestFirstFrameSpareBonus() {
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;
		
		frame1 = turn1.play(2,8);
		assertEquals("SPARE",frame1.getBonus());
	}
	
	@Test
	public void negTestFirstFrameSpareBonus() {
		MyTurn turn1 = new MyTurn();
		assertNotNull(turn1);
		MyFrame frame1;
		
		frame1 = turn1.play(2,8);
		assertNotEquals("STRIKE",frame1.getBonus());
	}

}
