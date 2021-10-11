import java.util.Scanner;

public class PlayerInputThread extends Thread {
    private final Scanner input = new Scanner(System.in);
    private String output = "x";
    private volatile boolean running;

    public PlayerInputThread() {
        this.running = true;
    }

    public void terminate() {
        this.running = false;
        input.close();
    }


    public String getString() {
        String temp = output;
        this.output = "x";
        return temp;
    }

    public int getInt() {
        int temp = -1;
        try {
            temp = Integer.parseInt(output);
        }
        catch (NumberFormatException ex){
            // do nothing
        }
        this.output = "x";
        return temp;
    }

    public char getChar() {
        char temp = output.charAt(0);
        this.output = "x";
        System.out.println("Get char called:" + output);
        return temp;
    }

    // another method to get just a char?

    @Override
    public void run() {
        while (running) {
            // maybe if the first char is a char then return that
            // and if the first char is an int then send the whole line?
            //if (input.hasNextLine()) {
                output = input.next();
             //   System.out.println("Input!");
            //}
        }
    }
}
