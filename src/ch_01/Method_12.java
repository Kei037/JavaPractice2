package ch_01;

import java.util.Arrays;
import java.util.Scanner;

public class Method_12 {

    static Scanner scanner = new Scanner(System.in);

    public static int[] inputStudentNum() {
        // 작성 위치. 학생수를 입력 받아서 배열 생성
        System.out.print("학생수 > ");
        int studentNum = scanner.nextInt();
        int[] scores = new int[studentNum];
        System.out.println(Arrays.toString(scores));
        return scores;
    }
    public static int[] inputScores(int[] scores) {
        // 작성 위치. 생성된 배열의 갯수 만큼 점수 입력
        for (int i = 0; i < scores.length; i++) {
            System.out.print("scores[" + i + "] > ");
            scores[i] += scanner.nextInt();
        }
        return scores;
    }
    public static int[] printScores(int[] scores) {
        // 작성 위치. 입력받은 배열의 값을 출력
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] : " + scores[i]);
        }
        return scores;
    }
    public static int[] printAnalysis(int[] scores) {
        // 작성 위치. 최고 점수, 평균 점수 출력
        int max = scores[0];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i]) {
                max = scores[i];
            }
            sum += scores[i];
        }
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + (double)(sum / scores.length));
        return scores;
    }
    public static boolean setRun(){
        return false;
    }

    public static void main(String[] args) {
        boolean run = true;
        int[] scores = null;
        while (run) {
            System.out.println("--------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("--------------------------------------------------------");
            System.out.print("선택 > ");
            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                scores = inputStudentNum();
            } else if (selectNo == 2) {
                inputScores(scores);
            } else if (selectNo == 3) {
                printScores(scores);
            } else if (selectNo == 4) {
                printAnalysis(scores);
            } else if (selectNo == 5) {
                run = setRun();
            }
        }
        System.out.println("프로그램 종료");
        scanner.close();
    }
}
