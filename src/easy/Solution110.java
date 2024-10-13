package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-10-13  18:50
 * @Description: Solution110
 * 110. ƽ�������
 * ����һ�����������ж����Ƿ���ƽ�������
 * ƽ������� ��ָ�������нڵ��������������������� 1��
 * @Version: 1.0
 */
public class Solution110 {
    public class TreeNode {
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

    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0; // �սڵ�߶�Ϊ 0
        }

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1; // ��������ƽ��

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1; // ��������ƽ��

        // ������������ĸ߶Ȳ�� 1����ƽ��
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // ��ʾ��ƽ��
        }

        return Math.max(leftHeight, rightHeight) + 1; // ���ص�ǰ�ڵ�ĸ߶�
    }

    public static void main(String[] args) {
        Solution110 solution = new Solution110();

        // ����һ��ʾ��������
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        root.right.right = solution.new TreeNode(6);

        // ���������Ƿ�ƽ��
        boolean balanced = solution.isBalanced(root);
        System.out.println("The binary tree is balanced: " + balanced);
    }
}
