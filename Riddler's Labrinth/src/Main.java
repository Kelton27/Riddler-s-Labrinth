import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Main {
	//Instance variables
	public static String north = "NORTH";
	public static String south = "SOUTH";
	public static String east = "EAST";
	public static String west = "WEST";

	private static JPanel scene;

	//This method is called when the program runs and executes whatever is inside
	public static void main(String[] args) { LAB1();}

	//This method will try to play music and if it cannot play it will print out an error and continue with the rest of the game
	private static void playmusic(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);
			//new AudioSystem.getAudioFileFormat();
			if(musicPath.exists()){
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				//clip.loop(Clip.LOOP_CONTINUOUSLY);
				//JOptionPane.showMessageDialog(null,"Now playing:Funky Town");
			}
			else {
				System.out.println("File Not Found");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	//This method is basically the whole game and where everything is organised and used
	private static void LAB1() {
		//Instance variables
		final Question q = new Question();
		q.questionShuffle();
		q.postRandomQuestion();
		@SuppressWarnings("unused")
		final StringMap s = new StringMap();
		final JFrame fram = new JFrame();
		final Maze z = new Maze();
		final Player p = new Player(z);
		final Exit ex = new Exit();
		final Window _w = new Window();

		String name;
		Window.msg("You can move the player with either WASD or arrow keys");
		name = _w.in("What might your name be?");
		playmusic("gameMus.wav");
		Window.msg("\nI hope you enjoy the game "+name);
		Window.msg("You wake up, dazed, and on the ground");
		Window.msg("You remember that you were on your way somewhere, to someone, but have no other memories");
		Window.msg("You realize that you are not only in some kind of labyrinth, but wearing a full suit of armour with the name "+name+" scratched into it");
		Window.msg("Determined to figure out where and who you are, you start walking towards any exit in sight");

		fram.setVisible(true);
		fram.setSize(800,800);
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		scene = s.updateMap(p, z, q, "", _w, ex);
		fram.add(scene);
		fram.add(s.getMap());

		//This chunk of code "listens" to the keyboard for when keys are pressed and when
		// one is is will check which key is pressed and execute code based on which is pressed
		fram.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {

			int input = e.getKeyCode();
			if (input == KeyEvent.VK_W || input == KeyEvent.VK_UP) {
				scene = s.updateMap(p, z, q, north, _w, ex);
				fram.add(scene);
				fram.revalidate();
			} else if (input == KeyEvent.VK_S || input == KeyEvent.VK_DOWN) {
				 scene = s.updateMap(p, z, q, south, _w, ex);
				fram.add(scene);
				fram.revalidate();
			} else if (input == KeyEvent.VK_D || input == KeyEvent.VK_RIGHT) {
				 scene = s.updateMap(p, z, q, east, _w, ex);
				fram.add(scene);
				fram.revalidate();
			} else if (input == KeyEvent.VK_A || input == KeyEvent.VK_LEFT) {
				 scene = s.updateMap(p, z, q, west, _w, ex);
				fram.add(scene);
				fram.revalidate();
				}
			 else if(input == KeyEvent.VK_H) {
				Window.msg("You have reached the help screen");
				Window.msg("Controls: W - Moves player up by one place");
				Window.msg("A - Moves player left by one place");
				Window.msg("D - Moves player right by one place");
				Window.msg("S - Moves player down by one place");
				Window.msg("Objective: To complete the game you first have to kill the minotaur.");
			}
			 else if(input == KeyEvent.VK_T){
			 	System.out.println(p.getPosition().getRow());
				System.out.println(p.getPosition().getCol());
			}
			else if(input == KeyEvent.VK_Q){
				System.out.println(q.getQuestPos1().getRow());
				System.out.println(q.getQuestPos1().getCol());
			}
		}
	});
	fram.revalidate();
	}
}
