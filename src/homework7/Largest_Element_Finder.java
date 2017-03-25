package homework7;
/* Largest Element Finder
 * by: Gabriel Bridges
 * Finds the largest element of a two dimensional array
 */

import java.util.Scanner;

public class Largest_Element_Finder {

	public static void main(String[] args) {
		// Declares a Scanner method and some variables 
		Scanner input = new Scanner(System.in);
		int row;
		int col;
		// Gets the number of rows the user wants
		System.out.println("How many rows?");
		row = input.nextInt();
		// gets the number of columns the user wants
		System.out.println("How many columns?");
		col = input.nextInt();
		// creates an array of the same size that the user wants
		double[][] arr = new double[row][col];
		// Iterates through each row
		for(int c = 0; c < arr.length; c++){
			// Iterates through each cell in that row
			for(int i = 0; i < arr[c].length; i++){
				// gets the value of that cell
				System.out.println("Please enter the value for row " + (c+1) + ", column " + (i+1));
				arr[c][i] = input.nextDouble();
			}
		}
		input.close();
		//Prints our the location of the largest value
		System.out.println("The largest value is in row " + (locateLargest(arr)[0]+1) + 
						   " and column " + (locateLargest(arr)[1] + 1));
	}
	// Declares a method to locate the largest element
	public static int[] locateLargest(double[][] a){
		// creates a new array with two elements to hold the location data
		int[] location = new int[2];
		// creates a temp variable to search
		double temp = 0;
		// Iterates through each row
		for(int c = 0; c < a.length; c++){
			// Iterates through each cell in that row
			for(int i = 0; i < a[c].length; i++){
				// Checks to see if that cell is larger then the previous cells
				if(a[c][i] > temp){
					temp = a[c][i];
					location[0] = c;
					location[1] = i;
				}
			}
		}
		return location;
	}

}
