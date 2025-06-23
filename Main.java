/*
Name: Ernesto Morales Carrasco
Email: emoralescarras@cnm.edu
Assignment: Tree Data Structure
Purpose: Reads HR data from hr.txt, stores unique Person objects in SortedTreeSet and outputs sorted data to console and file.

Questions with answers:
Q1: Car and Engine are related by (Composition). Engine is tied to Car.
Q2: Color and Red are related by (Inheritance). Red is a type of Color.
Q3: Shirt and Clothing are related by (Inheritance). Shirt is a type of Clothing.
Q4: Furniture and Desk are related by which (Inheritance). Desk is a type of Furniture.
Q5: CellPhone and Battery are related by (Composition). Battery is tied to CellPhone.
*/

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Check for correct command-line argument
		if (args.length != 1) {
			System.out.println("Usage: java Main <filename>");
			return;
		}

		// Initialize sorted tree set
		SortedTreeSet sortedSet = new SortedTreeSet();

		// Add Yoshi to both sets
		Person testPerson = new Person("Yoshi", 177.0, 80.0);
		sortedSet.add(testPerson);

		// Read data from input file
		try (Scanner fileReader = new Scanner(new File(args[0]))) {
			fileReader.nextLine(); // Skip header row
			while (fileReader.hasNext()) {
				try {
					String name = fileReader.next();
					double height = fileReader.nextDouble();
					double weight = fileReader.nextDouble();
					Person person = new Person(name, height, weight);
                    sortedSet.add(person);
				} catch (Exception e) {
					System.out.println("Error parsing line, skipping...");
					fileReader.nextLine();
				}
			}

			// Write to output files
			try (FileWriter writer = new FileWriter("hr_sorted_tree_output.txt")) {
                writer.write(sortedSet.toString());
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

			// Console output
			System.out.println("Sorted Tree Set:");
            System.out.println(sortedSet.toString());
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

	}
}