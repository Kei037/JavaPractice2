package ch_04.abstractTest4;

/*
HttpServlet 추상 클래스와 LoginServlet, FileDownloadServlet 클래스가 있습니다.
메인 클래스와 출력결과를 보고 LogingServlet, FileDownloadServlet 클래스를 완성하세요.
출력결과)
로그인합니다.
파일 다운로드 합니다.
 */

abstract class HttpServlet {
    public abstract void service();
}

public class Ex_01 {
    public static void main(String[] args) {
        method(new LoginServlet());
        method(new FileDownloadServlet());
    }
    public static void method(HttpServlet servlet) {
        servlet.service();
    }
}
