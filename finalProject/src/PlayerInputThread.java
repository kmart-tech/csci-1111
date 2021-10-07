import java.util.Scanner;

public class PlayerInputThread extends Thread {
    private Scanner input = new Scanner(System.in);
    private char key = 0;
    private volatile boolean running;

    public PlayerInputThread() {
        this.running = true;
    }

    public void terminate() {
        this.running = false;
    }

    public char getKey() {
        char temp = key;
        this.key = 0;
        return temp;
    }

    @Override
    public void run() {
        while (running) {
            key = input.next().charAt(0);
        }
    }
}
