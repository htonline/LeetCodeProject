package algorithm;

import learning.BinaryTree;
import learning.BinaryTreeNode;

/**
 * @author Zuohaitao
 * @date 2023-04-12 14:31
 * @describe
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution_104 {

    public static int maxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        // 根节点高度为1: 比较左子树和右子树的高度,取最大的
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,9,20,0,0,15,7};
        BinaryTreeNode root = new BinaryTreeNode(arr[0]);
        BinaryTree tree = new BinaryTree(root);
        for (int i = 1; i < arr.length; i++) {              // 满足左孩子小于根节点; 右孩子大于根节点
            tree.insert(arr[i]);                            // 看代码，是去掉了重复的元素
        }
        System.out.println(root.right.right.left.value);    // 7
        System.out.println(maxDepth(root));                 // 5
    }
}
