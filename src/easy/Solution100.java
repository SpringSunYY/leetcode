package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-10-13  18:41
 * @Description: Solution100
 * 100. ��ͬ����
 * �������ö������ĸ��ڵ� p �� q ����дһ���������������������Ƿ���ͬ��
 * ����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�
 * @Version: 1.0
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


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

}
