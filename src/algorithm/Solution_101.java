package algorithm;

import learning.BinaryTreeNode;

/**
 * @author Zuohaitao
 * @date 2023-04-12 14:10
 * @describe
 * 给你一个二叉树的根节点 root ， 检查它是否`轴对称`。
 *
 */
public class Solution_101 {
    public boolean isSymmetricHelper(BinaryTreeNode a, BinaryTreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }
        if (a.value != b.value) {
            return false;
        }
        return (isSymmetricHelper(a.left, b.right) && isSymmetricHelper(a.right, b.left));
    }


    public boolean isSymmetric(BinaryTreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }
}
