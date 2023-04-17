package algorithm;

import learning.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zuohaitao
 * @date 2023-04-17 14:56
 * @describe
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution_102 {
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>(); // 存储当前行所包含的数
            int currentLevelSize = queue.size(); // 当前行所包含的数的个数（不能直接在for循环中写queue.size(), 因为后面会加，它会变）
            for(int i = 1; i <= currentLevelSize; i++) {
                BinaryTreeNode p = queue.poll();
                level.add(p.value);
                if(p.left != null) {
                    queue.offer(p.left);
                }
                if(p.right != null) {
                    queue.offer(p.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
