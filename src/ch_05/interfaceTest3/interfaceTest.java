package ch_05.interfaceTest3;

interface Player {
    void play();
    void stop();
}

class VideoPlayer implements Player {
    private int id;
    private static int count = 0;

    public void VideoPlayer() {
        id = ++count;
    }

    @Override
    public void play() {
        System.out.println("비디오 재생시작!");
    }

    @Override
    public void stop() {
        System.out.println("비디오 재생시작!");
    }

    public void printInfo() {
        System.out.println("이 기계의 제조번호는 [" + id + "]입니다.");
    }
}

class CDPlayer implements Player {
    @Override
    public void play() {
        System.out.println("CD 재생시작!");
    }

    @Override
    public void stop() {
        System.out.println("CD 재생시작!");
    }

    public void cleaning() {
        System.out.println("헤드를 청소했습니다.");
    }
}


public class interfaceTest {
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new VideoPlayer();
        players[1] = new CDPlayer();

        for (Player player : players) {
            player.play();
            player.stop();
            System.out.println();
        }

        VideoPlayer[] videoPlayers = new VideoPlayer[4];
        for (int i = 0; i < videoPlayers.length; i++) {
            videoPlayers[i] = new VideoPlayer();
        }
        videoPlayers[videoPlayers.length - 1].printInfo();
    }

}
