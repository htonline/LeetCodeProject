package algorithm;

import learning.BinaryTree;
import learning.BinaryTreeNode;

/**
 * @author Zuohaitao
 * @date 2023-04-17 13:52
 * @describe
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Solution_110 {
    public static boolean isBalanced(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public static int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,9,20,0,0,15,7};
        BinaryTreeNode root = new BinaryTree().createBinaryTreeByArr(arr);
        System.out.println(isBalanced(root));

    }
}
