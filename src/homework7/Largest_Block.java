package homework7;
/* Largest Block Locator
 * by: Gabriel Bridges
 * Finds the largest possible block of 1's in an array of 0's and 1's
 */

import java.util.Scanner;
import java.util.Random;

public class Largest_Block {

	public static void main(String[] args) {
		// this is just to test the code make sure it works
		int[][] matrix = new int[][]{{1,0,1,0,1},{1,1,1,0,1},{1,0,1,1,1},{1,0,1,1,1},{1,0,1,1,1}};
		// print the output
		System.out.println("The maximum square submatrix is at (" + blockLocate(matrix)[0] + "," + blockLocate(matrix)[1] + ") with size " + blockLocate(matrix)[2]);
	}
	public static int[] blockLocate(int[][] matrix){
		// create three arrays
		// array#1 progress, tell "oneLocate" method where we are in the matrix
		int[] progress = new int[]{0,0};
		// array #2 this will store the block we just found
		int[] larger = new int[3];
		// array #3 this will store the output of this method
		int[] location = new int[3];
		// create a few variables
		// num to store the value of the matrix at a location
		int num = 1;
		// width to store the width of the block
		int width = 0;
		// height to store the height of the block
		int height = 0;
		// loop until there are no more ones to find (findOne returns -1 once there are no more rows to search)
		while (findOne(matrix, progress)[0] != -1){
			// Iterate through every row and column of matrix from the given one to find the height and width of the submatrix
			for(int c = 0; (findOne(matrix, progress)[0]+c < matrix.length) && num == 1; c++){
				for(int i = 0; (findOne(matrix, progress)[1]+i < matrix.length) && num == 1; i++){
					// assigns the value of the located cell of the matrix to "num"
					num = matrix[findOne(matrix, progress)[0]+c][findOne(matrix, progress)[1]+i];
					// makes width and height i and c respectively
					width = i;
					height = c;
				}
			}
			// need to find a square matrix so, if the width is greater then the hright shrink it down
			if (width > height){
				width = height;
			}
			// loop through the entire submatrix
			for(int c = 0; c <= height; c++){
				for(int i = 0; i <= width; i++){
					// if any cell is not 1 shrinks the submatrix to the necessary size 
					if(matrix[findOne(matrix, progress)[0]+c][findOne(matrix, progress)[1]+i] != 1){
						if(i>c){
							height = c;
							width = c;
						}
						else{
							height = i;
							width = i;
						}
					}
				}
			}
			// assigns the "x" and "y" coordinates of the first cell in the block the "larger" array
			larger[0] = findOne(matrix, progress)[0];
			larger[1] = findOne(matrix, progress)[1];
			// assigns the size of that block to the third cell
			larger[2] = height;
			// if the larger array is describing a block which is larger then the current location array reasign location
			if (larger[2] > location[2]){
				location[0] = larger[0];
				location[1] = larger[1];
				location[2] = larger[2];
			}
			// update progress to point to the latest number but shifter one column over
			progress[0] = findOne(matrix, progress)[0];
			progress[1] = findOne(matrix, progress)[1] + 1;
		}
		// return the location array 
		return location;
		
		
	}
	public static int[] findOne(int[][] matrix, int[] progress){
		// creates a couple of important variables
		boolean isOne = false;
		int[] location = new int[2];
		// if the progress is at the lest column reset the column position and shift the row down by one
		if (progress[1] == matrix[0].length-1){
			progress[0] += 1;
			progress[1] = 0;
		}
		// Iterates through the entire matrix and returns the first 1 it finds after the position given by the progress 
		for(int c = progress[0]; (!isOne && c != matrix.length); c++){
			for(int i = progress[1]; !isOne && i < matrix[0].length; i++){
				if (matrix[c][i] == 1){
					isOne = true;
					location[0] = c;
					location[1] = i;
				}
			}
		}
		// creates a "stop" case, if we reach the last 1 return a position (-1,-1) which we can test for to stop checking for 1's
		if(progress[0] >= matrix.length-2 && !(location[1] > progress[1])){
			location[0] = -1;
			location[1] = -1;
		}
		return location;
	}
}
	