package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-20 19:42
 * @describe
 * 删除有序数组中的重复项
 */
public class Solution_26 {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] == nums[i]) {
                continue;
            } else {
                nums[k+1] = nums[i];
                k++;
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,5};
        System.out.println(removeDuplicates(nums));
    }
}
