public class LangtonAnt extends AbstractAutomata{


	LangtonAnt(int arraySize, int startVarRow, int startVarCol){
		currentStates = new int [arraySize][arraySize];
		newStates = new int[arraySize][arraySize];
		this.startVarRow = startVarRow;
		this.startVarCol = startVarCol;
		directionLat = 0;
		directionLon = 1;
	}

	public int rules(int row, int column){
		return (currentStates[row][column] == ALIVE) ? DEAD : ALIVE;
	}


	protected void _applyRules(){
		newStates[startVarRow][startVarCol] = rules(startVarRow, startVarCol);
	}

	protected void _changeStates(){
		currentStates[startVarRow][startVarCol] = newStates[startVarRow][startVarCol];
		if(currentStates[startVarCol][startVarRow] == DEAD){
			if(Math.abs(directionLon) == 1){
				directionLon *= -1;
				directionLat = 0;
			}
			else{
				directionLat *= -1;
				directionLon = 0;
			}
		}
		if(currentStates[startVarCol][startVarCol] == ALIVE){
			if(Math.abs(directionLat) == 1){
				directionLon *= -1;
				directionLat = 0;
			}
			else{
				directionLon *= -1;
				directionLat = 0;
			}
		}
		startVarCol = startCalc(startVarCol, directionLon);
		startVarRow = startCalc(startVarRow, directionLat); 
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
	 
	int directionLat;
	int directionLon;
	int startVarRow;
	int startVarCol;
}