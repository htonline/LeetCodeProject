package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-04-14 14:26
 * @describe
 *
 * 给你两个字符串haystack 和 needle ，
 *
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 *
 * 如果needle 不是 haystack 的一部分，则返回 -1 。
 *
 */
public class Solution_028 {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                if (haystack.length() - i < needle.length()) break;
                boolean have = true;
                for(int j=i+1, k=1; k<needle.length(); k++, j++){
                    if(haystack.charAt(j)!=needle.charAt(k)) {
                        have=false;
                        break;
                    }
                }
                if(have) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = strStr("aaaa", "aaa");
        System.out.println(index);
    }

}
