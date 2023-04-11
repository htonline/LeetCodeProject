package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zuohaitao
 * @date 2023-04-11 13:23
 * @describe
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */
public class Solution_001 {

    /**
     *
     * @param nums 整数数组
     * @param target 目标值
     * @return int[] 和为目标值的两个整数, 所对应的数组下标
     * 1. 建立一个HashMap<key, value>, 存数组nums的值和对应的数组下标index;
     * 2. 循环遍历nums;
     * 3. 如果当前遍历的数, 与hashMap中包含的某个数, 和为target; 则获取hashMap中那个数对应的下标value, 并将它与当前的下标一起返回;
     * 4. 否则, 将当前遍历的数存入hashMap;
     * 5. 时间复杂度: O(n); 空间复杂度: O(1);
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                int j = hashMap.get(target - nums[i]);
                return new int[]{j, i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int[] result = twoSum(nums, 9);
        for (int i : result) {
            System.out.println(i);
        }


    }

}
