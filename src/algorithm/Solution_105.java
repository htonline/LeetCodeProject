package algorithm;

import learning.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zuohaitao
 * @date 2023-04-17 15:21
 * @describe
 *
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 */
public class Solution_105 {
    private static Map<Integer, Integer> hashMap = new HashMap<>(); // 因为需要频繁找到值所对应的数组下标, 所以创建一个hashMap来存储;
    /**
     * 通过二叉树先序数组和中序数组，构建二叉树
     * @param preorder  先序遍历数组
     * @param inorder   中序遍历数组
     * @return 二叉树的根节点
     */
    public static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
//    找到先序遍历preorder中的根节点preorder_left
    public static BinaryTreeNode buildTreeHelper(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_right) {
            return null;
        }

//        1. 找到先序数组的第一个元素，它是根节点;
        BinaryTreeNode root = new BinaryTreeNode(preorder[preorder_left]);
//        2. 在中序数组中找到根节点的下标
        Integer root_inorder_index = hashMap.get(preorder[preorder_left]);
//        3. 中序数组中，根节点左边的元素，都是左子树; 根节点右边的元素，都是右子树
        Integer root_left_size = root_inorder_index - inorder_left;
//        4. 在先序数值中，都是先访问完左子树，再访问右子树; 所以3中的个数，在这里也适用; 中序遍历中，对应的是数组是从最左边到根节点-1
        root.left = buildTreeHelper(preorder, inorder, preorder_left+1, preorder_left+root_left_size, inorder_left, root_inorder_index - 1);
        root.right = buildTreeHelper(preorder, inorder, preorder_left+root_left_size+1, preorder_right, root_inorder_index+1, inorder_right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BinaryTreeNode root = buildTree(preorder, inorder);
    }
}
