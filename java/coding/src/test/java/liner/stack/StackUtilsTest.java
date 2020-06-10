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

    @Test
    public void test03(){
        System.out.println(StackUtils.toHex(16));
        System.out.println(StackUtils.toHex(19));
        System.out.println(StackUtils.toHex(250));
        System.out.println(StackUtils.toHex(256));
        System.out.println(StackUtils.toHex(290));
    }
}
