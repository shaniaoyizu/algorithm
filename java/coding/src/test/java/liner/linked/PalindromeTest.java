package liner.linked;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on 2020-05-13
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class PalindromeTest {

    Node head = new Node(1);


    /**
     * 奇数测试
     */
    @Before
    public void oddPrepare(){
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
    }

    /**
     * 偶数测试
     */
//    @Before
    public void evenPrepare(){
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(4);
        Node node6 = new Node(3);
        Node node7 = new Node(2);
        Node node8 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
    }

    @Test
    public void test(){
        Node node = head;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(head));

        node = head;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
