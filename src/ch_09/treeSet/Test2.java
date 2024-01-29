package ch_09.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompareInt implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2) * -1; // Integer 클래스의 compareTo() 메서드를 반대로.
    }
}

public class Test2 {
    public static void main(String[] args) {
        TreeSet<Integer> score = new TreeSet<>(new MyCompareInt());

        score.add(90);

        score.add(90);
        score.add(100);
        score.add(85);
        score.add(65);
        score.add(50);
        score.add(75);
        score.add(90);

        System.out.println(score); // 오름차순

        Integer value = null;

        value = score.first(); // first() 가장 작은 값 반환
        print("가장 낮은 점수", value);
        value = score.last(); // last() 가장 큰 값
        print("가장 높은 점수", value);

        value = score.lower(85); // lower() 제공된 값보다 작은 값 중 가장 큰 값 (인자값 미포함)
        print("85 바로 이전 점수", value);
        value = score.higher(85); // higher() 제공된 값보다 큰 값 중 가장 작은 값 (인자값 미포함)
        print("85 바로 다음 점수", value);

        value = score.floor(85); // floor() 제공된 값과 같거나 작은 값 중 가장 큰 값 (인자값 미포함)
        print("85 또는 바로 이전 점수", value);
        value = score.ceiling(85); // ceiling() 제공된 값보다 크거나 같은 값 중 가장 작은 값 (인자값 미포함)
        print("85 또는 바로 다음 점수", value);
    }

    public static void print(String s, Integer value) {
        System.out.println(s + " : " + value);
    }

}
