public class CovidCalculations{
	public static double kermackMcKendrick(int probability, int neighbors){
		return Math.pow(1-(1 - probability), infectNeighbors);
	}
}