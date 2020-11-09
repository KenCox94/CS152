import java.util.Random;

public class GOLAutomata extends AbstractAutomata{

	public GOLAutomata(int arraySize){
		currentStates = new int[arraySize][arraySize];
		newStates = new int[arraySize][arraySize];
	}

	public GOLAutomata(int rowSize, int colSize){
		currentStates = new int[rowSize][colSize];
		newStates = new int[rowSize][colSize];
	}

    public void randomArrayAssignment(){
        for(int i = 0; i < 1000; i++){
            int randRow = new Random().nextInt(currentStates.length);
            int randcolumn = new Random().nextInt(currentStates[randRow].length);
            if(currentStates[randRow][randcolumn] != ALIVE){
                currentStates[randRow][randcolumn] = ALIVE; 
             }
        }
    }

    /* Rules to be applied for the game of life
     *see https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Rules
     */
	public int rules(int row, int column){
		int neighborSums = currentStates[row-1][column - 1] + 
        currentStates[row-1][column] + 
        currentStates[row-1][column + 1] + 
        currentStates[row][column - 1] + 
        currentStates[row][column + 1] + 
        currentStates[row + 1][column-1] + 
        currentStates[row+1][column] + 
        currentStates[row+1][column+1];
        
        if( (neighborSums == 2 || neighborSums == 3) && currentStates[row][column] == ALIVE){ 
            return ALIVE; 
        }
        else if(currentStates[row][column] == DEAD && neighborSums == 3){ 
            return ALIVE; 
        }
        return DEAD;
	}

    /*Applies rules to each cell in newStates 
    for each currentState that has rules() applied to it*/
    protected void _applyRules(){
        for(int i = 1; i < newStates.length - 1; i++){
            for(int j = 1; j < newStates[i].length - 1; j++){
                newStates[i][j] = rules(i,j);
            }
        }
    }

    /*Sleeps thread for 500ms*/
    public void sleep(){
        try{ 
            Thread.sleep(500);
        }
        catch(Exception exc){
        }
    }

    /*Hands over values from newStates to currentStates for display*/
    protected void _changeStates(){
        for(int i = 0; i < currentStates.length; i++){
            for(int j = 0; j < currentStates[i].length; j++){
                currentStates[i][j] = newStates[i][j];
            }
        }
    }
}