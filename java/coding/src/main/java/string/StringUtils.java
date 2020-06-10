package string;

/**
 * Created on 2020-06-05
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StringUtils {

    /**
     * Reverses the part of the specified string
     *
     * @param s
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String reverse(String s, int startIndex, int endIndex) {
        if (s == null || startIndex > endIndex || s.length() <= endIndex) {
            throw new RuntimeException("Illegal arguments");
        }

        StringBuilder sb = new StringBuilder(s.length());
        sb.append(s.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(endIndex + 1));
        return sb.toString();
    }

    /**
     * Determines the number of times one string appears in another string
     *
     * @param child
     * @param parent
     * @return
     */
    public static int getRepeatCount(String child, String parent) {
        if (child == null || parent == null || child.length() > parent.length()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        while ((index = parent.indexOf(child, index)) != -1) {
            count++;
            index += child.length();
        }
        return count;
    }

    /**
     * Gets the max same part between the two string
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String getMaxSameString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return null;
        }

        String minStr = s1.length() > s2.length() ? s2 : s1;
        String maxStr = s1.length() > s2.length() ? s1 : s2;

        int len = minStr.length();
        for (int i = 0; i < len; i++) {
            for (int start = 0, end = len - i; end <= len; start++, end++) {
                if (maxStr.contains(minStr.substring(start, end))) {
                    return minStr.substring(start,end);
                }
            }
        }
        return null;
    }
}
