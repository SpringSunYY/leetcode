package linkedList;

import java.util.Iterator;

//双向链表
public class DoubleLinkedList <T> implements Iterable<T>{

    public static void main(String[] args) {
        //创建数据表对象
        DoubleLinkedList<String> sl = new DoubleLinkedList<String>();
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

        System.out.println("--------------");
        System.out.println("sl.getFirst() = " + sl.getFirst());
        System.out.println("sl.getLast() = " + sl.getLast());

        //测试清空
        sl.clear();
        System.out.println("sl.length() = " + sl.length());
    }

    //首结点
    private Node head;
    //最后一个结点
    private Node last;
    //链表的长度
    private int N;

    //结点类
    public class Node{
        public Node (T item, Node pre,Node next){
            this.item=item;
            this.pre=pre;
            this.next=next;
        }

        //存储元素
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个节点
        public Node next;
    }

    public DoubleLinkedList(){
        //初始化头结点和尾结点
        this.head=new Node(null,null,null);
        this.last=null;
        //初始化元素的个数
        this.N=0;
    }

    //清空链表
    public void clear(){
        last=null;
        head.next=last;
        head.pre=null;
        head.item=null;
        N=0;
    }

    //获取链表长度
    public int length() {
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取年表中的第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }//获取年表中的最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素t
    public void insert(T t){
        //如果链表为空
        if (isEmpty()){
            //如果链表为空
            //创建新的结点
            Node newNode = new Node(t, head, null);
            //让新结点成为尾结点
            last=newNode;
            //让头结点指向尾结点
            head.next=last;
        }else {
            //不为空
            //创建新的结点
            Node oldLast=last;
            Node newNode = new Node(t, oldLast, null);
            //让当前的尾结点指向新结点
            oldLast.next=newNode;
            //让新结点成为尾结点
            last=newNode;
        }
        //让元素个数n++
        N++;
    }

    //向指定位置i处插入元素t
    public void insert(int i,T t){
        if (i<0 || i>=N){
            throw new RuntimeException("位置不合法");
        }
        //找到位置i的前一个结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        //当前结点
        Node curr = pre.next;
        //构建新结点
        Node newNode = new Node(t, pre, curr);
        curr.pre= newNode;
        pre.next = newNode;
        //长度+1
        N++;
    }

    //获取指定位置i的元素
    public T get(int i){
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n=n.next;
        }

        return n.item;
    }

    //找到元素在链表中第一次出现的索引
    public int indexOf(T t){
        Node n = head;
        for (int j = 0; n.next != null; j++) {
            n=n.next;
            if (n.next.equals(t)){
                return j;
            }
        }
        return -1;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i){
        //找到i位置的结点
        Node pre=head;
        for (int index = 0; index < i; index++) {
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //找到i位置的下一个结点
        Node nextNode = curr.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        pre.next=nextNode;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        nextNode.pre=pre;

        //元素个数-1
        N--;
        return null;

    }
    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
        private Node n;
        public TIterator(){
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
