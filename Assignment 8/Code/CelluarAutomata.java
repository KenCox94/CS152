class CelluarAutomata{
	final static int ALIVE = 1;
    final static int DEAD = 0;

	public static void displayCurrentStates(int[] currentStatesIn){
    	for(var i : currentStatesIn){
    		if(i == DEAD){ System.out.print(' '); }
    		else{ System.out.print('*'); }
    	}
    	System.out.println();
    }

    public static int rule(int left, int center, int right){
    	if((left ^ right) == 1 ){
    		return ALIVE;
    	}
    	else{
    		return DEAD;
	   	}
    }

    public static void main(String[] args){
        int size = 100;
        int[] currentStates = new int[size];
        int[] nextStates = new int[size];

        for(var i : currentStates){
        	i = DEAD;
        }

        currentStates[size/2] = ALIVE;
      
        displayCurrentStates(currentStates);

    }

}