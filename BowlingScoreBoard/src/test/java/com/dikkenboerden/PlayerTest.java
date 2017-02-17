package com.dikkenboerden;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

	@Test
	public void posTestPlayer10vs0() {
		Player player = new Player("posTestPlayer10vs0");
		assertNotNull(player);
		
		player.plays(10,0); // one frame two chances
		assertEquals(10,player.getScore() );
	}
	
	@Test
	public void posTestPlayer5plus2() {
		Player player = new Player("posTestPlayer5plus2");
		assertNotNull(player);
		
		player.plays(5,2); // one frame two chances
		assertEquals(7,player.getScore() );
	}
	
	@Test
	public void negTestPlayer5plus2() {
		Player player = new Player("negTestPlayer5plus2");
		assertNotNull(player);
		
		player.plays(5,2); // one frame two chances
		assertNotEquals(5,player.getScore() );
	}
	
	@Test
	public void posTestPlayer2frames1Strike() {
		Player player = new Player("posTestPlayer2frames1Strike");
		assertNotNull(player);
		
		player.plays(10,0); // first frame strike
		player.plays(3,6); // second frame 3 + 6 = 9 with bonus multiplier = 9 * 2 = 18 + 10 = 28
		assertEquals(28,player.getScore());
	}
	
	// double's pinfal
	@Test
	public void posTestPlayerDoublePinfall() {
		Player player = new Player("posTestPlayerDoublePinfall");
		assertNotNull(player);
		
		player.plays(10,0); // first frame strike
		player.plays(10,0); // second frame strike
		player.plays(9,0); // third fram 
		assertEquals(57,player.getScore());
	}
	
	@Test
	public void posTestPlayerTurkey() {
		Player player = new Player("posTestPlayerTurkey");
		assertNotNull(player);
		
		player.plays(10,0); // first frame strike
		player.plays(10,0); // second frame strike
		player.plays(10,0); // third frame strike
		player.plays(0,9); //  4th frame
		assertEquals(78,player.getScore());
	}
	
//    Frame 1, ball 1: 10 pins (strike)
//    Frame 2, ball 1: 10 pins (strike)
//    Frame 3, ball 1: 4 pins
//    Frame 3, ball 2: 2 pins
    
	@Test
	public void posTestPlayerTypical() {
		Player player = new Player("posTestPlayerTypical");
		assertNotNull(player);
		
		player.plays(10,0); // first frame strike
		player.plays(10,0); // second frame strike
		player.plays(4,2); // third frame strike
		assertEquals(46,player.getScore());
	}
	
}
