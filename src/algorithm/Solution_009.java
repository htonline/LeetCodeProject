package algorithm;

/**
 * @author Zuohaitao
 * @date 2022-09-06 10:47
 * @describe 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 *           回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Solution_009 {

    public static boolean isPalindrome(int x) {
        // 负数一定不是回文数
        // 类似10，200...这种，一定不是回文数。最高位是0的，只有0.
        // 0是回文数, 要特殊指定一下
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 反转一半的数字
        int reverseNum = 0;
        // 当反转数字>=原始数字时，说明我们已经反转了一半的数字了
        // 类似。当输入12321，循环停止时, reverseNum = 123，x = 12
        //       输入1221,循环停止时, reverseNum = 12，x = 12
        while (reverseNum < x) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        // 如果x时回文数，当x的长度时偶数位时, reverseNum == x;
        //             当x的长度是奇数位时, 处于中位的数字不影响回文，可以去掉。reverseNum/10 == x;
        if (reverseNum == x || reverseNum / 10 == x) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
