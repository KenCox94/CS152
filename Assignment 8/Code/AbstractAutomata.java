import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

abstract class AbstractAutomata{
	public static final int ALIVE = 1;
	public static final int DEAD = 0;
	
    abstract int rules(int row, int column);

    public void randomArrayAssignment(){
        for(int i = 0; i < 1000; i++){
            int randRow = new Random().nextInt(currentStates.length);
            int randcolumn = new Random().nextInt(currentStates[randRow].length);
            if(currentStates[randRow][randcolumn] != ALIVE){
                currentStates[randRow][randcolumn] = ALIVE; 
             }
        }
    }

	public void allStatesDead(int arraySize){
        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                currentStates[i][j] = DEAD;
            }
        }
    }

	public void playBack(int arraySize){
        for(int i = 1; i < arraySize - 1; i++){
            for(int j = 1; j < arraySize - 1; j++){
                newStates[i][j] = rules(i,j);
            }
        }

        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j<arraySize; j++){
                currentStates[i][j] = newStates[i][j];
            }
        }
    }

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