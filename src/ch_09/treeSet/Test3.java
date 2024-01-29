package ch_09.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return (o1.compareTo(o2)) * -1; // String 클래스의 compareTo() 메서드를 반대로.
    }
}

public class Test3 {
    public static void main(String[] args) {
        // TreeSet 생성자에 Comparator를 구현한 객체를 매개변수로 전달함
        // String 클래스를 수정할 수 없으니 TreeSet 생성자에 넘김
        TreeSet<String> set = new TreeSet<>(new MyCompare());
        set.add("aaa");
        set.add("ccc");
        set.add("bbb");

        System.out.println(set);
    }
}
