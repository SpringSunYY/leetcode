package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-10-13  18:50
 * @Description: Solution110
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是平衡二叉树
 * 平衡二叉树 是指该树所有节点的左右子树的深度相差不超过 1。
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
            return 0; // 空节点高度为 0
        }

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1; // 左子树不平衡

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1; // 右子树不平衡

        // 如果左右子树的高度差超过 1，则不平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // 表示不平衡
        }

        return Math.max(leftHeight, rightHeight) + 1; // 返回当前节点的高度
    }

    public static void main(String[] args) {
        Solution110 solution = new Solution110();

        // 创建一个示例二叉树
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        root.right.right = solution.new TreeNode(6);

        // 检查二叉树是否平衡
        boolean balanced = solution.isBalanced(root);
        System.out.println("The binary tree is balanced: " + balanced);
    }
}
