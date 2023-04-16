package org.example;

public class ListNodeTest {
    public static void main(String[] args) {
        // 创建第一个链表
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // 创建第二个链表
        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        l2.next.next.next.next = new ListNode(2);

        // 合并两个链表
        ListNode merged = mergeTwoLists(l1, l2);

        // 输出结果
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }

    // private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode dummy = new ListNode(-1); // 虚拟头节点，方便操作
    //     ListNode cur = dummy; //定义一个指针，用来遍历链表并添加元素
    //     while (l1 != null && l2 != null) {
    //         if (l1.val < l2.val) {
    //             cur.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             cur.next = l2;
    //             l2 = l2.next;
    //         }
    //         cur = cur.next;
    //     }
    //     cur.next = (l1 != null) ? l1 : l2;
    //     return dummy.next;
    // }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // 定义虚拟头结点
        ListNode cur = dummy; // 定义一个指针cur，用于遍历链表并添加元素
        while (l1 != null && l2 != null) { // 当l1和l2都不为空时，比较两个链表的当前节点的大小
            if (l1.val < l2.val) { // 如果l1的当前节点小于l2的当前节点
                cur.next = l1; // 将l1的当前节点添加到cur的next中
                l1 = l1.next; // l1指针指向下一个节点
            } else { // 如果l2的当前节点小于等于l1的当前节点
                cur.next = l2; // 将l2的当前节点添加到cur的next中
                l2 = l2.next; // l2指针指向下一个节点
            }
            cur = cur.next; // cur指向next节点
        }
        if (l1 != null) { // 如果l1不为空
            cur.next = l1; // 将l1的剩余元素添加到cur的next中
        } else { // 如果l2不为空
            cur.next = l2; // 将l2的剩余元素添加到cur的next中
        }
        return dummy.next; // 返回虚拟头结点的下一个节点，即为合并后的链表
    }


}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }


    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

}