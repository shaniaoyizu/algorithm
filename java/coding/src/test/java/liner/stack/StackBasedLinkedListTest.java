package liner.stack;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on 2020-05-24
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StackBasedLinkedListTest {
    StackBasedLinkedList<Integer> stack = new StackBasedLinkedList<>();

    @Before
    public void prepared() {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            System.out.println(stack.toString());
            System.out.println("=============================================");
        }
    }

    @Test
    public void test() {
        int size = stack.getSize();
        for (int i = 0; i <= size; i++) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.toString());
            System.out.println("=============================================");
        }
    }

    @Test
    public void test02(){
        System.out.println(stack.toString());
        stack.clear();
        System.out.println(stack.toString());
    }
}
