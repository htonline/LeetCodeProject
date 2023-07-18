package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-20 19:55
 * @describe
 * 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class Solution_27 {
    public static int removeElement(int[] num, int val) {
        int left = 0;
        int right = num.length;
        while (left < right) {
            if (num[left] == val) {
                num[left] = num[right - 1];
                right--;
            }
            else {
                left++;
            }
        }
        return left;

    }
    public static void main(String[] args) {
        int[] num = {3,2,2,3};
        int n = removeElement(num, 3);
        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
        System.out.println("长度是"+n);
    }
}
