package homework7;
/* Markov Matrix 
 * by: Gabriel Bridges
 * Finds which city of a set is in the center of the set 
 */

import java.util.Scanner;

public class Markov_Matrix {

	public static void main(String[] args) {
		// create a Scanner class
		Scanner input = new Scanner(System.in);
		// creates the matrix
		double[][] Markov = new double[3][3];
		// gets the user input
		for(int c = 0; c < 3; c++){
			System.out.println("Enter column " + (c+1));
			Markov[0][c] = input.nextDouble();
			Markov[1][c] = input.nextDouble();
			Markov[2][c] = input.nextDouble();
		}
		input.close();
		// Check if the Matrix is a Markov Matrix and tells the user if it is
		if(isMarkovMatrix(Markov)){
			System.out.println("This is a Markov Matrix!");
		}
		else{
			System.out.println("This is not a Markov Matrix");
		}

	}
	public static boolean isMarkovMatrix(double [][] m){
		// creates an array to store the sum of each column
		double[] sum = new double[m[0].length];
		// creates a few boolean variables
		boolean result = true, sums = true, positive = true;
		// Iterate through each column
		for (int c = 0; c < sum.length; c++){
			// iterate through each cell in the column 
			for (int i =0 ; i < m.length; i++){
				// Sums the columns and stores their values
				sum[c] += m[i][c];
			}
		}
		// Iterate through each column
		for (int c = 0; c < sum.length; c++){
			// If the sum of any column is not 1 set sum to false
			if (sum[c] != 1){
				sums = false;
			}
		}
		// Iterate through the matrix
		for (int c = 0; c < m.length; c++){
			for (int i = 0; i < m[0].length; i++){
				// If any of the cells are negative set postivie to false
				if (m[c][i] < 0){
					positive = false;
				}
				else{
					positive = true;
				}
			}
		}
		// If both conditions are true set result to true
		if (positive && sums){
			result = true;
		}
		// Otherwise set it to false
		else{
			result = false;
		}
		// Return the result 
		return result;
	}

}
