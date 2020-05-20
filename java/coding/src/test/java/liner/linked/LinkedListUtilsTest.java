package liner.linked;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on 2020-05-19
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class LinkedListUtilsTest {
    SinglyLinkedList list = new SinglyLinkedList();

    @Before
    public void prepared() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < data.length; i++) {
            list.insertTail(data[i]);
        }
        LinkedListUtils.printAll(list.head);
        System.out.println("=====================================");
    }

    @Test
    public void test() {
        Node head = LinkedListUtils.inverseLinkedList(list.head);
        LinkedListUtils.printAll(head);
    }

    @Test
    public void test02() {
        boolean flag = LinkedListUtils.checkCircle(list.head);
        System.out.println(flag);
        Node node04 = list.findByValue(4);
        Node node08 = list.findByValue(8);
        node08.next = node04;
        flag = LinkedListUtils.checkCircle(list.head);
        System.out.println(flag);
    }

    @Test
    public void test03() {
        SinglyLinkedList list01 = new SinglyLinkedList();
        int[] data01 = {1, 3, 5, 7, 9};
        for (int i = 0; i < data01.length; i++) {
            list01.insertTail(data01[i]);
        }
        list01.printAll();

        SinglyLinkedList list02 = new SinglyLinkedList();
        int[] data02 = {2, 4, 6, 8, 10};
        for (int i = 0; i < data02.length; i++) {
            list02.insertTail(data02[i]);
        }
        list02.printAll();

        Node head = LinkedListUtils.combineSortedLinkedList(list01.head,list02.head);
        LinkedListUtils.printAll(head);
        System.out.println("=========================================");
        System.out.println(head);
    }

    @Test
    public void test04(){
        list.head = LinkedListUtils.deleteNthLastNode(list.head,1);
        list.printAll();
        System.out.println(list.head);
        System.out.println("========================================");
        list.head = LinkedListUtils.deleteNthLastNode(list.head,7);
        list.printAll();
        System.out.println(list.head);
        System.out.println("========================================");
        list.head = LinkedListUtils.deleteNthLastNode(list.head,8);
        list.printAll();
        System.out.println(list.head);
    }

    @Test
    public void test05(){
        Node middle = LinkedListUtils.findMiddleNode(list.head);
        System.out.println(middle);
        list.insertTail(9);
        middle = LinkedListUtils.findMiddleNode(list.head);
        System.out.println(middle);
    }
}
