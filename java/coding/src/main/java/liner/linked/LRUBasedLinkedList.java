package liner.linked;

/**
 * Created on 2020-05-20
 *
 * @author sunbc
 * @Describe LRU algorithm based linked list
 * @since
 */
public class LRUBasedLinkedList<T> {

    /**
     * the default capacity of the linked list
     */
    private static final int DEFAULT_CAPACITY = 1 << 3;

    /**
     * the head node of the linked list
     */
    private SNode<T> headNode;

    /**
     * the capacity of the linked list
     */
    private int capacity;

    /**
     * the node's size of the linked list
     */
    private int size;

    /**
     * the default constructor
     */
    public LRUBasedLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * @param capacity
     */
    public LRUBasedLinkedList(int capacity) {
        this(capacity, new SNode<>());
    }

    /**
     * @param capacity
     * @param headNode
     */
    public LRUBasedLinkedList(int capacity, SNode<T> headNode) {
        this.capacity = capacity;
        this.headNode = headNode;
        size = 0;
    }

    /**
     * Finds the previous node of the specified value in the linked list
     *
     * @param value
     * @return
     */
    private SNode findPreviousNode(T value) {
        if (value == null) {
            throw new RuntimeException("the cache is not supported null value");
        }
        SNode<T> p = headNode;
        while (p.next != null) {
            if (value.equals(p.next.value)){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * Puts the specified node at the head of the linked list
     *
     * @param node
     */
    private void cache(SNode node) {
        node.next = headNode.next;
        headNode.next = node;
        size++;
    }

    /**
     * Puts the specified node's next node at the head of the linked list
     *
     * @param prev
     */
    private void update(SNode prev) {
        SNode cur = prev.next;
        prev.next = prev.next.next;
        cur.next = headNode.next;
        headNode.next = cur;
    }

    /**
     * Deletes the last node of the linked list and puts the specified node
     * at the head of the linked list
     *
     * @param node
     */
    private void deleteCache(SNode node) {
        SNode cur = headNode;
        if (cur.next != null) {
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
        }
        node.next = headNode.next;
        headNode.next = node;
    }

    /**
     * Adds the specified value into the cache
     *
     * @param value
     */
    public void offer(T value) {
        SNode prev = findPreviousNode(value);
        if (prev == null) {
            if (capacity == size) {
                deleteCache(new SNode(value));
            } else {
                cache(new SNode(value));
            }
        } else {
            update(prev);
        }
    }

    /**
     * Prints all nodes of the linked list
     */
    public void printAll(){
        SNode cur = headNode.next;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
