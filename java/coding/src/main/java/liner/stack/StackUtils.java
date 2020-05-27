package liner.stack;

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

        Stack<Character> stack = new Stack<>();
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
}
