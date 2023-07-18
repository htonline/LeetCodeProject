package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-18 19:26
 * @describe
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution_014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String preFix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            preFix = longestCommonPrefix(preFix, strs[i]);
            if (preFix.length() == 0) {
                break;
            }
        }
        return preFix;


    }
    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }
}
