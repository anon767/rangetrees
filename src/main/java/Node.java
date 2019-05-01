public class Node {
    int max; // for early returns

    private Interval interval;
    private Node left;
    private Node right;

    Node(Interval i) {
        this.interval = i;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    Interval getInterval() {
        return interval;
    }

    void setInterval(Interval interval) {
        this.interval = interval;
    }
}
