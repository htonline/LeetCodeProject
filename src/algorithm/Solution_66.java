package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-21 20:09
 * @describe
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Solution_66 {

    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        digits[index] = digits[index] + 1;
        while (digits[index] >= 10) {
            if (digits[0] == 10) {
                int[] newArr = new int[digits.length+1];
                for (int i = 2; i < newArr.length; i++) {
                    newArr[i] = digits[i-1];
                }
                newArr[0] = 1;
                newArr[1] = 0;
                digits = newArr;
                return digits;
            }
            digits[index] = 0;
            index--;
            digits[index] = digits[index] + 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        digits = plusOne(digits);
        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }

    }
}
