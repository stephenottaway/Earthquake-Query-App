
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class EarthquakeQueryApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		// iterating through file to count number of lines in file
		
		int linecount = 0;
		try {
			
			Scanner scn = new Scanner(new File("all_month.csv"));
			
			
			while(scn.hasNextLine()) {
				
				String numberoflines = scn.nextLine();
				
				linecount++;
			}
			
			
			
		
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		
		// creating arrays for three data points with specified length
		
		String[] dateTimes = new String[linecount-1];
		double[] magnitudes = new double[linecount-1];
		String[] places = new String[linecount-1];
		
		// iterating through file to fill contents of three
		// new arrays with dateTimes, magnitudes, and places
		
		Scanner fileScanner = new Scanner(new File("all_month.csv"));
		
		int i=0;
		
		fileScanner.nextLine();

			  
			while (fileScanner.hasNextLine()) {
			    String line = fileScanner.nextLine();

			    Scanner rowScanner = new Scanner(line);
			    rowScanner.useDelimiter(",");			      
			      
			  
			    String date = rowScanner.next();
			    double magnitude = rowScanner.nextDouble();
			     
			    String place = rowScanner.nextLine();
			     
			    dateTimes[i] = date;
			    magnitudes[i] = magnitude;
		        places[i] = place;
			     
		        i++;

			} 
			
			
			
			//prompting user and reading input
			
			Scanner scn = new Scanner(System.in);
			
			System.out.print("Place:");
			String placeInput = scn.next();
			
			System.out.print("Magnitude:");
			double magnitudeInput = scn.nextDouble();
			
			
			
			String text = "";
			int amt_earthquakes = 0;
			System.out.println("\n\nSearch results:\n ");
			
			for(int j = 0; j<places.length; j++) 
			{					
				if (places[j].contains(placeInput) || placeInput.equals("-"))
				{
					// requirement for earthquake met
					
					if (magnitudes[j]>=magnitudeInput)					
					{
						
						// replacing all commas and quotation marks in places array with empty strings
						
						text = places[j];
						text = text.replaceAll(",", "");
						text = text.replaceAll("\"", "");
						
						
					

						System.out.println("Date and time:" + dateTimes[j] + "\n" + "Place:" + text + "\n" + "Magnitude:" + magnitudes[j]);
						System.out.println("------\n");
						amt_earthquakes++;
						
					}
				
				
				}
			}
			
			// output amount of earthquakes
			 
			if (amt_earthquakes==0)
			{
				System.out.println("no earthquakes found");
			}
			else
			{
				System.out.println(amt_earthquakes + " earthquakes...");
			}
			
		
					
			
			
			

			
		
		
		}
		
		
		
		
			
		
}

		
		



