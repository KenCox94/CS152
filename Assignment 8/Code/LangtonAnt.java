public class LangtonAnt extends AbstractAutomata{

	LangtonAnt(int arraySize, int startVarRow, int startVarCol){
		currentStates = new int [arraySize][arraySize];
		newStates = new int[arraySize][arraySize];
		this.startVarRow = startVarRow;
		this.startVarCol = startVarCol;
		yChange = 1;
		xChange = 0;
	}

	public void randomArrayAssignment(){
		return;
	}

	/*Switches state that ant is currently in*/
	public int rules(int row, int column){
		return (currentStates[row][column] == ALIVE) ? DEAD : ALIVE;
	}

	/*sleeps thread for 10ms*/
	public void sleep(){
		try{ 
			Thread.sleep(10);
		}
		catch(Exception exc){
		}
	}

	/*Applies rule to newState array*/
	protected void _applyRules(){
		newStates[startVarRow][startVarCol] = rules(startVarRow, startVarCol);
	}

	/* An attempt at implementing the change in direction needed for Langton Ant
	CA. If statements will change directions for "ant" based on current state of cell.
	*/
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

	/*Allows for wrapping around the frame.*/
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
	
	/* Constructor will start the ant off facing Up
	*/ 
	int xChange; //x Directional Change
	int yChange; //y Directional Change 
	int startVarRow; 
	int startVarCol;
}