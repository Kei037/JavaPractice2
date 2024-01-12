package test;

public class Test2 {
    public int solution(int a, int b) {
        int answer = 0;

        String str_a = Integer.toString(a);
        String str_b = Integer.toString(b);
        String sum1 = str_a + str_b;

        int resultSum1 = Integer.valueOf(sum1);
        int resultSum2 = (Integer.valueOf(str_a) * Integer.valueOf(str_b)) * 2;

        if (resultSum1 >= resultSum2) {
            answer += resultSum1;
            return answer;
        } else {
            answer += resultSum2;
            return answer;
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int result = test2.solution(2, 91);
        System.out.println(result);
    }
}
