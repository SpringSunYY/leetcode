package linkedList;

import dataStructure.linearList.SequenceList;
//单向链表
import javax.xml.soap.*;
import java.util.Iterator;

public class LinkList<T>  implements Iterable<T> {
    public static void main(String[] args) {
        //创建数据表对象
        LinkList<String> sl = new LinkList<String>();
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

    private Node head;//记录头结点
    //记录链表的长度
    private int N;



    //结点类
    private class Node {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        //初始化头结点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear() {
        head.next = null;
        this.N = 0;
    }

    //获取链表长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取指定位置i的元素
    public T get(int i) {
        //通过循环，从头结点开始往后找，依次找i次，就能找到
        Node next = head.next;
        for (int index = 0; index < i; index++) {
            next = next.next;
        }

        return next.item;
    }

    //插入方法
    public void insert(T t) {
        //找到当前最后一个结点
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }

        //创建新结点
        Node nowNode = new Node(t, null);
        //让当前的最后一个节点指向新结点
        n.next = nowNode;

        //元素的个数+1
        N++;
    }

    //向指定i位置处添加元素
    public void insert(int i, T t) {
        //找到i位置前的一个结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新结点，并且新结点需要指向原来i位置的结点
        Node nowNode = new Node(t, curr);
        //原来i的位置前一个结点指向新结点即可
        pre.next=nowNode;
        //元素的个数+1
        N++;
    }

    //删除方法
    public T remove(int i){
        //找到i位置前的一个结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //找到前一个结点指向下一个结点
        Node nextNode = curr.next;
        //前一个结点指向下一个结点
        pre.next=nextNode;
        //元素个数-1
        N--;
        return curr.item;
    }

    //查找出元素在链表中第一次出现的位置
    public int indexOf(T t){
        //从头结点开始找
        Node n = head;
        for (int i = 0; n.next!=null; i++) {
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;

        public LIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
