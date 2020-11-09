class KensAutomata extends AbstractAutomata{

    KensAutomata(int arraySize){
        currentStates = new int[arraySize][arraySize];
        newStates = new int[arraySize][arraySize];
    }

	public int rules(int row, int column){
		if(currentStates[row][column] % 2 == 0){
			return ALIVE;
		}
		else{
			return DEAD;
		}
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