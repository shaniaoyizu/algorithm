package liner.array;

import org.junit.Test;

/**
 * Created on 2020-05-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class LRUBasedArrayTest {

    LRUBasedArray<Integer> lru = new LRUBasedArray<>();

    @Test
    public void test(){
        lru.printAll();
        System.out.println("===================================");
        lru.offer(1);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(2);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(3);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(4);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(5);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(6);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(5);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(6);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(7);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(8);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(3);
        lru.printAll();
        System.out.println("===================================");
        lru.offer(9);
        lru.printAll();
        System.out.println("===================================");
    }
}
