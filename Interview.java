package com.it.interview;

public class Interview {
    /**
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting besides each other.
     * Example:
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     *
     * @param input
     */
    public static void transformString(String input) {
        if (null == input || 3 > input.length()) {
            return;
        }
        char[] charArr = input.toCharArray();
        for (int i = 0; i < charArr.length && (i + 2) < charArr.length; i++) {
            if ('a' > charArr[i] || 'z' < charArr[i]) {
                System.out.println("error: input not between a ~ z");
                return;
            }
            if (charArr[i] == charArr[i + 1] && charArr[i] == charArr[i + 2]) {
                CharSequence sequence = input.subSequence(i, i + 3);
                String replace = input.replaceFirst(sequence.toString(), "");
                System.out.println(replace);
                transformString(replace);
            }
        }
    }

    /**
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * Example:
     * ccc -> b
     * bbb -> a
     * <p>
     * Input: abcccbad
     * Output:
     * -> abbbad, ccc is replaced by b
     * -> aaad, bbb is replaced by a
     * -> d
     *
     * @param input
     */
    public static void transformString2(String input) {
        if (null == input || 3 > input.length()) {
            return;
        }
        char[] charArr = input.toCharArray();
        for (int i = 0; i < charArr.length && (i + 2) < charArr.length; i++) {
            if ('a' > charArr[i] || 'z' < charArr[i]) {
                System.out.println("error: input not between a ~ z");
                return;
            }
            if (charArr[i] == charArr[i + 1] && charArr[i] == charArr[i + 2]) {
                CharSequence sequence = input.subSequence(i, i + 3);
                if ("aaa".equals(sequence)) {
                    String replace = input.replaceFirst(sequence.toString(), "");
                    System.out.println(replace);
                    transformString2(replace);
                    continue;
                }
                String c = String.valueOf((char) (input.charAt(i) - 1));
                String replace = input.replaceFirst(sequence.toString(), c);
                System.out.println(input + ", " + sequence + " is replaced by " + c);
                transformString2(replace);
            }
        }
    }

    public static void main(String[] args) {
        String input0 = "aabcccbbad";
        String input1 = "abcccbad";
        transformString(input0);
        transformString2(input1);
    }
}
