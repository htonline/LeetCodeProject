package algorithm;

import learning.BinaryTreeNode;

/**
 * @author Zuohaitao
 * @date 2023-04-13 9:43
 * @describe
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 */
public class Solution_108 {

    /**
     * 题目分析: 比单纯给一个二叉搜索树, 把它变成平衡树要简单(1382.中等难度), for example:[1,null,2,null,3,null,4,null,null]
     * 数组已按照升序排列, 而二叉搜索树的中序遍历结果, 就是升序数组.
     *
     * 直观地看，我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 1 可以使得树保持平衡。
     * 如果数组长度是奇数,则根节点的选择是唯一的;
     * 如果数组长度是偶数,则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点;
     * 选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。
     */

    /**
     *
     * @param nums 二叉搜索树, 升序数组
     * @return 二叉搜索树的根节点
     */
    public static BinaryTreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static BinaryTreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;                              // 取中间值作为根节点, 如果是奇数, 就取左边的那个
        BinaryTreeNode p = new BinaryTreeNode(nums[mid]);
        p.left = helper(nums,l, mid-1);
        p.right = helper(nums, mid+1, r);
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        BinaryTreeNode root = sortedArrayToBST(nums);
        System.out.println(root.left.right.value);

    }

}
