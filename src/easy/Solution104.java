package easy;

/**
 * Project: leetcode
 * Package: easy
 * Author: YY
 * CreateTime: 2024-12-11  18:36
 * Description: Solution104
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * 提示：
 * 树中节点的数量在 [0, 104] 区间内。
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
