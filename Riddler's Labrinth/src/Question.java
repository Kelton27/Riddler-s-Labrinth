import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class Question {

	//instance variables
	private final ArrayList<Position> posLst = new ArrayList<Position>();
	private final ArrayList<Integer> nums = new ArrayList<Integer>();
	private int cnt = 12;

	private final Position zero = new Position(12,12);

	//adds all of the positions to the list of positions
	private void addNums() {
		posLst.add(new Position(10, 6));
		posLst.add(new Position(7, 10));
		posLst.add(new Position(7, 13));
		posLst.add(new Position(3, 13));
		posLst.add(new Position(3, 19));
		posLst.add(new Position(8, 19));
		posLst.add(new Position(8, 16));
		posLst.add(new Position(12, 16));
		posLst.add(new Position(12, 23));
		posLst.add(new Position(1, 23));
		posLst.add(new Position(1, 1));
		posLst.add(new Position(3, 1));
		posLst.add(new Position(3, 6));
		posLst.add(new Position(5, 6));
		posLst.add(new Position(5, 1));
		posLst.add(new Position(13, 5));
		posLst.add(new Position(16, 5));
		posLst.add(new Position(16, 7));
		posLst.add(new Position(18, 7));
		posLst.add(new Position(18, 1));
		posLst.add(new Position(20, 1));
		posLst.add(new Position(20, 7));
		posLst.add(new Position(22, 7));
		posLst.add(new Position(22, 10));
		posLst.add(new Position(15, 10));
		posLst.add(new Position(15, 2));
		posLst.add(new Position(18, 12));
		posLst.add(new Position(18, 16));
		posLst.add(new Position(14, 16));
		posLst.add(new Position(14, 18));
		posLst.add(new Position(21, 18));
		posLst.add(new Position(21, 13));
		posLst.add(new Position(23, 13));
		posLst.add(new Position(23, 21));
		posLst.add(new Position(17, 21));
		posLst.add(new Position(17, 23));
	}

	//Sets the position of the player to zero
	private void setZero(){
	    Player.setPosition(zero);
    }

    //Shuffles the questions
	public void questionShuffle() {
		addNums();
		Collections.shuffle(posLst);
	}

	//Gets the positions of the the questions
	public Position getQuestPos1() {
		return posLst.get(0);
	}

	public Position getQuestPos2() {
		return posLst.get(1);
	}

	public Position getQuestPos3() {
		return posLst.get(2);
	}

	public Position getQuestPos4() {
		return posLst.get(3);
	}

	public Position getQuestPos5() {
		return posLst.get(4);
	}

	//heavily disorients the player by switching the directions of the buttons every few seconds
	private static void switchUp() {
		for (int i = 0; i < 1; i++) {
			//Window.msg("switch time");
			Window.msg("You suddenly become heavily disoriented");
			Main.north = "EAST";
			Main.east = "SOUTH";
			Main.south = "WEST";
			Main.west = "NORTH";
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Window.msg("You seem to be unable to tell left from right");
					Main.north = "SOUTH";
					Main.east = "WEST";
					Main.south = "NORTH";
					Main.west = "EAST";
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							//Window.msg("switch time");
							Main.north = "WEST";
							Main.east = "NORTH";
							Main.south = "EAST";
							Main.west = "SOUTH";
							Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								@Override
								public void run() {
									//Window.msg("switch time");
									Main.north = "NORTH";
									Main.east = "EAST";
									Main.south = "SOUTH";
									Main.west = "WEST";
								}
							}, 15000);
						}
					}, 15000);
				}
			}, 15000);
		}
	}

	//picks a question depending on the number passed as a parameter
	private boolean questionPick(int s) {
		if (s == 0) {
			Window Msg = new Window();
			String b = Msg.in("Eliminate the pants or ill eliminate ____");
			if (b.equalsIgnoreCase("you")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				setZero();
				return true;
			}
		}
		if (s == 1) {
			Window Msg = new Window();
			String b = Msg.in("Either ______ the hoodies or i'll _____ you");
			if (b.equalsIgnoreCase("eliminate")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 2) {
			Window Msg = new Window();
			String b = Msg.in("Signing off with terra wolf ____");
			if (b.equalsIgnoreCase("howl")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 3) {
			Window Msg = new Window();
			String b = Msg.in("Oye____. -Escobedo");
			if (b.equalsIgnoreCase("meng")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				setZero();
				return true;
			}
		}
		if (s == 4) {
			Window Msg = new Window();
			String b = Msg.in("Hey player where's your ____. -Mr.Riley");
			if (b.equalsIgnoreCase("ID")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 5) {
			Window Msg = new Window();
			String b = Msg.in("Ugly ____ uniform pants. -Mr.Sirvin");
			if (b.equalsIgnoreCase("blue")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				setZero();
				return true;
			}
		}
		if (s == 6) {
			Window Msg = new Window();
			String b = Msg.in("Take out a sheet of _____. -Mr.Rico ");
			if (b.equalsIgnoreCase("paper")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 7) {
			Window Msg = new Window();
			String b = Msg.in("0.999 = ");
			if (b.equalsIgnoreCase("1")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 8) {
			Window Msg = new Window();
			String b = Msg.in("sin(pi/6)*[√4] + (3!)^2 - (46,656)^(1/3)");
			if (b.equalsIgnoreCase("1")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 9) {
			Window Msg = new Window();
			String b = Msg.in("1/2 + 1/4 + 1/8 + 1/16 + 1/32 + ____");
			if (b.equalsIgnoreCase("1")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		if (s == 10) {
			Window Msg = new Window();
			String b = Msg.in("A+B=___");
			if (b.equalsIgnoreCase("AB")) {
				Window.msg("correct");
				return true;
			} else {
				Window.msg("Incorrect");
				setZero();
				return true;
			}
		}
		if (s == 11) {
			Window Msg = new Window();
			String b = Msg.in("Rico's last name");
			if (b.equalsIgnoreCase("rico")) {
				Window.msg("correct");
				setZero();
				return true;
			} else {
				Window.msg("Incorrect");
				switchUp();
				return true;
			}
		}
		return true;
	}

	//destroys a question depending on the parameter passed
	public void killQues(int s){
		if (s==1) {
			posLst.set(0, new Position(0,0));
		}
		if (s==2) {
			posLst.set(1, new Position(0,0));
		}
		if (s==3) {
			posLst.set(2, new Position(0,0));
		}
		if (s==4) {
			posLst.set(3, new Position(0,0));
		}
		if (s==5) {
			posLst.set(4, new Position(0,0));
		}
	}

	//adds 12 elements to the number list
	public void postRandomQuestion(){
		nums.add(0,1);
		nums.add(1,2);
		nums.add(2,3);
		nums.add(3,4);
		nums.add(4,5);
		nums.add(5,6);
		nums.add(6,7);
		nums.add(7,8);
		nums.add(8,9);
		nums.add(9,10);
		nums.add(10,11);
		nums.add(11,12);
	}

	//picks a random question the removes it from the list
	public boolean randomQuestion(){
		int ran =((int) (Math.random() * cnt));
		questionPick(nums.get(ran));
		nums.remove(ran);
		cnt--;
		return true;
	}
}

