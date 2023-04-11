package learning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zuohaitao
 * @date 2023-04-11 19:11
 * @describe 定义一个树节点
 */
public class TreeNode {
    int value;
    TreeNode parent;
    List<TreeNode> children;

//    构造一个树节点
    public TreeNode(int value, TreeNode parent) {
        this.value = value;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

//    添加孩子节点
    public void addChild(TreeNode child) {
        this.children.add(child);
    }
//    获取孩子节点
    public List<TreeNode> getChildren() {
        return this.children;
    }
//    获取父节点
    public TreeNode getParent() {
        return this.parent;
    }
//    获取值
    public int getValue() {
        return this.value;
    }
//    设置值
    public void setValue(int value) {
        this.value = value;
    }

}
