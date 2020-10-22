import java.util.Scanner;
// import java.lang.Math;

public class ScannerDemo{

	public static final int DRINKING_AGE = 21;

	public static void main(String[] args){
		
		Scanner scanIn = new Scanner(System.in);

		System.out.println("What is your name?");

		String name = scanIn.nextLine();

		System.out.println(name + ", Guess a number");

		int guess = scanIn.nextInt();

		int randInt = (int)(Math.random()*10) + 1 ;

		System.out.println("You guessed " + guess);

		System.out.println("I was thinking of " + randInt);

		String guessResult = randInt == guess ? "You got it right" : "Sorry " + name + " you got it wrong";

		System.out.println(guessResult);
	}
}