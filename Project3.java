/**
 * COP 3538: Project 3 - Linked Lists
 * <p>
 * This class reads in a .csv file of a list of countries. There are different
 * parameters within the list. The class takes these, and based on the 
 * GDP Per Capita, separates them into 3 categories: fair, good, and very good, and
 * pushes them onto a stack.
 * <p>
 * The program discards the countries that do not fit without modifying the input
 * file. It prints that stack, and then has several situations that it must work
 * with regarding the queue.
 * <p>
 * For organization there are some print methods, and a method to read the file
 * while pushing the particular country objects onto the stack.
 * 
 * @author <Jeremiah Baclig>
 * @version <10/21/2019>
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Project3 {
	
		// initialize local variables
		private static Stack stack = new Stack();
		private static Queue queue = new Queue();
		
		private static double GDPPerCapita;
		private static Country insCountry;

	/*
	 *  Method to print out the title of each of the lists of country objects.
	 */
	private static void printTitle() {
		String name = "Name";
		String code = "Code";
		String capitol = "Capitol";
		String population = "Population";
		String gdp = "GDP";
		String happy = "HappinessRank";

		// use printf to keep consistent instead of using \t
		System.out.printf("%-32s%-16s%-24s%-24s%-24s%-12s\n", name, code, capitol, population, gdp, happy);
		for(int i=0; i<135; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	/*  Method that reads in the file using a buffered reader.
	 *  It reads the first line and then inserts the following into a 
	 *  Country object using the constructor in the Country class. It then 
	 *  pushes the objects into the stack based on GDP Per Capita.
	 */
	private static void readFile() throws NumberFormatException, IOException {
		Scanner fileScan = new Scanner(System.in);
		String fileName;
		System.out.println("COP 3538 Project 3\n\nLinked Lists\nEnter the file:");
		fileName = fileScan.next();
		
		System.out.println("\n");

		File file = new File(fileName);
		fileScan.close();
		
		// Creates a way to read in the file while not storing the first line.
		BufferedReader reader = new BufferedReader(new FileReader(file));
		reader.readLine();

		String line;
		
		while ((line = reader.readLine()) != null) {

			String obj[] = line.split("[,\n]");
		
			insCountry = new Country(obj[0], obj[1], obj[2], Long.parseLong(obj[3]), Double.parseDouble(obj[4]), Integer.parseInt(obj[5]));
			
			GDPPerCapita = Double.parseDouble(obj[4]) / Long.parseLong(obj[3]);
			
				// only push countries who have GDP Per Capita that fall within the previous parameters of fair, good, and very good
				if(GDPPerCapita < 5000) {
					stack.push(insCountry);
				}
				else if(GDPPerCapita < 20000) {
					stack.push(insCountry);
				}
				else if(GDPPerCapita < 50000) {
					stack.push(insCountry);
				}
	
		}
		reader.close();
	}
	
	/*
	 *  Main method of the class. Reads in the file using the readFile() method.
	 *  It prints the stack that was made and then pops from it. It then inserts 
	 *  into a queue - front then back. Prints queue, then deletes based on 
	 *  GDP Per Capita.
	 *  <p>
	 *  After deletion it prints again, then removes from the queue while
	 *  pushing removed items onto a stack. Prints stack and then exits.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		readFile();
		
		// prints stack for the first time
		System.out.println("Stack Contents:");
		printTitle();
		stack.printStack();	
		System.out.println();

		// pop from stack and alternate the inserts to the queue
		Country country;
		while (!stack.isEmpty()) {
			country = stack.pop();
			queue.insertFront(country);
			country = stack.pop();
			queue.insertEnd(country);
		}
	
		// print queue for the first time
		System.out.println("Queue Contents:");
		printTitle();
		queue.printQueue();
		
		// remove the countries from the stack that have GDP Per Capita between 30000 and 40000
		if(GDPPerCapita > 30000 && GDPPerCapita < 40000) {
			queue.findDelete(insCountry);
		}
		
		System.out.println("Queue Contents:");
		printTitle();
		queue.printQueue();
		
		// alternate the removal from the queue and push those onto the stack
		while (!queue.isEmpty()) {
			country = queue.removeFront();
			stack.push(country);
			country = queue.removeEnd();
			stack.push(country);
		}
		
		System.out.println("Stack Contents:");
		printTitle();
		stack.printStack();
	}
}
