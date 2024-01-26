package ch_08.stack;

import java.util.ArrayList;

class Stack {
    private ArrayList<String> arrayStack = new ArrayList<>();

    public void push(String data) { // 스택의 맨 뒤에 요소를 추가
        arrayStack.add(data);
    }

    public String pop() { // 스택의 맨 위 객체를 가져옴. 객체를 스택에서 제거
        int len = arrayStack.size(); // 저장된 개수
        if (len == 0) {
            System.out.println("스택이 비었습니다.");
            return null;
        }
        return (arrayStack.remove(len - 1)); // 맨 뒤에 있는 자료 반환하고 배열에서 제거
    }

    public String peek() { // 스택에서 맨 위 객체를 가져옴. 객체를 제거하지 않음
        int len = arrayStack.size(); // 저장된 개수
        if (len == 0) {
            System.out.println("스택이 비었습니다.");
            return null;
        }
        return (arrayStack.get(len - 1)); // 맨뒤에 있는 자료 반환

    }
}

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.peek()); // C

        System.out.println(stack.pop()); // C
        System.out.println(stack.pop()); // B
        System.out.println(stack.pop()); // A
        System.out.println(stack.pop());
    }
}
