package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-21 19:32
 * @describe
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 */
public class Solution_58 {


    public static int lengthOfLastWord(String s) {

        int n = s.length();
        int length = 0;
        boolean flag = false;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
                // 说明已经开始计数了
                flag = true;
            }
            if (flag && s.charAt(i) == ' ') {
                return length;
            }

        }
        return length;
    }

    public static void main(String[] args) {
        String s = "luffy is still joyboy  ";
        int n = lengthOfLastWord(s);
        System.out.println(n);

    }
}
