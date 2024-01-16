package test.contactTest;

import test.contactTest.Contacts;

import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contacts[] contacts = new Contacts[100];

        System.out.println("연락처를 입력하시오(종료 -1)");
        for (int i = 0; i < contacts.length; i++) {
            System.out.println("이름과 전화번호 이메일을 입력하세요: ");
            String inputs = scanner.nextLine();
            if (!inputs.equals("-1")) {
                String[] datas = inputs.split(" ");
                //System.out.println(Arrays.toString(datas));
                contacts[i] = new Contacts(datas[0], datas[1], datas[2]);
                //System.out.println(contacts[i]);
                Contacts.count ++;
            }else {
                System.out.println("지인들의 수는 " + Contacts.count + "명입니다.");
                break;
            }
        }

        System.out.println("검색할 이름을 입력하세요: ");
        String findName = scanner.nextLine();
        // 같은 이름이 여러명 있을수 있다는 가정
        // case 1 배열 최대길이만큼 반복
        /*
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null && findName.equals(contacts[i].getName())) {
                System.out.println(contacts[i].getName() + "의 전화번호: " + contacts[i].getTel()
                + " 이메일: " + contacts[i].getEmail());
            }
        }

        // case 2 배열최대길이 반복으로 인한 개선 코드 / 저장된 데이터 개수보다 1번 더 반복
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (findName.equals(contacts[i].getName())) {
                    System.out.println(contacts[i].getName() + "의 전화번호: " + contacts[i].getTel()
                            + " 이메일: " + contacts[i].getEmail());
                }
            } else {
                break;
            }
        }
        */
        // case 3 저장된 갯수만큼 반복
        for (int i = 0; i < Contacts.count; i++) {
            if (findName.equals(contacts[i].getName())) {
                System.out.println(contacts[i].getName() + "의 전화번호: " + contacts[i].getTel()
                        + " 이메일: " + contacts[i].getEmail());
            }
        }

        scanner.close();
    }
}
