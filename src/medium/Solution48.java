package medium;

import java.util.ArrayList;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-10-07  19:19
 * @Description: Solution48
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @Version: 1.0
 */
public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        solution48.rotate(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}});
    }

    // 定义一个旋转函数，参数为一个二维数组matrix
    public void rotate(int[][] matrix) {
        // 创建一个ArrayList<Integer>，用于临时存储旋转后的元素
        ArrayList<Integer> tempList = new ArrayList<>();

        // 从二维数组的右下角开始遍历，将元素添加到tempList中
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int i1 = 0; i1 <= matrix[i].length - 1; i1++) {
                tempList.add(matrix[i][i1]);
            }
        }

        // 初始化当前要放置的元素在二维数组中的行号和列号
        int currentIndex = 0;
        int numLength = matrix[0].length;
        int current = 0;

        // 从tempList中取出元素，按照顺时针旋转90度的顺序放置到二维数组中
        for (int i = 0; i < tempList.size(); i++) {
            matrix[current][currentIndex] = tempList.get(i);
            current++;
            // 如果当前要放置的元素已经到达二维数组的最后一列，那么将current重置为0，并将currentIndex加1
            if (current >= numLength) {
                current = 0;
                currentIndex++;
            }
        }
    }




    public void rotate2(int[][] matrix) {
        int add = 0; // 用于记录每次旋转的元素个数
        int temp = 0; // 用于暂存旋转过程中的元素
        int pos1 = 0; // 记录旋转操作的起始行
        int pos2 = matrix[0].length - 1; // 记录旋转操作的起始列

        while (pos1 < pos2) { // 当起始行小于起始列时，执行旋转操作
            add = 0; // 将add置为0
            while (add < pos2 - pos1) { // 当add加到pos2 - pos1时，停止旋转
                temp = matrix[pos1][pos1 + add]; // 暂存matrix[pos1][pos1 + add]的值到temp
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1]; // 将matrix[pos1][pos1 + add]的值赋值为matrix[pos2 - add][pos1]
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 - add]; // 将matrix[pos2 - add][pos1]的值赋值为matrix[pos2][pos2 -add]
                matrix[pos2][pos2 - add] = matrix[pos1 + add][pos2]; // 将matrix[pos2][pos2 -add]的值赋值为matrix[pos1 + add][pos2]
                matrix[pos1 + add][pos2] = temp; // 将matrix[pos1 + add][pos2]的值赋值为temp
                add++; // add加1
            }
            pos1++; // 将pos1加1
            pos2--; // 将pos2减1
        }
    }

}
