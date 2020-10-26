class CelluarAutomata{
    public static void main(String[] args){
        int size = 100;
        int[] currentStates = new int[size];
        int[] nextStates = new int[size];

        final int ALIVE = 1;
        final int DEAD = 0;

        for(var i : currentStates){
        	i = DEAD;
        }
        currentStates[size/2] = ALIVE;
    }

}