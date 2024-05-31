package medium;

import java.util.List;

/**
 * @Description �������� �ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ��� ���� �ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * ����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
 * @ClassName Solution2
 * @Path medium
 * @Author YY
 * @Date 2024/4/14 17:06
 * @Version 1.0
 */
public class Solution2 {

    /**
     * ���ڽ�������ʾ�Ǹ�������������Ӳ����ؽ��������
     *
     * @param l1 ��һ������
     * @param l2 �ڶ�������
     * @return ��ʾ�͵�����
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ����һ������ͷ�ڵ�
        ListNode dummyHead = new ListNode(0);
        // ��ʼ������ָ��p��q���Լ����ڽڵ�curr
        ListNode p = l1, q = l2, curr = dummyHead;
        // ��ʼ����λcarryΪ0
        int carry = 0;
        // ѭ��ֱ������������ĩβ
        while (p != null || q != null) {
            // ��ȡ��ǰ�ڵ��ֵ������ڵ�Ϊ����ֵΪ0
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // ���㵱ǰ�ڵ�ĺ��Լ���λ
            int sum = carry + x + y;
            carry = sum / 10;
            // �����½ڵ㣬������ǰ�ڵ�ָ���½ڵ�
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // �ƶ�ָ�뵽��һ���ڵ�
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        // ������н�λ�������һ���½ڵ�
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        // ��������ͷ�ڵ����һ���ڵ㣬����Ӻ������ͷ�ڵ�
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
