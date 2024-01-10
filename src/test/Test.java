package test;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*
	    간단한 가위바위보 게임 프로그램을 작성하라.
	    1) 가위, 바위, 보는 각각 정수형 1, 2, 3으로 간주한다.
	    2) 컴퓨터가 제시할 가위바위보 데이터를 만든다.
	    다섯개의 정수를 저장할 수 있는 배열을 만들고 1, 2, 3 데이터를 섞어 초기화 한다.
	    /
	    3) 게임은 총 5회 진행하며, 컴퓨터는 배열 안 데이터를 차례대로 출력하는 것으로 한다.
	    4) 현재 횟수 / 총 횟수와 함께 입력 메시지를 출력한다.
	    5) 키보드로 1, 2, 3 중 하나를 입력하고, 컴퓨터와 키보드로 입력한 값을 비교하여 누가 이겼는지 알려준다.
	    6) 비긴 경우에는 횟수에 포함하지 않는다.
	    7) 게임을 종료하면 누가 이겼는지 표시한다.

	    1 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.1
	    가위입력하셨고, 컴은 가위입니다.비겼습니다.
	    1 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.1
	    가위입력하셨고, 컴은 가위입니다.비겼습니다.
	    1 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.1
	    가위입력하셨고, 컴은 가위입니다.비겼습니다.
	    1 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.2
	    바위입력하셨고, 컴은 가위입니다.사용자가 이겼습니다.
	    2 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.3
	    보입력하셨고, 컴은 바위입니다.사용자가 이겼습니다.
	    3 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.1
	    가위입력하셨고, 컴은 가위입니다.비겼습니다.
	    3 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.2
	    바위입력하셨고, 컴은 가위입니다.사용자가 이겼습니다.
	    4 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.3
	    보입력하셨고, 컴은 가위입니다.컴이 이겼습니다.
	    5 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.2
	    바위입력하셨고, 컴은 바위입니다.비겼습니다.
	    5 / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.1
	    가위입력하셨고, 컴은 바위입니다.컴이 이겼습니다.
	    게임 결과는 사용자가 이김
	     */
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            int temp = (int)(Math.random() * 3) + 1;
            numbers[i] = temp;
        }
        System.out.println(Arrays.toString(numbers));

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " / 5 입니다. 가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.");
            int answer = sc.nextInt();

            String hands;
            if (answer == 1) {
                hands = "가위";
            }else if (answer == 2) {
                hands = "바위";
            } else {
                hands = "보";
            }
            if (numbers[i] == answer) {
                System.out.println("비겼습니다.");
                i--;
            }else if (answer == 1) {  // 가위
               if (numbers[i] == 3) {
                   System.out.println(hands + "입력하셧고, 컴은 보입니다. 사용자가 이겼습니다.");
                   count++;
               }else {
                   System.out.println(hands + "입력하셧고, 컴은 바위입니다. 컴이 이겼습니다.");
               }
            }else if (answer == 2) {  // 바위
                if (numbers[i] == 1) {
                    System.out.println(hands + "입력하셧고, 컴은 가위입니다. 사용자가 이겼습니다.");
                    count++;
                }else {
                    System.out.println(hands + "입력하셧고, 컴은 보입니다. 컴이 이겼습니다.");
                }
            } else if (answer ==3) {  // 보
                if (numbers[i] == 2) {
                    System.out.println(hands + "입력하셧고, 컴은 바위입니다. 사용자가 이겼습니다.");
                    count++;
                }else {
                    System.out.println(hands + "입력하셧고, 컴은 가위입니다. 컴이 이겼습니다.");
                }
            }else {
                System.out.println("가위(1), 바위(2), 보(3)중 하나를 입력해 주십시요.");
                i--;
            }
        }

        if (count >= 3) {
            System.out.println("게임 결과는 사용자가 이김");
        }else {
            System.out.println("게임 결과는 컴퓨터가 이김");
        }
    }
}
