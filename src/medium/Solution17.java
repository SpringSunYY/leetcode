package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: leetcode
 * @Package: medium
 * @Author: YY
 * @CreateTime: 2024-09-23  22:39
 * @Description: Solution17
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * �𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * ʾ�� 1��
 * ���룺digits = "23"
 * �����["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * ʾ�� 2��
 * ���룺digits = ""
 * �����[]
 * ʾ�� 3��
 * ���룺digits = "2"
 * �����["a","b","c"]
 * @Version: 1.0
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        // ���� letterCombinations ���������� "23"���������п��ܵ���ĸ���
        List<String> strings = solution17.letterCombinations("23");
//        // ��������ӡ���е���Ͻ��
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        List<String> strings1 = solution17.letterCombinations("233");
//        System.out.println("==================");
//        // ��������ӡ���е���Ͻ��
//        for (String string : strings1) {
//            System.out.println(string);
//        }
//        System.out.println("==================");
//        List<String> strings2 = solution17.letterCombinations("234");
//        // ��������ӡ���е���Ͻ��
//        for (String string : strings2) {
//            System.out.println(string);
//        }
    }

    // ���ڴ洢������б�
    ArrayList<String> res = new ArrayList<>();
    // ��������ĸ��ӳ���0 �� 1 ����Ӧ�κ���ĸ�����Էſ��ַ���
    String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // �����������������ַ�����Ӧ��������ĸ���
    public List<String> letterCombinations(String digits) {
        // ���������ַ���Ϊ�գ�ֱ�ӷ��ؿս��
        if (digits.isEmpty()) {
            return res;
        }
        // ���õݹ麯�����ӵ� 0 �����ֿ�ʼ����
        findCombination(digits, 0, new StringBuilder());
        // ���ؽ���б�
        return res;
    }

    // �ݹ麯��������������ĸ���
    private void findCombination(String digits, int index, StringBuilder sb) {
        // �ݹ���ֹ�����������ǰ����������Ѿ����������ַ����ĳ��ȣ�˵��������
        if (index == digits.length()) {
            // ����ǰ�����ӵ�����б���
            res.add(sb.toString());
            return;
        }

        // ��ȡ��ǰ������Ӧ�������ַ�
        char c = digits.charAt(index);
        // ���������ַ���ӳ�����ȡ����Ӧ����ĸ
        // c �� digits.charAt(index) ��ȡ��һ���ַ��������ַ� '2'��
        // �������� letterMap ��һ�����飬���������������������Ҫ���ַ� '2' ת��Ϊ��Ӧ������ 2��
        String letters = letterMap[c - '0'];
        // ���������ֶ�Ӧ��������ĸ
        for (int i = 0; i < letters.length(); i++) {
            // ����ǰ��ĸ��ӵ� StringBuilder �У����ݹ鴦����һ������
            findCombination(digits, index + 1, sb.append(letters.charAt(i)));
            // �ݹ鷵�غ�ɾ�������ӵ��ַ������ݵ�֮ǰ��״̬
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

