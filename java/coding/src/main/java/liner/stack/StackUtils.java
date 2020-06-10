package liner.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created on 2020-05-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StackUtils {
    /**
     * Checks if the string is valid
     * string only contains '(' ')'  '[' ']'  '{' '}'
     *
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {
        if (s == null || s.isEmpty() || s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }

            switch (s.charAt(i)) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Changes decimal to hex
     *
     * @param n
     * @return
     */
    public static String toHex(int n) {
        if (n == 0){
            return "0x0";
        }
        StringBuilder hex = new StringBuilder("0x");
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        Deque<Character> num = new LinkedList<>();
        while (n != 0) {
            num.push(chars[n%16]);
            n = n / 16;
        }
        while (num.size() > 0) {
            hex.append(num.poll());
        }
        return hex.toString();
    }
}
