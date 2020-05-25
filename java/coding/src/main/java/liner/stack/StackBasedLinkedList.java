package liner.stack;

/**
 * Created on 2020-05-24
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StackBasedLinkedList<T> {
    /**
     * the head node of the stack
     */
    private SNode<T> top;
    /**
     * the data size of the stack
     */
    private int size;

    /**
     * the default constructor
     */
    public StackBasedLinkedList() {
        this.size = 0;
    }

    /**
     * Gets the data size of the stack
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Pushed the specified into the stack
     *
     * @param value
     * @return
     */
    public boolean push(T value) {
        if (value == null) {
            throw new RuntimeException("the stack is not supported null value");
        }
        SNode<T> node = new SNode(value);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
        return true;
    }

    /**
     * Removes the head node of the stack and returns it
     *
     * @return
     */
    public T pop() {
        if (size == 0) {
            return null;
        }
        SNode<T> cur = top;
        top = top.next;
        cur.next = null;
        size--;
        return cur.value;
    }

    /**
     * Returns the head node of the stack
     *
     * @return
     */
    public T peek() {
        if (size == 0) {
            return null;
        }
        return top.value;
    }

    /**
     * Clears up the stack
     */
    public void clear(){
        this.size = 0;
        top = null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        SNode<T> cur = top;
        StringBuilder str = new StringBuilder("[");
        while (cur.next != null) {
            str.append(cur.value + ",");
            cur = cur.next;
        }
        str.append(cur.value + "]");
        return str.toString();
    }

    private static class SNode<T> {
        T value;
        SNode<T> next;

        public SNode() {
            this(null);
        }

        public SNode(T value) {
            this(value, null);
        }

        public SNode(T value, SNode<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "SNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
