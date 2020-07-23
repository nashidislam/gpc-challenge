import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class RoverPathFinderTest {

	@Test
	public void changeDirectionTest() {
		Position p = new Position (1,2,"N");
		Position resultPosition = new Position (1,2,"E");
		RoverPathFinder rover = new RoverPathFinder();
		p = rover.changeDirection(p,"R");
		assertEquals(p.getDirection(),resultPosition.getDirection());
	}
	@Test
	public void moveRoverTest() {
		Position p = new Position (1,2,"N");
		Point furtherestPoint = new Point (5,5);
		Position resultPosition = new Position (1,3,"N");
		RoverPathFinder rover = new RoverPathFinder();
		p = rover.moveRover(p,furtherestPoint);
		assertEquals(p,resultPosition);
		
	}
	
	
	@Test
	public void test() {
		
		Position p = new Position (1,2,"N");
		String directionCommands = "LMLMLMLMM";
		Point furtherestPoint = new Point (5,5);
		RoverPathFinder rover = new RoverPathFinder();
		Position resultPosition = new Position(1,3,"N");
		
		
		
		for(int i = 0 ;i <directionCommands.length();i++){
    		char modifier = directionCommands.charAt(i);
    		if(modifier != 'M'){
    			p = rover.changeDirection(p,Character.toString(modifier));
    		}
    		else{
    			p = rover.moveRover(p,furtherestPoint);
    		}
    	}
		assertEquals(resultPosition,p);
	}

}
