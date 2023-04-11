package learning;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zuohaitao
 * @date 2023-04-11 19:20
 * @describe 定义一个树
 */
public class Tree {
    TreeNode root;

//    构造器 new Tree();
    public Tree(TreeNode root) {
        this.root = root;
    }

//    深度优先遍历树(递归)
    public void depthFirstTraversal(TreeNode node) {
        System.out.println(node.getValue());
        for (TreeNode child : node.getChildren()) {     //拿到一个孩子节点后, 继续向下访问;
            depthFirstTraversal(child);
        }
    }
//    广度优先遍历树(队列)
    public void breadthFirstTraversal(TreeNode node) {
        /**
         * 常用的实现类包括LinkedList(基于链表节点)和ArrayDeque(基于数组)。支持在队列的两端添加和删除元素，而且由于它是基于数组实现的，因此在随机访问元素时也比较高效。
         * 与LinkedList相比，ArrayDeque通常具有更好的性能，
         *   1.因为它使用连续的内存块来存储元素，而LinkedList使用指针链接节点。
         *   2.此外，ArrayDeque还支持高效地在队列的两端进行添加和删除操作，而LinkedList则需要遍历整个链表才能删除尾部元素。
         *
         * 在Java中，ArrayDeque是线程不安全的，如果需要在多个线程中使用队列，可以考虑使用ConcurrentLinkedDeque等线程安全的队列实现类。
         *
         */
        Queue<TreeNode> queue = new LinkedList<>();

        /**
         * 与queue.add()方法类似. 但在插入元素时,如果队列已满, offer()会返回false; add()会抛出异常;
         */
        queue.offer(node);

        while (!queue.isEmpty()) {                      // 当队列不为空的时候
            TreeNode p = queue.poll();
            System.out.println(p.getValue());
            for (TreeNode child : p.getChildren()) {
                queue.offer(child);                     //拿到孩子节点,先存起来;然后按照入队顺序, 一个孩子节点一个孩子节点的访问
            }
        }
    }

//    查找节点(递归)
    public TreeNode searchNode(TreeNode node, int value) {

        if (node == null) {                                 // 遇到空节点
            return null;
        }
        if (node.getValue() == value) {                     // 找到要找的节点
            return node;
        }
        for (TreeNode child : node.getChildren()) {         // 深度优先遍历;
            TreeNode result = searchNode(child, value);     // 没找到, 会先往子节点去找;子节点遍历完,才会去兄弟节点
            if (result != null) {
                return result;                              // 递归的返回,是顺着函数一层层的返回
            }
        }
        return null;
    }

//    删除节点node(要用到的是被删除节点的父节点)
    public void deleteNode(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode parent = node.getParent();
        if (parent != null) {
            parent.getChildren().remove(node);                  // 从数组中删除一个元素
            /**
             * List接口定义了一个addAll()方法，它可以将另一个集合中的所有元素添加到当前集合中。在这里，parent.getChildren()和node.getChildren()都是List类型，
             * add()只能添加单个TreeNode; 现在是要添加List<TreeNode>, 不然就一个个循环add()了
             */
            parent.getChildren().addAll(node.getChildren());    // 接管被删除元素的所有孩子节点
            for (TreeNode child : node.getChildren()) {
                child.parent = parent;                          // 更改孩子节点的父节点
            }
        }
    }

//    修改节点node的值
    public void updateNode(TreeNode node, int value) {
        node.setValue(value);
    }

    /**
     * 示例用法
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null);  // 定义一个树的根节点
        Tree tree = new Tree(root);                         // 定义一棵树
        TreeNode node2 = new TreeNode(2, root);       // 定义一个孩子节点,其父节点是root
        TreeNode node3 = new TreeNode(3, root);

        root.addChild(node2);
        root.addChild(node3);

        TreeNode node4 = new TreeNode(4, node2);
        node2.addChild(node4);

        TreeNode node5 = new TreeNode(5, node3);
        node3.addChild(node5);

        tree.depthFirstTraversal(root);     // 深度优先遍历
        tree.breadthFirstTraversal(root);   // 广度优先遍历
        tree.searchNode(root, 4);     // 查找节点
        tree.deleteNode(node4);
        tree.updateNode(node5, 6);
    }
}
