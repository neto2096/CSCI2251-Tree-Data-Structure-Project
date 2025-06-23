/*
 * SortedTreeSet.java
 * Name: Ernesto Morales Carrasco
 * Email: emoralescarras@cnm.edu
 * Assignment: Tree Data Structure
 * Purpose: Implements a self-sorting binary search tree for unique Person objects,
 *          ordered by name, replacing PersonOrderedSet.
 */

public class SortedTreeSet implements SortedTreeSetInterface {
    private Person person;
    private SortedTreeSet left;
    private SortedTreeSet right;
    private SortedTreeSet parent;

    /**
     * Constructs an empty SortedTreeSet node.
     */
    public SortedTreeSet() {
        person = null;
        left = null;
        right = null;
        parent = null;
    }

    /**
     * Constructs a SortedTreeSet node with a Person.
     * 
     * @param p Person to store in this node
     */
    public SortedTreeSet(Person p) {
        person = p;
        left = null;
        right = null;
        parent = null;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public boolean hasLeft() {
        return left != null;
    }

    @Override
    public void setLeft(SortedTreeSet left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    @Override
    public SortedTreeSet getLeft() {
        return left;
    }

    @Override
    public boolean hasRight() {
        return right != null;
    }

    @Override
    public void setRight(SortedTreeSet right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    @Override
    public SortedTreeSet getRight() {
        return right;
    }

    /**
     * Returns the parent of this node.
     * 
     * @return Parent SortedTreeSet node, or null if this is the root
     */
    public SortedTreeSet getParent() {
        return parent;
    }

    /**
     * Adds a Person to the tree in sorted order, preventing duplicates.
     * 
     * @param p Person to add
     */
    @Override
    public void add(Person p) {
        if (p == null) {
            return;
        }

        // If this is an empty node, initialize it
        if (person == null && !hasLeft() && !hasRight()) {
            person = p;
            return;
        }

        // Compare names for insertion
        int compare = p.getName().compareTo(person.getName());

        if (compare == 0) {
            if (person.equals(p)) {
                return;
            }
        }

        if (compare < 0) {
            if (!hasLeft()) {
                setLeft(new SortedTreeSet(p));
            } else {
                left.add(p);
            }
        } else {
            if (!hasRight()) {
                setRight(new SortedTreeSet(p));
            } else {
                right.add(p);
            }
        }
    }

    /**
     * Returns a string representation of the tree using in-order traversal.
     * 
     * @return String of all Person objects in sorted order, with header
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String header = "Name\tHeight (cm)\tWeight (kg)\n";
        sb.append(header);
        inOrderTraversal(sb);
        return sb.toString();
    }

    /**
     * Performs an in-order traversal to build the sorted string representation.
     * 
     * @param sb StringBuilder to append Person data
     */
    private void inOrderTraversal(StringBuilder sb) {
        if (hasLeft()) {
            left.inOrderTraversal(sb);
        }
        if (person != null) {
            sb.append(person.toString()).append("\n");
        }
        if (hasRight()) {
            right.inOrderTraversal(sb);
        }
    }

    /**
     * Checks if the tree is height-balanced.
     * A tree is balanced if the height difference between left and right subtrees
     * is at most 1 for all nodes.
     * 
     * @return true if the tree is balanced, false otherwise
     */
    public boolean isBalanced() {
        return checkHeight() != -1;
    }

    /**
     * Computes the height of the tree, returning -1 if unbalanced.
     * 
     * @return Height of the tree, or -1 if unbalanced
     */
    private int checkHeight() {
        if (person == null && !hasLeft() && !hasRight()) {
            return 0;
        }

        int leftHeight = hasLeft() ? left.checkHeight() : 0;
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = hasRight() ? right.checkHeight() : 0;
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}