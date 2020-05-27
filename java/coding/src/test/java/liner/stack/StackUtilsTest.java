package liner.stack;

import org.junit.Test;

/**
 * Created on 2020-05-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StackUtilsTest {

    @Test
    public void test() {
        String s = null;
        System.out.println(StackUtils.checkValidString(s));
        s = "";
        System.out.println(StackUtils.checkValidString(s));
    }

    @Test
    public void test02() {
        String s = "()[]{}";
        System.out.println(s + "：" + StackUtils.checkValidString(s));
        s = "([)[]{}";
        System.out.println(s + "：" + StackUtils.checkValidString(s));
        s = "([])[]{}";
        System.out.println(s + "：" + StackUtils.checkValidString(s));
        s = "([])[[]{}";
        System.out.println(s + "：" + StackUtils.checkValidString(s));
    }
}
