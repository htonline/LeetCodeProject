package algorithm;


/**
 * @author Zuohaitao
 * @date 2023-04-06 19:19
 * @describe 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class Solution_05 {

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }

        int maxPalindrome = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isPalindrome(str)) {
                    if (str.length() > maxPalindrome) {
                        maxPalindrome = str.length();
                        l = i;
                        r = j;
                    }
                }

            }
        }
        return s.substring(l, r);

    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));

    }
}
