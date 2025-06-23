/*
Name: Ernesto Morales Carrasco
Email: emoralescarras@cnm.edu
Assignment: Human Resources Part 2
Purpose: Reads HR data from hr.txt, stores unique Person objects in PersonOrderedSet
and PersonImperialSet, and outputs sorted and imperial-converted data to console and files

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

		System.out.println("Testing Part 2:");

		// Check for correct command-line argument
		if (args.length != 1) {
			System.out.println("Usage: java Main <filename>");
			return;
		}

		// Initialize sets for sorted and imperial data
		PersonOrderedSet orderedSet = new PersonOrderedSet();
		PersonImperialSet imperialSet = new PersonImperialSet();

		// Add Yoshi to both sets
		Person testPerson = new Person("Yoshi", 177.0, 80.0);
		orderedSet.add(testPerson);
		imperialSet.add(new Person("Yoshi", 177.0, 80.0));
		
		// Read data from input file
		try (Scanner fileReader = new Scanner(new File(args[0]))) {
			fileReader.nextLine(); // Skip header row
			while (fileReader.hasNext()) {
				try {
					String name = fileReader.next();
					double height = fileReader.nextDouble();
					double weight = fileReader.nextDouble();
					Person personOrdered = new Person(name, height, weight);
					Person personImperial = new Person(name, height, weight);
					orderedSet.add(personOrdered);
					imperialSet.add(personImperial);
				} catch (Exception e) {
					System.out.println("Error parsing line, skipping...");
					fileReader.nextLine();
				}
			}

			// Write to output files
			try (FileWriter orderedWriter = new FileWriter("hr_ordered_set_output.txt");
					FileWriter imperialWriter = new FileWriter("hr_imperial_set_output.txt")) {
				orderedWriter.write(orderedSet.toString());
				imperialWriter.write(imperialSet.toString());
			} catch (IOException e) {
				System.out.println("Error writing to files: " + e.getMessage());
			}

			// Console output
			System.out.println("Ordered Set:");
			System.out.println(orderedSet.toString());
			System.out.println("Imperial Set:");
			System.out.println(imperialSet.toString());
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

	}
}