package learning;

/**
 * @author Zuohaitao
 * @date 2023-04-11 20:21
 * @describe 定义一个二叉树的节点
 */
public class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
