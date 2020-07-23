import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoverPathFinder {
	
	public static void main(String[] args) {
		Point furtherestPoint = new Point();
		int linecounter =0;
		Position p = new Position();
		String [] inputString;
		try {
			// Take input file from the resource folder
		      File myObj = new File("./src/main/resources/inputfile.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        //Input file line reads from here
		        
		        //parses the first line and sets the top right corner
		        if(linecounter == 0){
		        	inputString = data.split(" ");
		        	furtherestPoint.setLocation(Integer.parseInt(inputString[0]), Integer.parseInt(inputString[1]));
		        }
		        //Sets the initial position for the rover
		        else if(linecounter % 2 == 1){
		        	inputString = data.split(" ");
		        	p.setxCordinate(Integer.parseInt(inputString[0]));
		        	p.setyCordinate(Integer.parseInt(inputString[1]));
		        	p.setDirection(inputString[2]);
		        }
		        //Moves the first rover by parsing input direction commands
		        else{
		        	for(int i = 0 ;i <data.length();i++){
		        		char modifier = data.charAt(i);
		        		if(modifier != 'M'){
		        			p = changeDirection(p,Character.toString(modifier));
		        		}
		        		else{
		        			p = moveRover(p,furtherestPoint);
		        		}
		        	}
		        	System.out.println(p);
		        }
		        linecounter++;
		      }
		      System.out.println("==========");
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("File Not Found");
		      e.printStackTrace();
		    }catch(NumberFormatException  e) {
		    	System.out.println("Cant parse the String for Number");
			     e.printStackTrace();
			}
	}
//Mehtod to change direction of the rover	
	public static Position changeDirection(Position p, String shift) {
		String currentDirection = p.getDirection();
		if (shift.compareTo("L") == 0) {
			if (currentDirection.compareTo("N") == 0) {
				p.setDirection("W");
			} else if (currentDirection.compareTo("W") == 0) {
				p.setDirection("S");
			} else if (currentDirection.compareTo("S") == 0) {
				p.setDirection("E");
			} else if (currentDirection.compareTo("E") == 0) {
				p.setDirection("N");
			}
		} else {
			if (currentDirection.compareTo("W") == 0) {
				p.setDirection("N");
			} else if (currentDirection.compareTo("S") == 0) {
				p.setDirection("W");
			} else if (currentDirection.compareTo("E") == 0) {
				p.setDirection("S");
			} else if (currentDirection.compareTo("N") == 0) {
				p.setDirection("E");
			}
		}
		return p;
	}
//Method to move forward the rover
	public static Position moveRover(Position p, Point furtherestPoint) {
		if (p.getDirection().compareTo("N") == 0 && p.getyCordinate() < furtherestPoint.getY()) {
			p.setyCordinate(p.getyCordinate() + 1);
		} else if (p.getDirection().compareTo("E") == 0 && p.getxCordinate() < furtherestPoint.getX()) {
			p.setxCordinate(p.getxCordinate() + 1);
		} else if (p.getDirection().compareTo("W") == 0 && p.getxCordinate() > 0) {
			p.setxCordinate(p.getxCordinate() - 1);
		} else if (p.getDirection().compareTo("S") == 0 && p.getyCordinate() > 0) {
			p.setyCordinate(p.getyCordinate() - 1);
		} else {
			System.out.println("Cant Move the Rover for this move because " + p + "move Towards :: " + p.getDirection()
					+ " :: is out of scope!!!");
		}
		return p;
	}

}
