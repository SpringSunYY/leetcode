package greenhand;

//326. 3 ����
/*
����һ��������дһ���������ж����Ƿ��� 3 ���ݴη�������ǣ����� true �����򣬷��� false ��
���� n �� 3 ���ݴη������㣺�������� x ʹ�� n == 3x
 */
public class IsPowerOfThree {
    public boolean anInt(int n){
    while (n != 0 && n % 3 == 0) {//����0�η�==0
        n /= 3;
    }
        return n==1;
    }
}
