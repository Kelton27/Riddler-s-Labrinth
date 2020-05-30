import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
    //Instance variables
    private static int interval;
    private static Timer timer;
    private static final Window w = new Window();

    //Method to make a timer to use in one of the punishments of the game
    public static void timer() {
        Scanner sc = new Scanner(String.valueOf(45));
        String secs = sc.nextLine();
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
               setInterval();
            }
        }, delay, period);
    }

    //this method decrements every time it is called and displays messages depending of the number it is on
    private static void setInterval() {
        if (interval == 45){
            Window.msg("You hear a faint voice telling you to leave");
        }
        if (interval == 40){
            Window.msg("The words 40 seconds left echo throughout labyrinth");
        }
        if (interval == 30){
            Window.msg("The words 30 seconds left echo throughout labyrinth");
        }
        if (interval == 20){
            Window.msg("The words 20 seconds left echo throughout labyrinth");
        }
        if (interval == 10){
            Window.msg("The words 10 seconds left echo throughout labyrinth");
        }
        if (interval == 5){
            Window.msg("The words 5 seconds left echo throughout labyrinth");
        }
        if (interval == 1) {
            Window.msg("The labyrinth has collapsed, burying you underneath the rubble" + "\n Never to be seen again");
            timer.cancel();
            System.exit(0);
        }
        --interval;
    }
}