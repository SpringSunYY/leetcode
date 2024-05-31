package medium;

import java.util.List;

/**
 * @Description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @ClassName Solution2
 * @Path medium
 * @Author YY
 * @Date 2024/4/14 17:06
 * @Version 1.0
 */
public class Solution2 {

    /**
     * 用于将两个表示非负整数的链表相加并返回结果的链表
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 表示和的链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点
        ListNode dummyHead = new ListNode(0);
        // 初始化两个指针p和q，以及当期节点curr
        ListNode p = l1, q = l2, curr = dummyHead;
        // 初始化进位carry为0
        int carry = 0;
        // 循环直到两个链表都到末尾
        while (p != null || q != null) {
            // 获取当前节点的值，如果节点为空则值为0
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // 计算当前节点的和以及进位
            int sum = carry + x + y;
            carry = sum / 10;
            // 创建新节点，并将当前节点指向新节点
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // 移动指针到下一个节点
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        // 如果还有进位，则添加一个新节点
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        // 返回虚拟头节点的下一个节点，即相加后的链表头节点
        return dummyHead.next;
    }

static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public static void main(String[] args) {
    ListNode listNode = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
    System.out.println("listNode = " + listNode);
}
}
