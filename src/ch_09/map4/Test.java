package ch_09.map4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    /* 아이디와 비밀번호 검사하기
    아이디 비번을 입력을 받아서 map에 저장된 값과 비교를 해서
    1) 동일한 아이디 비번이 있는 경우에는 "로그인되었습니다."
    2) 동일한 아이디가 있는데 비번이 틀릴 경우 "비밀번호가 일치하지 않습니다."
    3) 동일한 아이디가 없으면 "입력하신 아이디가 존재하지 않습니다." 가 출력되도록 하라
    4) 로그인을 성공할 때 까지 계속 로그인을 요청하도록 하라 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>(); // 키와 값으로 String 사용

        // 아이디, 비밀번호 미리 저장
        map.put("spring", "12");
        map.put("summer", "123");
        map.put("fall", "1234");
        map.put("winter", "12345");

        while (true) {
            System.out.println("아이디와 비밀번호를 입력해 주세요.");
            System.out.print("아이디 : ");
            String id = scanner.nextLine();
            System.out.println("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();

            boolean isLogin = false;
            boolean isNotPassword = false;

            for (String key : map.keySet()) {
                String value = map.get(key);
                if (id.equals(key) && password.equals(value)) { // 아이디, 비번 맞는 경우
                    System.out.println("로그인되었습니다.");
                    isLogin = true;
                    break; // for문 브레이크
                } else if (id.equals(key)) { // 아이디만 맞는 경우
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    isNotPassword = true;
                    break; // for문 브레이크
                }
            }
            if (isLogin) {
                break; // while문 브레이크
            } else if (!isNotPassword) {
                System.out.println("입력하신 아이디가 존재하지 않습니다.");
            }

        }
    }
}
