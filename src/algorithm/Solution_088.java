package algorithm;

import java.util.Arrays;

/**
 * @author Zuohaitao
 * @date 2023-04-11 15:50
 * @describe
 *
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 *
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 */
public class Solution_088 {
    /**
     * 方法一：直接合并后排序
     *     将nums2插入到nums1中, 然后对nums1进行排序.
     *     时间复杂度:O((m+n)log(m+n)): 排序序列长度为m+n;
     *     空间复杂度:O(log(m+n)): 套用快速排序;
     */
    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 方法二：双指针
     *   方法一没有利用数组已经被排序的性质;
     *   我们可以使用双指针方法, 将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果数组中
     *   时间复杂度: O(m+n) 指针移动单调递增，最多移动 m+n 次
     *   空间复杂度: O(m+n) 需要建立长度为m+n的中间数组
     */
    public static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int p = 0, q = 0, t = 0;
        while (p < m && q < n) {
            if (nums1[p] < nums2[q]) {
                temp[t++] = nums1[p++];
            } else {
                temp[t++] = nums2[q++];
            }
        }
        while (p < m) {
            temp[t++] = nums1[p++];
        }
        while (q < n) {
            temp[t++] = nums2[q++];
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 方法三: 逆向双指针
     * 方法二中，之所以要使用临时变量temp. 是因为如果直接合并到数组nums1中,可能会使nums1中的元素在取出来之前就被覆盖;
     * 方法三就是直接避免覆盖nums1中的元素, 即指针从后向前遍历, 每次取比较中的较大者, 放入nums1的最后面(nums1后半部分是空的)
     */
    public static void merge_3(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1, j = n-1, t = m+n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[t--] = nums1[i--];
            } else {
                nums1[t--] = nums2[j--];
            }
        }
//        如果是j<0, nums1已经符合条件了
        if (i < 0) {
            while (j >= 0) {
                nums1[t--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));

    }



    public static void main(String[] args) {
        int[] nums1 = {2,7,8,0,0,0};
        int[] nums2 = {1,5,6};
        int m = 3, n = 3;
//        merge_1(nums1,m,nums2,n);
        merge_3(nums1,m,nums2,n);


    }
}
