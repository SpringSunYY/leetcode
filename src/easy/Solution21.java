package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-06-01  17:37
 * @Description: Solution21
 * 21. �ϲ�������������
 * ��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 * @Version: 1.0
 */
public class Solution21 {
    public static void main(String[] args) {
        // ������������
        int[] list1Values = {1, 2, 4};
        int[] list2Values = {1, 3, 4};

        ListNode list1 = createList(list1Values);
        ListNode list2 = createList(list2Values);

        // ��ӡ��������
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);

        // �ϲ�����
        Solution21 solution = new Solution21();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // ��ӡ�ϲ��������
        System.out.print("Merged List: ");
        printList(mergedList);
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // �����ƽڵ㣬��Ϊ�������ͷ�ڵ�
        ListNode dummy = new ListNode();
        // ���ڸ�������������һ���ڵ�
        ListNode current = dummy;

        // �������������ȽϽڵ�ֵ�����ӽ�С�Ľڵ�
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // ����ʣ��δ�ľ���������
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // �����������ͷ�ڵ�
        return dummy;
    }

    // ��ӡ����
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // ��������������һ������
    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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
}
