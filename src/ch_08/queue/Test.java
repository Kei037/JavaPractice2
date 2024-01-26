package ch_08.queue;

import java.util.LinkedList;

class MyQueue {
    private LinkedList<String> linkedList = new LinkedList<>();

    public void enQueue(String data) { // 큐의 맨 뒤에 추가
        linkedList.add(data);
    }

    public String deQueue() { // 큐의 맨 앞에서 꺼냄
        int len = linkedList.size();
        if (len == 0) {
            System.out.println("큐가 비었습니다.");
            return null;
        }
        return (linkedList.remove(0));
    }
}

public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        System.out.println(queue.deQueue()); // A
        System.out.println(queue.deQueue()); // B
        System.out.println(queue.deQueue()); // C
    }
}
