package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-20 19:11
 * @describe
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */

class ListNode {
    int val;
    ListNode next;
//    无参构造
    ListNode() {}
//    有参构造
    ListNode(int val) { this.val = val; }
//    全参构造？
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution_021 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(-1);
        ListNode p = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 == null ) {
            p.next = list2;
        } else {
            p.next = list1;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}







