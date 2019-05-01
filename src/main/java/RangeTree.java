class RangeTree {
    private Node root;

    RangeTree() {
    }

    RangeTree(Node root) {
        this.root = root;
    }

    void insert(Interval i) {
        this.root = insert(this.root, i);
    }

    Interval overlapsAt(Interval i) {
        return searchOverlapIn(this.root, i);
    }

    /**
     * Checks if there is an Interval that overlaps with a given one.
     * First checks if root is null
     * Second if root interval overlaps with given one return root interval
     * Third if the left child's max is higher than the to be checked interval recurse
     * Fourth if the right child's max is higher than the to be checked interval recurse
     * Null otherwise
     *
     * @param root current root node
     * @param i    to be checked interval
     * @return
     */
    private static Interval searchOverlapIn(Node root, Interval i) {
        if (null == root) {
            return null;
        }
        if (root.getInterval().overlapsWith(i)) {
            return root.getInterval();
        }
        if (root.getLeft() != null && root.getLeft().max >= i.low) {
            return searchOverlapIn(root.getLeft(), i);
        }
        if (root.getRight() != null && root.getRight().max >= i.low) {
            return searchOverlapIn(root.getRight(), i);
        }
        return null;
    }

    /**
     * Adds a new Interval node to a Node
     * First: if root is null return a new node
     * Second: if given integer low is lower than current root low recurse left else recurse right
     * Eventually adjust max values
     * @param root
     * @param i
     * @return
     */
    private static Node insert(Node root, Interval i) {
        if (null == root) {
            return new Node(i);
        }
        int l = root.getInterval().low;
        if (i.low < l) {
            root.setLeft(insert(root.getLeft(), i));
        } else {
            root.setRight(insert(root.getRight(), i));
        }
        if (root.max < i.high) {
            root.max = i.high;
        }
        return root;
    }


}
