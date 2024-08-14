package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: leetcode
 * @Package: easy
 * @Author: YY
 * @CreateTime: 2024-08-14  15:12
 * @Description: Solution13
 * 13. ��������ת����
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * �������ְ������������ַ�: I�� V�� X�� L��C��D �� M��
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д�� II ����Ϊ�������е� 1 ��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV��
 * ���� 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��
 * ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
 * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 * X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
 * C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
 * ����һ���������֣�����ת����������
 * ʾ�� 1:
 * ����: s = "III"
 * ���: 3
 * ʾ�� 2:
 * ����: s = "IV"
 * ���: 4
 * ʾ�� 3:
 * ����: s = "IX"
 * ���: 9
 * ʾ�� 4:
 * ����: s = "LVIII"
 * ���: 58
 * ����: L = 50, V= 5, III = 3.
 * ʾ�� 5:
 * ����: s = "MCMXCIV"
 * ���: 1994
 * ����: M = 1000, CM = 900, XC = 90, IV = 4.
 * @Version: 1.0
 */
public class Solution13 {
    public int romanToInt(String s) {
        int total = 0; // ���ս��
        int prevValue = 0; // ��¼ǰһ���ַ�����ֵ

        // �����ұ����ַ���
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getValue(s.charAt(i));
            // �����ǰ�ַ�����ֵ����ǰһ���ַ�����ֵ�����ȥǰһ���ַ�����ֵ
            if (currentValue > prevValue) {
                total += currentValue - 2 * prevValue;
            } else {
                total += currentValue;
            }
            // ����ǰһ���ַ�����ֵ
            prevValue = currentValue;
        }

        return total;
    }

    private int getValue(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
    public static void main(String[] args) {
        Solution13 converter = new Solution13();
        // ʾ������
        System.out.println(converter.romanToInt("III"));    // ���: 3
        System.out.println(converter.romanToInt("IV"));     // ���: 4
        System.out.println(converter.romanToInt("IX"));     // ���: 9
        System.out.println(converter.romanToInt("LVIII"));  // ���: 58
        System.out.println(converter.romanToInt("MCMXCIV"));// ���: 1994
        System.out.println(converter.romanToInt("MCMXCIIV"));// ���: 1994
        System.out.println(converter.romanToInt("MCMXCIXV"));// ���: 1994
        System.out.println(converter.romanToInt("MCMXCIVA"));// ���: 1994
    }
}
