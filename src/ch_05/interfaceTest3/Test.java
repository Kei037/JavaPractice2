package ch_05.interfaceTest3;


interface Skinnable {
    int BLACK = 0;
    int RED = 1;
    int GREEN = 2;
    int BLUE = 3;
    int LEOPARD = 4;

    void changeSkin(int skin);
}

class PortablePlayer implements Player, Skinnable {
    private int skin = BLACK;

    @Override
    public void play() {
        System.out.println("재생시작!");
    }

    @Override
    public void stop() {
        System.out.println("재생종료!");
    }

    @Override
    public void changeSkin(int skin) {
        System.out.print("스킨을 ");
        switch (skin) {
            case BLACK:
                System.out.print("검정");
                break;
            case RED:
                System.out.print("빨강");
                break;
            case GREEN:
                System.out.print("녹색");
                break;
            case BLUE:
                System.out.print("파랑");
                break;
            case LEOPARD:
                System.out.print("표범무늬");
                break;
            default:
                System.out.print("기본값");
                break;
        }
        System.out.println("(으)로 변경했습니다.");
    }
}

public class Test {
    public static void main(String[] args) {
        PortablePlayer player = new PortablePlayer();
        player.play();
        player.stop();
        player.changeSkin(Skinnable.LEOPARD);
    }
}
