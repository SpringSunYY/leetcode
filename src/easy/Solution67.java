package easy;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-09-28  19:36
 * @Description: Solution67
 * ���������������ַ��� a �� b ���Զ������ַ�������ʽ�������ǵĺ͡�
 * ʾ�� 1��
 * ����:a = "11", b = "1"
 * �����"100"
 * ʾ�� 2��
 * ���룺a = "1010", b = "1011"
 * �����"10101"
 * ��ʾ
 * 1 <= a.length, b.length <= 104
 * a �� b �����ַ� '0' �� '1' ���
 * �ַ���������� "0" ���Ͳ���ǰ����
 * @Version: 1.0
 */
public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        String s = solution67.addBinary("11", "11");
        System.out.println("s = " + s);
    }

    public String addBinary(String a, String b) {
        // ����һ��StringBuilder����ans�����ڴ洢������
        StringBuilder ans = new StringBuilder();
        // ��ʼ��һ����������ca�����ڴ洢��ǰλ�ϵĽ�λ
        int ca = 0;

        // ʹ��˫ָ��i��j���ַ���a��b��ĩβ��ʼ����
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            // ���㵱ǰλ�ϵ� sum����ʼֵΪ��λca
            int sum = ca;
            // ���i >= 0�����ַ���a�е�iλ�ϵ����ּӵ�sum��
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            // ���j >= 0�����ַ���b�е�jλ�ϵ����ּӵ�sum��
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            // ��sum��2ȡ�࣬���������ӵ�ans��
            ans.append(sum % 2);
            // �����µĽ�λca
            ca = sum / 2;
        }
        // ������һλ�ϵĽ�λΪ1������λ��ӵ�ans��
        ans.append(ca == 1 ? ca : "");
        // ��ans��ת����ת��Ϊʮ�����ַ�������
        return ans.reverse().toString();

    }
}
