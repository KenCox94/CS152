public class CelluarAutomataTester{

	private static int correctTest, totalTest = 0;


	private static void clearCounts(){
		correctTest = 0;
		totalTest =0;
	}

	private static void countTest(boolean correct){
		if(correct){
			correctTest++;
		}
		totalTest++; 
	}

	public static void ruleTester(){
		countTest(CelluarAutomata.rule(1,1,0) == 1);
		countTest(CelluarAutomata.rule(1,1,1) == 0);
		countTest(CelluarAutomata.rule(1,0,0) == 1);
		countTest(CelluarAutomata.rule(1,0,1) == 0);
		countTest(CelluarAutomata.rule(0,1,0) == 0);
		countTest(CelluarAutomata.rule(0,1,1) == 1);
		countTest(CelluarAutomata.rule(0,0,0) == 0);
		countTest(CelluarAutomata.rule(0,0,1) == 1);
	}

	public static void main(String[] args){
		ruleTester();
		System.out.println("You got " + correctTest + " test correct out of " + totalTest + " for the rule method");
	}

}