package learning;

/**
 * @author Zuohaitao
 * @date 2023-04-11 14:38
 * @describe 链表节点
 */

public class ListNode {

    public Node head;

//    无参构造器, 创建一个空链表
    public ListNode() {
        this.head = null;
    }

//    在链表末尾添加节点(尾插法)
    public void append(int data) {
        Node newNode = new Node(data);  // 1.创建一个新节点

        if (this.head == null) {        // 2.如果当前链表的头节点为null, 则将新节点当作它的头节点
            this.head = newNode;
            return;
        }

        Node p = this.head;             // 3.如果链表不为空, 则需要遍历整个链表找到最后一个节点, 将新节点插入到它的后面.
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

//    在链表开头添加节点(头插法)
    public void head_insert(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

//    删除指定data的节点
    public void delete(int data) {

        if (this.head == null) {        // 1.如果链表为空, 返回
            return;
        }
        if (this.head.data == data) {   // 2.如果链表头节点为需要删除的节点
            this.head = this.head.next;
            return;
        }

        Node p = this.head;             // 3.循环遍历链表, 找到data的节点
        while (p.next != null){
            if (p.next.data == data) {
                p.next = p.next.next;   // 4.删除节点
                return;
            } else {
                p = p.next;
            }
        }
    }

//    遍历并打印链表
    public void printList() {
        Node p = this.head;
        while (p != null) {
            System.out.print(p.data + ", ");
            p = p.next;
        }
        System.out.println();
    }
}
