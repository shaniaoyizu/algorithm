package liner.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created on 2020-05-15
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ArrayTest {
    Array data = new Array(10);

    @Before
    public void prepared(){
        data.addFirst(5);
        data.addFirst(4);
        data.addFirst(3);
        data.addFirst(2);
        data.addFirst(1);
    }

    @Test
    public void test(){
        System.out.println(data.add(5,1));
    }

    @Test
    public void test2(){
        System.out.println(data.findByIndex(4));
    }

    @Test
    public void test3(){
        System.out.println(data.deleteByIndex(3));
    }

    @Test
    public void test4(){
        System.out.println(data.delete(3));
    }

    @After
    public void after(){
        System.out.println(data);
    }
}
