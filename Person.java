/*
 * Person.java
 * Name: Ernesto Morales Carrasco
 * Email: emoralescarras@cnm.edu
 * Assignment: Human Resources Part 2
 * Purpose: Represents a person with name, height, and weight attributes, implementing 
 *          Comparable for name-based sorting in PersonOrderedSet.
 */

public class Person implements Comparable<Person> {
    private String name;
    private double height, weight;

    /**
     * Constructs a Person with the specified name, height, and weight.
     * 
     * @param name   The person's name
     * @param height The person's height (in cm or inches, depending on context)
     * @param weight The person's weight (in kg or pounds, depending on context)
     */
    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Setters
    public void setName(String chosenName) {
        name = chosenName;
    }

    public void setHeight(double chosenHeight) {
        height = chosenHeight;
    }

    public void setWeight(double chosenWeight) {
        weight = chosenWeight;
    }

    /**
     * Returns a string representation of the person in the format: name, height,
     * weight.
     * 
     * @return String of name, height, and weight
     */
    @Override
    public String toString() {
        return name + "\t" + height + "\t\t" + weight;
    }

    /**
     * Compares this Person to another based on name, height, and weight for
     * equality.
     * 
     * @param o Object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Person))
            return false;
        Person p = (Person) o;
        return this.name.equals(p.name) &&
                Double.compare(this.height, p.height) == 0 &&
                Double.compare(this.weight, p.weight) == 0;
    }

    /**
     * Compares this Person to another based on name for sorting purposes.
     * 
     * @param other The Person to compare with
     * @return A negative integer, zero, or a positive integer if this name is less
     *         than, equal to, or greater than the other person's name
     */
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
