public class GOLAutomata extends AbstractAutomata{

	public GOLAutomata(int arraySize){
		currentStates = new int[arraySize][arraySize];
		newStates = new int[arraySize][arraySize];
	}

	public GOLAutomata(int rowSize, int colSize){
		currentStates = new int[rowSize][colSize];
		newStates = new int[rowSize][colSize];
	}

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

    protected void _applyRules(){
        for(int i = 1; i < newStates.length - 1; i++){
            for(int j = 1; j < newStates[i].length - 1; j++){
                newStates[i][j] = rules(i,j);
            }
        }
    }

    protected void _changeStates(){
        for(int i = 0; i < currentStates.length; i++){
            for(int j = 0; j < currentStates[i].length; j++){
                currentStates[i][j] = newStates[i][j];
            }
        }
    }
}