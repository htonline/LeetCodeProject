package algorithm;

import learning.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zuohaitao
 * @date 2023-04-11 21:27
 * @describe 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 */
public class Solution_094 {

    /**
     * 递归实现中序遍历
     * @param node
     * @param res
     */
    public void inOrderHelper(BinaryTreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left, res);
        res.add(node.value);
        inOrderHelper(node.right, res);
    }

    /**
     * TODO: 迭代实现递归遍历
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderHelper(root, res);
        return res;
    }
}
