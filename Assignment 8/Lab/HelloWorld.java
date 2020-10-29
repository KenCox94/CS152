import java.util.Scanner;

public class HelloWorld{
	public static void main(String[] args)
	{
		float[] floatAr = {1,2,3};
		System.out.println("Hello World!");
		System.out.println(addNumbers(1, 2, 3));
		System.out.println(floatArray(floatAr));
		promptZ();		
	}

	public static int addNumbers(int a, int b, int c){
		return a + b + c;
	}

	public static float floatArray(float[] arg){
		float sum = 0;
		for(float i : arg){
			sum += i;
		}
		return sum;
	}

	public static void promptZ(){
		Scanner ch = new Scanner(System.in);
		char word;
		do{
			System.out.println("Please enter a letter: ");
			word = ch.next().charAt(0);
		}while(word != 'z');
	}
}