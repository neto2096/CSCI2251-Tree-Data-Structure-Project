/*
 * PersonList.java
 * Name: Ernesto Morales Carrasco
 * Email: emoralescarras@cnm.edu
 * Assignment: Human Resources Part 2
 * Purpose: Defines an interface for managing a list of Person objects, implemented by 
 *          PersonSet, PersonOrderedSet, and PersonImperialSet.
 */

public interface PersonList {
    public void add(Person newPerson);

    public Person get(int index);
}