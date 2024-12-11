package easy;

/**
 * Project: leetcode
 * Package: easy
 * Author: YY
 * CreateTime: 2024-12-11  18:36
 * Description: Solution104
 * 104. ��������������
 * ����һ�������� root ��������������
 * �������� ������ ��ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 * ʾ�� 1��
 * ���룺root = [3,9,20,null,null,15,7]
 * �����3
 * ʾ�� 2��
 * ���룺root = [1,null,2]
 * �����2
 * ��ʾ��
 * ���нڵ�������� [0, 104] �����ڡ�
 * -100 <= Node.val <= 100
 * Version: 1.0
 */
public class Solution104 {
    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        int i = solution104.maxDepth(new TreeNode());
        System.out.println("i = " + i);
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
