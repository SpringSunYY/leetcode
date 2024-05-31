package medium;

import java.util.LinkedHashSet;

/**
 * @Description ����һ���ַ��� s �������ҳ����в������ظ��ַ��� ��Ӵ��ĳ��ȡ�
 * ʾ�� 1:
 * ����: s = "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 * ʾ�� 2:
 * ����: s = "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 * ʾ�� 3:
 * ����: s = "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
 * ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 * @ClassName Solution3
 * @Path medium
 * @Author YY
 * @Date 2024/4/15 21:12
 * @Version 1.0
 */
public class Solution3 {
    public static void main(String[] args) {
//        System.out.println("lengthOfLongestSubstring(\"abcddcabcbbwafsgzsgdqwertyuiopasdfghj\") = "
//                + lengthOfLongestSubstring("abcddcabcbbwafsgzsgdqwertyuiopasdfghj"));
        System.out.println("dvdf "
                + lengthOfLongestSubstring("dvdf"));
        System.out.println("abcabcbb "
                + lengthOfLongestSubstring("abcabcbb"));

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        int max = 0;
        int result = 0;
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (hashSet.add(charArray[i])) {    // add�ɹ�˵��û���ظ��ַ������Լ�����չ
                max += 1;
            } else {// addʧ��˵�����ظ��ַ�����Ҫ���˵���һ�����ظ���λ��
                hashSet = new LinkedHashSet<>(); // ���¿�ʼ����
                hashSet.add(charArray[index]); // ���˵���һ�����ظ���λ��
                result = Math.max(result, max); // ��¼��ǰ��󳤶�
                max = 1;    // ���¿�ʼ����
                i = index; // ���˵���һ�����ظ���λ��
                index += 1; // ������չ
            }
        }
        result = Math.max(max, result);
        return result;
    }
}
