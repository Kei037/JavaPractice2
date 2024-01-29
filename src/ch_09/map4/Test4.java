package ch_09.map4;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompareInt implements Comparator<Integer> { // 내림차순
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2) * -1;
    }
}

public class Test4 {
    public static void main(String[] args) {
        TreeSet<Integer> lottos = new TreeSet<>(new MyCompareInt());

        while (lottos.size() <= 6) {
            int lotto = (int) (Math.random() * 44) + 1;
            if (lottos.contains(lotto)) {
                System.out.println(lotto + "는 중복된 번호입니다.");
                continue;
            }
            lottos.add(lotto);
        }

        System.out.println("Lotto : " + lottos);
    }
}
