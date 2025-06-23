
/*
 * PersonSet.java
 * Name: Ernesto Morales Carrasco
 * Email: emoralescarras@cnm.edu
 * Assignment: Human Resources Part 2
 * Purpose: Implements PersonList to store unique Person objects in an ArrayList, 
 *          serving as a base class for PersonOrderedSet and PersonImperialSet.
 */
import java.util.ArrayList;

public class PersonSet implements PersonList {

    // List of Person objects, protected for access by subclasses in Part 2.
    protected ArrayList<Person> personList;

    // Initializes an empty PersonSet with a new ArrayList.
    public PersonSet() {
        personList = new ArrayList<>();
    }

    /**
     * Adds a Person to the set if not null and not already present.
     * Duplicates are checked using Person.equals via ArrayList.contains.
     * 
     * @param chosenPerson Person to add
     */
    @Override
    public void add(Person chosenPerson) {
        if (chosenPerson != null && !personList.contains(chosenPerson)) {
            personList.add(chosenPerson);
        }
    }

    /**
     * Retrieves a Person at the specified index.
     * Prints an error message and returns null if the index is out of bounds.
     * 
     * @param index Index of the Person
     * @return Person at the index, or null if the index is invalid
     */
    @Override
    public Person get(int index) {
        if (index >= 0 && index < personList.size()) {
            return personList.get(index);
        } else {
            System.out.println("Index " + index + " is out of bounds");
            return null;
        }
    }

    /**
     * Returns a string representation of all Person objects in the set.
     * Each Person's toString output is appended with a newline.
     * 
     * @return String representation of the set, including a header
     */
    @Override
    public String toString() {
        StringBuilder stringBuild = new StringBuilder();
        for (Person person : personList) {
            stringBuild.append(person.toString()).append("\n");
        }
        String header = "Name\tHeight (cm)\tWeight (kg)";
        return header + "\n" + stringBuild.toString();
    }
}
