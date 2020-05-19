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
public class SinglyLinkedListTest {

    SinglyLinkedList list = new SinglyLinkedList();

    /**
     * 奇数测试
     */
    @Test
    public void oddTest() {
//        int[] data = {1, 2, 3, 4, 3, 2, 1};
        int[] data = {1, 2, 3, 4, 3, 2, 2};
        for (int i = 0; i < data.length; i++) {
            list.insertHead(data[i]);
        }
        list.printAll();
        System.out.println(list.isPalindrome());
    }

    /**
     * 偶数测试
     */
    @Test
    public void evenTest() {
//        int data[] = {1,2,3,4,4,3,2,1};
        int data[] = {1, 2, 3, 4, 4, 3, 2, 2};
        for (int i = 0; i < data.length; i++) {
            list.insertHead(data[i]);
        }
        list.printAll();
        System.out.println(list.isPalindrome());
    }

    @Test
    public void test() {
        int[] data = {1, 2, 3, 4, 3, 2, 2};
        for (int i = data.length - 1; i >= 0; i--) {
            list.insertHead(data[i]);
        }
        list.printAll();
        System.out.println("findByValue:" + list.findByValue(1));
        System.out.println("findByValue:" + list.findByValue(6));
        System.out.println("findByIndex:" + list.findByIndex(2));
        System.out.println("findByIndex:" + list.findByIndex(10));
    }

    @Test
    public void test2() {
        int[] data = {1, 2, 3, 4};
        for (int i = data.length - 1; i >= 0; i--) {
            list.insertHead(data[i]);
        }
        list.printAll();
        list.insertTail(5);
        list.insertTail(6);
        list.printAll();
    }

    @Test
    public void test3() {
        int[] data = {1, 2, 3, 4};
        for (int i = data.length - 1; i >= 0; i--) {
            list.insertHead(data[i]);
        }
        list.printAll();
        list.insertBefore(list.findByValue(4), 5);
        list.insertBefore(list.findByValue(8), 10);
        list.printAll();
    }

    @Test
    public void test4() {
        int[] data = {1, 2, 3, 4};
        for (int i = data.length - 1; i >= 0; i--) {
            list.insertHead(data[i]);
        }
        list.printAll();
        list.insertAfter(list.findByValue(4), 5);
        list.insertAfter(list.findByValue(3), 6);
        list.insertAfter(list.findByValue(8), 10);
        list.printAll();
    }

    @Test
    public void test5() {
        int[] data = {1, 2, 3, 4, 3, 2, 3, 1, 2, 4};
        for (int i = data.length - 1; i >= 0; i--) {
            list.insertHead(data[i]);
        }
        list.printAll();
        System.out.println("======================================");
        list.deleteByValue(1);
        list.printAll();
        list.deleteAllByValue(1);
        list.printAll();
        System.out.println("======================================");
        list.deleteByValue(2);
        list.printAll();
        list.deleteAllByValue(2);
        list.printAll();
        System.out.println("======================================");
        list.deleteByValue(3);
        list.printAll();
        list.deleteAllByValue(3);
        list.printAll();
        System.out.println("======================================");
        list.deleteByValue(4);
        list.printAll();
        list.deleteAllByValue(4);
        list.printAll();
        System.out.println("======================================");
    }

    @Test
    public void test6() {
        int[] data = {1, 2, 3, 4};
        for (int i = data.length - 1; i >= 0; i--) {
            list.insertHead(data[i]);
        }
        list.printAll();
        Node node = SinglyLinkedList.inverseLinkedList(list.head);
        SinglyLinkedList.printNodeList(node);
    }
}
