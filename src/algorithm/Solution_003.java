package algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Zuohaitao
 * @date 2023-03-30 11:13
 * @describe
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 */
public class Solution_003 {

    public static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<Character>();
        int r = -1;
        int n = str.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
//              如果第一次之后循环到这了，说明有重复的字符
            if (i != 0) {
                set.remove(str.charAt(i-1));
            }


//            如果下一个存在(没超过n的长度) 且 集合中不包括它
//            不重复长度+1, r+1(继续往右移)
            while (r+1 < n && !set.contains(str.charAt(r+1))) {
                set.add(str.charAt(r+1));
                r++;
            }
//            如果重复了, 比较之前的最大长度, 取最大
            max = Math.max(max, r-i+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdafghemnca"));
    }

}
