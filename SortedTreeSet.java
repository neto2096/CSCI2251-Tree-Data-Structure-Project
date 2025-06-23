public class SortedTreeSet implements SortedTreeSetInterface {
    private Person person;
    private SortedTreeSet left;
    private SortedTreeSet right;
    private SortedTreeSet parent;

    public SortedTreeSet() {
        person = null;
        left = null;
        right = null;
        parent = null;
    }

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

    public SortedTreeSet getParent() {
        return parent;
    }

    @Override
    public void add(Person p) {
        if (p == null) {
            return;
        }

        if (person == null && !hasLeft() && !hasRight()) {
            person = p;
            return;
        }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String header = "Name\tHeight (cm)\tWeight (kg)\n";
        sb.append(header);
        inOrderTraversal(sb);
        return sb.toString();
    }

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

    public boolean isBalanced() {
        return checkHeight() != -1;
    }

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