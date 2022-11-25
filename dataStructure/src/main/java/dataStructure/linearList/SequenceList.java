package dataStructure.linearList;

import java.util.Iterator;
import java.util.function.Consumer;

//顺序表代码
public class SequenceList<T> implements Iterable<T> {
    public static void main(String[] args) {
        //创建数据表对象
        SequenceList<String> sl = new SequenceList<String>(3);
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1, "詹姆斯");

        System.out.println("sl.length() = " + sl.length());

        //测试获取
        String getResult = sl.get(1);
        System.out.println("getResult = " + getResult);

        System.out.println("---------------");
        for (String s : sl) {
            System.out.println("s = " + s);
        }
    }

    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
        N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //获取指定位置的元素
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("当前元素不存在！");
        }
        return eles[i];
    }

    //向线型表中添加元素t
    public void insert(T t) {
        if (N == eles.length) {
            throw new RuntimeException("当前表已满");
        }
        eles[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(int i, T t) {
        if (N==eles.length){
            resize(2* eles.length);
        }

        if (i == eles.length) {
            throw new RuntimeException("当前表已满");
        }
        if (i < 0 || i > N) {
            throw new RuntimeException("插入的位置不合法");
        }
        //把i位置空出来，i位置及其后面的元素依次向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }
        //把t放到i位置处
        eles[i] = t;
        //元素数量+1
        N++;
    }

    //根据参数newSize，重置eles的大小
    public void resize(int newSize){
        //定义一个临时数组
        T[] temp=eles;
        //创建新数组
        eles= (T[]) new Object[newSize];

        //把原数组的数据拷贝到新数据
        for (int i = 0; i < N; i++) {
            eles[i]=temp[i];
        }
    }
    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        if (i < 0 || i > N - 1) {
            throw new RuntimeException("当前要删除的元素不存在");
        }
        //记录i位置处的元素
        T result = eles[i];
        //把i位置后面的元素都向前移动一位

        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }
        //当前元素数量-1
        N--;

        if (N< eles.length/4){
            resize(eles.length/2);
        }
        return result;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t) {
        if (t == null) {
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        //提供私有变量
        private int cur;

        public SIterator() {
            this.cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < N;
        }

        @Override
        public T next() {
            return eles[cur++];
        }
    }
}