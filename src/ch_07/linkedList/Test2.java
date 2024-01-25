package ch_07.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/* ArrayList와 LinkedList의 실행 성능 비교
끝에서부터 (순차적으로) 추가 또는 삭제 하는 경우 ArrayList가 빠르지만
중간에 추가, 삭제하는 경우에는 앞 뒤 링크 정보만 변경하는 LinkedList가 더 빠름
ArrayList는 뒤족 인덱스들을 모두 1씩 증가 또는 감소 시키는 시간이 필요하므로 처리 속도가 느림 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();

        long startTime;
        long endTime;

        // 1. 중간에 추가하는 경우
        System.out.println("1. 중간에 추가하는 경우");
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간:  " + (endTime - startTime) + " ns"); // ArrayList 걸린시간: 430942100 ns

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간: " + (endTime - startTime) + " ns"); // LinkedList 걸린시간: 4545400 ns

        // 2. 끝에 순차적으로 추가하는 경우
        System.out.println("2. 끝에 순차적으로 추가하는 경우");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list1.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간:  " + (endTime - startTime) + " ns"); // ArrayList 걸린시간: 59945800 ns

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list2.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간: " + (endTime - startTime) + " ns"); // LinkedList 걸린시간: 170804100 ns
    }
}
