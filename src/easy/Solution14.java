package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-08-17  16:56
 * @Description: Solution14
 * 14. �����ǰ׺
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��дһ�������������ַ��������е������ǰ׺��
 * <p>
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * ʾ�� 1��
 * ���룺strs = ["flower","flow","flight"]
 * �����"fl"
 * ʾ�� 2
 * ���룺strs = ["dog","racecar","car"]
 * �����""
 * ���ͣ����벻���ڹ���ǰ׺��
 * ��ʾ��
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] ����СдӢ����ĸ���
 * @Version: 1.0
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println( solution14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //���幫��ǰ׺
        String commonPre = strs[0];
        for (String str : strs) {
            //����������пգ��򷵻ؿ�
            if (str.length() == 0) {
                return "";
            }
            while (!str.startsWith(commonPre)) {
                commonPre = commonPre.substring(0, commonPre.length() - 1);
            }

        }
        return commonPre;
    }
}
