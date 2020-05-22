package liner.linked;

/**
 * Created on 2020-05-19
 *
 * @author sunbc
 * @Describe 1) Inverses the singly linked list
 * 2) Checks whether the singly linked list has a circle
 * 3) Combines two sorted linked list and returns the head node
 * 4) Deletes the Nth last node of the linked list and returns the head node
 * 5) Finds the middle node of the linked list
 * @since
 */
public class LinkedListUtils {

    /**
     * Inverses the singly linked list
     *
     * @param head
     * @return
     */
    public static Node inverseLinkedList(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = null;
        Node next;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * Checks whether the singly linked list has a circle
     *
     * @param head
     * @return
     */
    public static boolean checkCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Combines two sorted linked list and returns the head node
     *
     * @param head01
     * @param head02
     * @return
     */
    public static Node combineSortedLinkedList(Node head01, Node head02) {
        Node list01 = head01;
        Node list02 = head02;
        if (list01 == null) {
            return list02;
        }
        if (list02 == null) {
            return list02;
        }

        Node soldier = new Node(0);
        Node cur = soldier;

        while (list01 != null && list02 != null) {
            if (list01.val >= list02.val) {
                cur.next = list02;
                list02 = list02.next;
            } else {
                cur.next = list01;
                list01 = list01.next;
            }
            cur = cur.next;
        }

        if (list01 == null){
            cur.next = list02;
        }
        if (list02 == null){
            cur.next = list01;
        }

        return soldier.next;
    }

    /**
     * Deletes the Nth last node of the linked list and returns the head node
     *
     * @param head
     * @return
     */
    public static Node deleteNthLastNode(Node head, int n) {
        Node fast = head;
        int i = 1;
        // the fast node goes n-1 steps ahead
        while (fast != null && i < n) {
            fast = fast.next;
            i++;
        }
        //the count of the linked list less then n
        if (fast == null) {
            return head;
        }

        Node slow = head;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;
    }

    /**
     * Finds the middle node of the linked list
     *
     * @param head
     * @return
     */
    public static Node findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * Prints all nodes of the linked list
     *
     * @param head
     */
    public static void printAll(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
