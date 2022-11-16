package dataStructure.comparable.test;

import dataStructure.comparable.Student;

public class TestComparable {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(18);
        s1.setUsername("wangwu");

        Student s2 = new Student();
        s2.setAge(19);
        s2.setUsername("lisi");

        Comparable max = getMax(s1, s2);
        System.out.println("max = " + max);
    }

    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);  //>0 c1大 反之 =相等

        if (result>=0){
            return c1;
        }else {
            return c2;
        }
    }
}
