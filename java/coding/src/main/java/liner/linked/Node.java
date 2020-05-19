package liner.linked;

/**
 * Created on 2020-05-18
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
