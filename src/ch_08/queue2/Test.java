package ch_08.queue2;

import java.util.LinkedList;
import java.util.Queue;

class Message {
    public String command;
    public String to;

    public Message(String command, String to) {
        this.command = command;
        this.to = to;
    }
}

public class Test {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "박성훈"));
        messageQueue.offer(new Message("sendKakaotalk", "홍두께"));

        while (!messageQueue.isEmpty()) { // 메시지 큐가 비었는지 확인
            Message message = messageQueue.poll(); // 메시지 큐에서 1개의 메시지 꺼냄
            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냈습니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS을 보냈습니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냈습니다.");
                    break;
            }
        }
    }
}
