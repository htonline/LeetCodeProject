package algorithm;

import learning.BinaryTreeNode;

/**
 * @author Zuohaitao
 * @date 2023-04-17 19:18
 * @describe
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Solution_111 {

    public int minDepth(BinaryTreeNode root) {
        // 1.当前节点 root 为空时，说明此处树的高度为 0，0 也是最小值
        if (root == null) {
            return 0;
        }
        // 2.当前节点 root 的左子树和右子树都为空时，说明此处树的高度为 1，1 也是最小值
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 3.如果为其他情况，则说明当前节点有值，且需要分别计算其左右子树的最小深度，返回最小深度 +1，+1 表示当前节点存在有 1 个深度
        int minValue = Integer.MAX_VALUE;
        if (root.left != null) {
            minValue = Math.min(minDepth(root.left), minValue);
        }
        if (root.right != null) {
            minValue = Math.min(minDepth(root.right), minValue);
        }
        return minValue + 1;
    }

}
