package liner.linked;

/**
 * Created on 2020-05-18
 *
 * @author sunbc
 * @Describe 单链表的插入、删除、查找操作
 * @since
 */
public class SinglyLinkedList {

    public Node head = null;

    /**
     * Finds the element in this list with the specified value
     *
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.val != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * Finds the element in this list with the specified position
     *
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    /**
     * Inserts the specified element into the head of this list
     *
     * @param newNode
     */
    public void insertHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Inserts the specified value into the head of this list
     *
     * @param value
     */
    public void insertHead(int value) {
        Node newNode = new Node(value);
        insertHead(newNode);
    }

    /**
     * Inserts the specified element into the tail of this list
     *
     * @param newNode
     */
    public void insertTail(Node newNode) {
        Node p = head;
        if (p == null) {
            head = newNode;
            return;
        }

        while (p.next != null) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * Inserts the specified value into the tail of this list
     *
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = new Node(value);
        insertTail(newNode);
    }

    /**
     * Inserts the specified element after the specified element of this list
     *
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * Inserts the specified value after the specified element of this list
     *
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value);
        insertAfter(p, newNode);
    }

    /**
     * Inserts the specified element before the specified element of this list
     *
     * @param p
     * @param newCode
     */
    public void insertBefore(Node p, Node newCode) {
        if (p == null) {
            return;
        }

        Node tmp = head;
        while (tmp != null && tmp.next != p) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }

        newCode.next = p;
        tmp.next = newCode;
    }

    /**
     * Inserts the specified value before the specified element of this list
     *
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value);
        insertBefore(p, newNode);
    }

    /**
     * Deletes the specified element from this list
     *
     * @param p
     */
    public void deleteByNode(Node p) {
        if (head == null) {
            return;
        }

        if (p == null) {
            return;
        }

        if (head == p) {
            head = head.next;
            return;
        }

        Node tmp = head;
        while (tmp != null && tmp.next != p) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        }

        tmp.next = p.next;
        p.next = null;
    }

    /**
     * Deletes the specified value from this list
     *
     * @param value
     */
    public void deleteByValue(int value) {
        Node p = findByValue(value);
        deleteByNode(p);
    }

    /**
     * Deletes all the specified value from this list
     *
     * @param value
     */
    public void deleteAllByValue(int value) {
        if (head == null) {
            return;
        }

        Node tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.next.val != value) {
                tmp = tmp.next;
                continue;
            }
            tmp.next = tmp.next.next;
        }

        if (head.val == value) {
            head = head.next;
        }
    }

    /**
     * Prints all node of this list
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * Whether the value of the two specified list in the same position is equal
     *
     * @param left
     * @param right
     * @return
     */
    public boolean isEqual(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        boolean flag = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                flag = false;
                break;
            }

            left = left.next;
            right = right.next;
        }

        if (!(left == null && right == null)) {
            flag = false;
        }

        return flag;
    }

    /**
     * Inverses the specified list
     *
     * @param p
     * @return
     */
    public static Node inverseLinkedList(Node p) {
        if (p == null) {
            return p;
        }

        Node prev = null;
        Node cur = p;
        while (p != null) {
            p = p.next;
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * Prints the specified list
     *
     * @param p
     */
    public static void printNodeList(Node p) {
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * Inverses this list until the specified element of this list
     *
     * @param p
     * @return
     */
    private Node inverseLinkedListUntil(Node p) {
        Node cur = head;
        Node prev = null;
        while (cur != p) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }

    /**
     * Whether this list is a palindrome
     *
     * @return
     */
    public boolean isPalindrome() {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node left;
        Node right;
        if (fast.next != null) {
            // the count of this list is odd number
            right = slow.next;
            left = inverseLinkedListUntil(slow);
        } else {
            // the count of this list is even number
            right = slow.next;
            left = inverseLinkedListUntil(slow).next;
        }
        return isEqual(left, right);
    }
}
