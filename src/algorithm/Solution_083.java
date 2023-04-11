package algorithm;

import learning.ListNode;
import learning.Node;


/**
 * @author Zuohaitao
 * @date 2023-04-11 14:27
 * @describe
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */

public class Solution_083 {
    /**
     *
     * @param head 给定一个已排序的链表的头 head
     * @return 返回 已排序的链表(还是head头节点, 只不过删除了其中所有重复的元素) 。
     */
    public static Node deleteDuplicates(Node head) {

//        如果head为空或者只有一个元素, 则直接返回
        if (head == null || head.next == null) {
            return head;
        }

        Node p = head;
        Node q = p.next;
        while (q != null) {
            while (q != null && p.data == q.data) {
                q = q.next;
            }
            if (q == null) {                        // 如果q在第二个while循环中, 循环到末尾了, 则直接删掉p后面所有的节点,结束循环.
                p.next = null;
                break;
            }
            p.next = q;
            p = q;
            q = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        int[] nums = {1,1,2,2,3,5,6,8,9,9};
        for (int i : nums) {
            listNode.append(i);
        }
        listNode.head = deleteDuplicates(listNode.head);
        listNode.printList();

    }
}
