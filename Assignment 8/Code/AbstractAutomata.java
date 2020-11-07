import java.awt.Color; 
import java.awt.Graphics;

abstract class AbstractAutomata{
	public static final int ALIVE = 1;
	public static final int DEAD = 0;
	
	abstract void randomArrayAssignment();
	
	abstract void allStatesDead(int arraySize);

	abstract int rules(int row, int column);

	abstract void playBack(int arraySize);

	abstract void paintShapes(Graphics g, Color aliveColor, Color deadColor, int cellSize);

	public void sleep(){
		try{ 
			Thread.sleep(500);
		}
		catch(Exception exc){
		}
	}
	int[][] currentStates;
	int[][] newStates;
}