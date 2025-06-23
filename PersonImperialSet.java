/*
 * PersonImperialSet.java
 * Name: Ernesto Morales Carrasco
 * Email: emoralescarras@cnm.edu
 * Assignment: Human Resources Part 2
 * Purpose: Extends PersonSet to store unique Person objects with height and weight 
 *          converted to imperial units (inches and pounds).
 */
public class PersonImperialSet extends PersonSet {
    
    /**
     * Adds a Person to the set after converting their height and weight to imperial units.
     * Ensures uniqueness by calling the superclass's add method.
     * 
     * @param chosenPerson The Person to add, with measurements in metric units
     */
    @Override
    public void add(Person chosenPerson) {
        if (chosenPerson != null) {
            // Create new Person with converted height and weight
            Person imperialPerson = new Person(
                    chosenPerson.getName(),
                    convertHeight(chosenPerson.getHeight()),
                    convertWeight(chosenPerson.getWeight()));
            // Add converted Person using PersonSet's add
            super.add(imperialPerson);
        }
    }

    /**
     * Converts height from centimeters to inches, rounded to two decimal places.
     * 
     * @param height The height in centimeters
     * @return The height in inches
     */
    private double convertHeight(double height) {
        // 1 cm ~ 0.393701 inches
        return Math.round(height * 0.393701 * 100.0) / 100.0;
    }

    /**
     * Converts weight from kilograms to pounds, rounded to two decimal places.
     * 
     * @param weight The weight in kilograms
     * @return The weight in pounds
     */
    private double convertWeight(double weight) {
        // 1 kg ~ 2.20462 pounds
        return Math.round(weight * 2.20462 * 100.0) / 100.0;
    }

    /**
     * Returns a string representation of all Person objects in the set.
     * Each Person's toString output is appended with a newline, with a header 
     * indicating measurements in inches and pounds.
     * 
     * @return A string representation of the set with a header
     */
    @Override
    public String toString() {
        StringBuilder stringBuild = new StringBuilder();
        for (Person person : personList) {
            stringBuild.append(person.toString()).append("\n");
        }
        String header = "Name\tHeight (in)\tWeight (lb)";
        return header + "\n" + stringBuild.toString();
    }
}