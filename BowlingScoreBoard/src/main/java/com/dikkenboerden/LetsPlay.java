package com.dikkenboerden;

import java.util.Random;

public class LetsPlay {

    public static void main( String[] args )
    {        
        // start game with 2 players
		Player tom = new Player("TOM");
		Player jean = new Player("JEAN");
		
		int i;
        // for up to 10 frames
		for (i=0;i < 10; i++) {
	        // generate random numbers 
			tom.plays(randInt(1,10),randInt(1,10)); // one frame two chances
			jean.plays(randInt(1,10),randInt(1,10)); // one frame two chances
		}
		
		// print finalscore 
		
		System.out.println(tom.getName() + ":" + tom.getScore());
		System.out.println(jean.getName() + ":" + jean.getScore());
    }

	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimim value
	 * @param max Maximim value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {
	
	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();
	
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	
	    return randomNum;
	}
    
}
