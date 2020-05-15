package liner.linked;

import liner.array.GenericArray;
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
public class GenericArrayTest {

    GenericArray<String> strArray = new GenericArray<>();

    @Before
    public void prepared(){
        strArray.add("A");
        strArray.add("B");
        strArray.add("C");
    }

    @Test
    public void test(){
        System.out.println(strArray.isEmpty());
    }

    @Test
    public void test2(){
        System.out.println(strArray.getCapacity());
    }

    @Test
    public void test3(){
        System.out.println(strArray.count());
    }

    @Test
    public void test4(){
        System.out.println(strArray.contains("A"));
        System.out.println(strArray.indexOf("A"));
        System.out.println(strArray.contains("a"));
        System.out.println(strArray.indexOf("a"));
    }

    @Test
    public void test5(){
        System.out.println(strArray.add(0,"S"));
        System.out.println(strArray.add(5,"D"));
    }

    @Test
    public void test6(){
        strArray.set(1,"N");
        strArray.set(5,"F");
    }

    @Test
    public void test7(){
        System.out.println(strArray.get(2));
        System.out.println(strArray.get(5));
    }

    @Test
    public void test8(){
        System.out.println(strArray.remove(1));
        System.out.println(strArray.remove(2));
    }

    @Test
    public void test9(){
        System.out.println(strArray.remove("A"));
        System.out.println(strArray.remove("F"));
    }

    @After
    public void after(){
        System.out.println(strArray);
    }
}
