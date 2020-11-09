public class LangtonAnt extends AbstractAutomata{


	LangtonAnt(int arraySize, int startVarRow, int startVarCol){
		currentStates = new int [arraySize][arraySize];
		newStates = new int[arraySize][arraySize];
		this.startVarRow = startVarRow;
		this.startVarCol = startVarCol;
		yChange = 1;
		xChange = 0;
	}

	public int rules(int row, int column){
		return (currentStates[row][column] == ALIVE) ? DEAD : ALIVE;
	}


	protected void _applyRules(){
		newStates[startVarRow][startVarCol] = rules(startVarRow, startVarCol);
	}

	protected void _changeStates(){
		currentStates[startVarRow][startVarCol] = newStates[startVarRow][startVarCol];
		if(currentStates[startVarCol][startVarRow] == ALIVE){
			if(xChange == 0){
				xChange = yChange;
				yChange = 0;
			}
			else{
				yChange = -xChange; 
				xChange = 0;
			}
		}
		else{
			if(xChange == 0){
				xChange = -yChange;
				yChange = 0;
			}
			else{ 
				yChange = xChange;
				xChange = 0;
			}
		}

		startVarCol = startCalc(startVarCol, xChange);
		startVarRow = startCalc(startVarRow, yChange); 
	}


	protected int startCalc(int startingValue, int direction){
		startingValue += direction;
		if(startingValue > currentStates.length - 1){
			return 0;
		}
		else if (startingValue < 0){
			return currentStates.length - 1;
		} 
		return startingValue;
	}
	 
	int xChange;
	int yChange;
	int startVarRow;
	int startVarCol;
}