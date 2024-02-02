package ch_10.fileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        String path = "/Users/junyoung/IdeaProjects/JavaPractice2/sample_file/test";

        try(FileInputStream fileInputStream = new FileInputStream(path)) {
            System.out.println("지정한 경로에 파일이 존재합니다.");
        } catch (FileNotFoundException e) {
            System.out.println("지정한 경로에 파일이 존재하지 않습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
