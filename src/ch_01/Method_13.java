package ch_01;

import java.util.Scanner;

public class Method_13 {

    public static boolean login(String id, String passwd) {
        if (id.equals("admin") && passwd.equals("1234")) {
            return true;
        }else {
            return false;
        }
    }
    public static void logout() {
        System.out.println("admin 아이디가 로그아웃 되었습니다.");
    }

    public static void main(String[] args) {
        /*
        login() 메서드와 logout() 매서드를 선언.
        login() 메서드를 호출할 때는 매개값으로 id와 passwd를 제공하고,
        logout() 메서드는 id만 매개값으로 제공.

        1) login() 메서드는 매개값 id가 "admin", 매개값 password가 "1234"일 경우에만
        true로 리턴하고 그외의 값일 경우에는 false를 리턴.
        2) logout() 메서드는 "admin 아이디가 로그아웃 되었습니다."가 출력.
         */
        Scanner scanner = new Scanner(System.in);
        String id, password;
        System.out.print("아이디를 입력해 주세요. >> ");
        id = scanner.nextLine();
        System.out.print("비밀번호를 입력해 주세요. >> ");
        password = scanner.nextLine();

        boolean result = login(id, password); // true대신 login()호출;
        if (result) {
            System.out.println("로그인 되었습니다.");
            //logout() 호출;
            logout();
        }
        else {
            System.out.println("id 또는 password가 올바르지 않습니다.");
        }

        scanner.close();
    }
}
