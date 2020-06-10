package string;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created on 2020-06-05
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StringUtilsTest {

    @Test
    public void test01(){
        String s = "abcdefg";
        assertEquals("abfedcg",StringUtils.reverse(s,2,5));
        assertEquals("fedcbag",StringUtils.reverse(s,0,5));
        assertEquals("abgfedc",StringUtils.reverse(s,2,6));
    }

    @Test
    public void test02(){
        assertEquals(2,StringUtils.getRepeatCount("abc","dabcdeabcd"));
        assertEquals(2,StringUtils.getRepeatCount("ab","dabcdeabcd"));
        assertEquals(2,StringUtils.getRepeatCount("abcd","dabcdeabcd"));
        assertEquals(1,StringUtils.getRepeatCount("abcde","dabcdeabcd"));
    }

    @Test
    public void test03(){
        assertEquals("thrpriorityead",StringUtils.getMaxSameString("thrpriorityead","thrpriorityead"));
        assertEquals("priority",StringUtils.getMaxSameString("thrpriorityead","personpriorityfirst"));
    }
}
