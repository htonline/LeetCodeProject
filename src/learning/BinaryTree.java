package learning;

/**
 * @author Zuohaitao
 * @date 2023-04-11 20:23
 * @describe 定义一个二叉搜索树:
 *              1.非空左子树的所有键值小于其根结点的键值。
 *              2.非空右子树的所有键值大于其根结点的键值。
 *              3.左、右子树都是二叉搜索树。
 */
public class BinaryTree {

    BinaryTreeNode root; // 二叉树根节点

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 插入节点
     * @param value
     * 比父节点小的放左子树; 比父节点大的放右子树;
     */
    public void insert(int value) {
        root = insertHelper(root, value);
    }
//    从根节点开始往下找,  最后返回的也是根节点
    private BinaryTreeNode insertHelper(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }
        if (value < node.value) {
            node.left = insertHelper(node.left, value);     // 返回一个新的二叉树节点, 放在node的左/右子树上
        } else if (value > node.value) {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    /**
     * 通过数组,创建一棵树, 满足:下标i的元素,是下标为2i和2i+1的元素的父节点
     * 所以数组中第0个元素不能算数,第1个元素才是根节点;
     * @param arr
     * @return
     */
    public BinaryTreeNode createBinaryTreeByArr(int[] arr) {
        return createBinaryTreeByArrHelper(1, arr);
    }
    private BinaryTreeNode createBinaryTreeByArrHelper(int i, int[] arr) {
        if (i >= arr.length) {      // 叶子节点
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(arr[i]);     // 创建树节点
        node.left = createBinaryTreeByArrHelper(2*i, arr);       // 创建左孩子,并连接上
        node.right = createBinaryTreeByArrHelper(2*i+1, arr);    // 创建右孩子,并连接上
        return node;
    }


    /**
     * 查找节点
     * @param value
     * @return 返回空节点或要找的节点
     */
    public BinaryTreeNode search(int value) {
        return searchHelper(root, value);
    }
//    从根节点开始往下找,  返回空节点或要找的节点
    private BinaryTreeNode searchHelper(BinaryTreeNode node, int value) {
        if (node == null || node.value == value) {  //返回叶子节点或要找的节点
            return node;
        }
        if (value < node.value) {
            return searchHelper(node.left, value);  // 往左找
        } else {
            return searchHelper(node.right, value); // 往右找
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public void delete(int value) {
        root = deleteHepler(root, value);
    }
//    删除node树中,值为value的子节点
    private BinaryTreeNode deleteHepler(BinaryTreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteHepler(node.left, value);
        } else if (value > node.value) {
            node.right = deleteHepler(node.right, value);
        } else {
            // 当前节点是要删除的节点
            if (node.left == null && node.right == null) {            //叶子节点,直接删
                node = null;
            } else if (node.left == null) {                           // 还有右节点, 将右节点接上
                node = node.right;
            } else if (node.right == null) {                          // 还有左节点, 将左节点接上
                node = node.left;
            } else {                                                  // 还有左右子树
                BinaryTreeNode minNode = findMin(node.right);          // 找到右子树的最小节点(即右子树中的最左边的节点),
                node.value = minNode.value;                           // 将最小节点的值赋给当前节点,相当于用最小节点代替了当前节点
                node.right = deleteHepler(node.right, minNode.value); // 然后在当前节点的右子树中,删除这个最小节点
            }
        }
        return node;                                                  // 返回删除后的树, 也便递归调用删除操作的父节点,可以正确链接到新的子节点
    }
//    找到node树下的最小节点(即右子树中的最左边的节点)
    private BinaryTreeNode findMin(BinaryTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 前,中,后序遍历
     */
    public void preOrderTraversal() {
        preOrderHelper(this.root);
    }
    private void preOrderHelper(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }

    public void inOrderTraversal() {
        inOrderHelper(this.root);
    }
    private void inOrderHelper(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left);
        System.out.println(node.value + " ");
        inOrderHelper(node.right);
    }

    public void postOrderTraversal() {
        postOrderHelper(this.root);
    }
    private void postOrderHelper(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.println(node.value + " ");
    }






}
