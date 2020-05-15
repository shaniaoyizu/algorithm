package liner.linked;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created on 2020-05-13
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class PalindromeTest {

    ListNode head = new ListNode(1);


    /**
     * 奇数测试
     */
    @Before
    public void oddPrepare(){
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
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
        ListNode node = head;
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
