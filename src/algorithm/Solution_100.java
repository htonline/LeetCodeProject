package algorithm;

import learning.BinaryTree;
import learning.BinaryTreeNode;

/**
 * @author Zuohaitao
 * @date 2023-04-12 13:41
 * @describe
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 */
public class Solution_100 {
    public static boolean isSameTree(BinaryTreeNode a, BinaryTreeNode b) {

        if (a == null && b == null) {
            return true;
        }

        if ((a != null && b == null) || (a == null && b != null)) {
            return false;
        }
        if (a.value != b.value) {
            return false;
        }
        return (isSameTree(a.left, b.left) && isSameTree(a.right, b.right));
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3};
        int[] buf = {1,1,3};
        BinaryTreeNode aRoot = new BinaryTreeNode(arr[0]);  // 造树A的根节点aRoot
        BinaryTree aTree = new BinaryTree(aRoot);
        BinaryTreeNode bRoot = new BinaryTreeNode(buf[0]);  // 造树B的根节点bRoot
        BinaryTree bTree = new BinaryTree(bRoot);

        for (int i = 1; i < arr.length; i++) {              // 造树A
            aTree.insert(arr[i]);
        }
        for (int i = 1; i < buf.length; i++) {              // 造树B
            bTree.insert(buf[i]);
        }
        System.out.println(isSameTree(aRoot, bRoot));       // 传参数还是传根节点

    }
}
