import java.util.Arrays;

public class arrayTester{
	
	public static void main(String[] args){
		int[][] a = new int[10][10];
		populate(a);
		a[0][0] = 0;
		a[1][0] = 0;
		a[2][0] = 0;
		a[0][2] = 0;
		a[1][2] = 0;
		a[2][2] = 0;
		System.out.println(Arrays.deepToString(subArray(a, 0, 0)));
	}

	public static void populate(int[][] multiDimArray){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				multiDimArray[i][j] = 1;
			}
		}
	}
	public static int[][] subArray(int[][] multiDimArray, int row, int col){
		int[][] tempArray = new int[3][3];
		for(int i = row, j = col; i < 3; i++, j++){
			tempArray[j] = Arrays.copyOfRange(multiDimArray[i], col, col+3);
		}
		return tempArray;
	}

}
