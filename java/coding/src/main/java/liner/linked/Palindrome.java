package liner.linked;

/**
 * Created on 2020-05-13
 *
 * @author sunbc
 * @Describe 一个字符串单链表，判读这个字符串是否是回文；并且保证算法的时间复杂度是O(n)，空间复杂度是O(1)
 * <p>
 * 思路：
 * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，
 * 同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
 * @since
 */

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return true;
        }

        /**
         * 运算过程中例外需要申请的3个空间
         */
        ListNode prev = null;
        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode slow = head;

        // 保证快指针走完链表
        while (fast != null && fast.next != null) {
            //快指针每次前进两步
            fast = fast.next.next;

            // slow指针指向逆转
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;

            //慢指针每次前进一步
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
