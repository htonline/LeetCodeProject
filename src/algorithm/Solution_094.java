package algorithm;

import learning.BinaryTree;
import learning.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Zuohaitao
 * @date 2023-04-11 21:27
 * @describe 给定一个二叉树的根节点 root ，返回 它的 中序 遍历
 */
public class Solution_094 {

    /**
     * 递归实现中序遍历
     * @param node 树节点
     * @param res 存储中序遍历后的结果数组
     */
    public static void inOrderHelper_recurrence(BinaryTreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inOrderHelper_recurrence(node.left, res);
        res.add(node.value);
        inOrderHelper_recurrence(node.right, res);
    }

    /**
     * 迭代实现递归遍历
     * @param root 根节点
     * @param res 中序遍历后的结果数组
     */
    public static void inOrderHelper_iteration(BinaryTreeNode root, List<Integer> res) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {                        // 如果p不为空, 则一直访问它的左子树
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();                        // 取出最后入栈的树节点
            res.add(p.value);                       // 将它的值存入结果数组(相当于输出)
            p = p.right;                            // 访问它的右子树
        }
    }

    /**
     * 中序遍历
     * @param root 根节点
     * @return 返回中序遍历后的结果数组
     */
    public static List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderHelper_iteration(root, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3};
        BinaryTreeNode root = new BinaryTreeNode(arr[0]);   // 将数组第一个元素变成叶子节点
        BinaryTree binaryTree = new BinaryTree(root);       // 将第一个叶子节点作为树的根节点
        for (int i = 1; i < arr.length; i++) {
            binaryTree.insert(arr[i]);
        }
        for (Integer node : inorderTraversal(root)) {
            System.out.print(node+", ");
        }
    }
}
