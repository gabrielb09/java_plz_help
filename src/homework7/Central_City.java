package homework7;
/* Central City finder
 * by: Gabriel Bridges
 * Finds which city of a set is in the center of the set 
 */

import java.util.Scanner;
import java.lang.Math;

public class Central_City {

	public static void main(String[] args) {
		// Declares a Scanner method 
		Scanner input = new Scanner(System.in);
		// Gets how many cities the user wants to input
		System.out.println("How many cities do you want to analyze? ");
		int numCities = input.nextInt();
		// Creates an array to store the location of the cities
		double[][] cities = new double[numCities][2];
		// Declares some important variables
		String location;
		int split;
		location = input.nextLine();
		// Iterates through each city
		for(int c = 0; c < numCities; c++){
			// Gets the location of each city
			System.out.println("What is the coordinate position of city #" + (c+1) + " formatted \'(X,Y)\'");
			location = input.nextLine();
			split = location.indexOf(',');
			cities[c][0] = Float.parseFloat(location.substring(1, split));
			cities[c][1] = Float.parseFloat(location.substring(split + 1, location.length()-1));
		}
		input.close();
		double[] centralCity = centralCity(cities);
		System.out.println("The central city is located at (" + centralCity[centralCity.length-2] + 
							"," + centralCity[centralCity.length-1] + ")");
		System.out.println("The central city is:");
		for(int c = 0; c < centralCity.length-2; c++){
			if(centralCity[c] != 0){
				System.out.println(centralCity[c] + " from city " + (c+1));
			}
		}

	}
	// Declares a method to locate the central city
	public static double[] centralCity(double[][] cities){
		// creates an Array to hold the location of the central city and its distance to the other cities
		double[] centralCityDist = new double[cities.length + 2];
		// declares some important variables
		double[] totalDist = new double[cities.length];
		double Dist;
		// Iterates through the array of cities
		for(int c = 0; c < cities.length; c++){
			// Iterates through each city
			for(int i = 0; i < cities.length; i++){
				Dist = Math.sqrt(Math.pow((cities[i][0]-cities[c][0]), 2) + Math.pow((cities[i][1]-cities[c][1]), 2));
				totalDist[c] += Dist;
			}
		}
		// Identifies the "central city"
		double temp = totalDist[0];
		int centralIndex = 0;
		for(int c = 0; c < totalDist.length; c++){
			temp = totalDist[c];
			if (temp < totalDist[centralIndex]){
				centralIndex = c;
			}
		}
		// Assigns the coordiantes of the city to the last two cells of the "centralCityDist array" 
		centralCityDist[(cities.length)-1] = cities[centralIndex][1];
		centralCityDist[(cities.length)-2] = cities[centralIndex][0];
		// Assigns the distance to every city to the other cells in that array
		for(int c = 0; c < centralCityDist.length-2; c++){
			centralCityDist[c] = Math.sqrt(Math.pow((cities[c][0]-cities[centralIndex][0]), 2) + Math.pow((cities[c][1]-cities[centralIndex][1]), 2));
		}
		return centralCityDist;
	}

}
