
/*
 * PersonOrderedSet.java
 * Name: Ernesto Morales Carrasco
 * Email: emoralescarras@cnm.edu
 * Assignment: Human Resources Part 2
 * Purpose: Extends PersonSet to maintain a sorted list of unique Person objects, 
 *          ordered by name using the Comparable interface.
 */

import java.util.Collections;

public class PersonOrderedSet extends PersonSet {

    /**
     * Adds a Person to the set and sorts the list by name.
     * Calls the superclass's add method to ensure uniqueness, then sorts the list.
     * 
     * @param chosenPerson Person to add to the set
     */
    @Override
    public void add(Person chosenPerson) {
        super.add(chosenPerson);
        sort();
    }

    /**
     * Sorts the personList using Collections.sort, using Person's compareTo method.
     * This ensures the list is always ordered alphabetically by name.
     */
    private void sort() {
        Collections.sort(personList);
    }
}
