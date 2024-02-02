package ch_10.fileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        // finally 를 사용하는 예
        // 디비나 파일의 경우 사용후에는 닫아줘야함.(close() 실행)
        String path = "./sample_file/test.txt"; // 이스케이프 문자 \를 사용하여 \\로 나타냄
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            System.out.println("지정한 경로에 파일이 존재합니다.");
        } catch (FileNotFoundException e) {
            System.out.println("지정한 경로에 파일이 존재하지 않습니다.");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {;}
                System.out.println("파일을 닫았습니다.");
            }
            System.out.println("자원을 해제하고 종료합니다.");
        }
    }
}
