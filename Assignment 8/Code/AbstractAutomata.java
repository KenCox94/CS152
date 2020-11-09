/* Abstract class with common functionality for CAs.*/
import java.awt.Graphics;
import java.awt.Color;

abstract class AbstractAutomata{
	public static final int ALIVE = 1;
	public static final int DEAD = 0;

    /*Assigns all states in currentStates to DEAD*/
	public void allStatesDead(int arraySize){
        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                currentStates[i][j] = DEAD;
            }
        }
    }

    /*Applies rules and changes states that are defined in concrete classes*/
	public void playBack(int arraySize){
        _applyRules();    

        _changeStates();
    }

    /*Displays cell colors based on state*/
	public void paintShapes(Graphics g, Color aliveColor, Color deadColor, int cellSize){
        for(int i = 0; i < currentStates.length; i++){
            for(int j = 0; j<currentStates[i].length; j++) {
                if(currentStates[i][j] == ALIVE){
                    g.setColor(aliveColor);
                    g.fillRect(j*cellSize, i*cellSize, cellSize-1, cellSize-1);
                }
                else{
                    g.setColor(deadColor);
                    g.fillRect(j*cellSize, i*cellSize, cellSize-1, cellSize-1);
                }
            }
		}
	}

    abstract void randomArrayAssignment();

    abstract void sleep();

    abstract int rules(int row, int column);

    protected abstract void _applyRules();

    protected abstract void _changeStates();

	int[][] currentStates;
	int[][] newStates;
}