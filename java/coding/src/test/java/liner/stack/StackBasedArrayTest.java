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
public class StackBasedArrayTest {
    StackBasedArray<Integer> stack = new StackBasedArray<>();

    @Before
    public void prepared() {
        System.out.println("stack's capacity is：" + stack.getCapacity());
        System.out.println("stack's data's size is：" + stack.getSize());
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            System.out.println(stack.toString());
            System.out.println("=============================================");
        }
        System.out.println("stack's capacity is：" + stack.getCapacity());
        System.out.println("stack's data's size is：" + stack.getSize());
    }

    @Test
    public void test(){
        stack.push(9);
    }

    @Test
    public void test02(){
        System.out.println(stack.peek());
        System.out.println("=============================================");
        while (stack.getSize() != 0){
            System.out.println(stack.pop());
        }
        System.out.println("=============================================");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    @Test
    public void test03(){
        System.out.println(stack.toString());
        stack.clear();
        System.out.println(stack.toString());
    }
}
