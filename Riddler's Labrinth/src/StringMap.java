import javax.swing.*;
import java.awt.*;

public class StringMap extends JFrame {
	//Instance variables
	private static final long serialVersionUID = 1L;
	private JPanel _map = new JPanel(new GridLayout(25, 25));
	private final JLabel[][] Maze = new JLabel[25][25];

	private boolean cnt = true;
	public JPanel getMap() {
		return _map;
	}

	private final Window w = new Window();
	private final Stopwatch timer = new Stopwatch();

	private final Icon wall = new ImageIcon(getClass().getResource("wall.png"));
	private final Icon frontp = new ImageIcon(getClass().getResource("frontp.png"));
	private final Icon floor = new ImageIcon(getClass().getResource("ground.png"));
	private final Icon exit = new ImageIcon(getClass().getResource("exit.png"));
	private final Icon question = new ImageIcon(getClass().getResource("question-mark.png"));
	private final Icon leftp = new ImageIcon(getClass().getResource("leftp.png"));
	private final Icon rightp = new ImageIcon(getClass().getResource("rightp.png"));
	private final Icon backp = new ImageIcon(getClass().getResource("backp.png"));
	private ImageIcon current = (ImageIcon) backp;

	//This is called anytime something in the game is changed and updates everything in it
	public JPanel updateMap(Player p, Maze z, Question q, String userIn, Window _w, Exit ex) {
		_map = new JPanel(new GridLayout(25, 25));
		if (userIn.equals("NORTH")) {
			if (!z.getMaze()[p.getPosition().getRow() - 1][p.getPosition().getCol()]) {
				current = (ImageIcon) backp;
				p.move(Direction.North, z);
				gameCheck(p, z, q, userIn, _w, ex);
			} else {
				Window.msg("You closely examined the wall");
			}
		} else if (userIn.equals("SOUTH")) {
			if (!z.getMaze()[p.getPosition().getRow() + 1][p.getPosition().getCol()]) {
				current = (ImageIcon) frontp;
				p.move(Direction.South, z);
				gameCheck(p, z, q, userIn, _w, ex);
			} else {
				Window.msg("You closely examined the wall");
			}
		} else if (userIn.equals("WEST")) {
			if (!z.getMaze()[p.getPosition().getRow()][p.getPosition().getCol() - 1]) {
				current = (ImageIcon) leftp;
				p.move(Direction.West, z);
				gameCheck(p, z, q, userIn, _w, ex);
			} else {
				Window.msg("You closely examined the wall");
			}
		} else if (userIn.equals("EAST")) {
			if (!z.getMaze()[p.getPosition().getRow()][p.getPosition().getCol() + 1]) {
				current = (ImageIcon) rightp;
				p.move(Direction.East, z);
				gameCheck(p, z, q, userIn, _w, ex);
			} else {
				Window.msg("You closely examined the wall");
			}
		}
		for (int r = 0; r < z.getMaze().length; r++) {
			for (int c = 0; c < z.getMaze()[r].length; c++) {
				//if userIn.equals("NORTH") move player r by - 1 if empty space above
				if (z.getMaze()[r][c]) {
					Maze[r][c] = new JLabel(wall);
					_map.add(Maze[r][c]);
				} else if (r == p.getPosition().getRow() && c == p.getPosition().getCol()) {
					Maze[r][c] = new JLabel(current);
					_map.add(Maze[r][c]);
				} else if (null!=q.getQuestPos1() && r == q.getQuestPos1().getRow() && c == q.getQuestPos1().getCol()) {
					Maze[r][c] = new JLabel(question);
					_map.add(Maze[r][c]);
				} else if (null!=q.getQuestPos2() && r == q.getQuestPos2().getRow() && c == q.getQuestPos2().getCol()) {
					Maze[r][c] = new JLabel(question);
					_map.add(Maze[r][c]);
				} else if (null!=q.getQuestPos3() && r == q.getQuestPos3().getRow() && c == q.getQuestPos3().getCol()) {
					Maze[r][c] = new JLabel(question);
					_map.add(Maze[r][c]);
				} else if (null!=q.getQuestPos4() && r == q.getQuestPos4().getRow() && c == q.getQuestPos4().getCol()) {
					Maze[r][c] = new JLabel(question);
					_map.add(Maze[r][c]);
				} else if (null!=q.getQuestPos5() && r == q.getQuestPos5().getRow() && c == q.getQuestPos5().getCol()) {
					Maze[r][c] = new JLabel(question);
					_map.add(Maze[r][c]);
				} else if (r == ex.getPosition().getRow() && c == ex.getPosition().getCol()) {
					Maze[r][c] = new JLabel(exit);
					_map.add(Maze[r][c]);
				} else {
					Maze[r][c] = new JLabel(floor);
					_map.add(Maze[r][c]);
				}
			}
		}
		return _map;
	}

	//This method is called every time the player moves and checks to see if they are on a question spot.
	//Will execute code depending on which question spot they are on
	private void gameCheck(Player p, Maze z, Question q, String userIn, Window _w, Exit ex) {
		if (null != q.getQuestPos1() &&  p.getPosition().getRow() == q.getQuestPos1().getRow() && p.getPosition().getCol() == q.getQuestPos1().getCol()) {
			if (q.randomQuestion()){
				q.killQues(1);
			}
		}
		if (p.getPosition().getRow() == 5 && p.getPosition().getCol() == 3) {
			if(cnt) {
				Stopwatch.timer();
				cnt = false;
			}
		}
        if (p.getPosition().getRow() == 9 && p.getPosition().getCol() == 6) {
            Window.msg("You notice question marks on the ground"+"\nIntrigued and curious, you continue towards one to see what it is");
        }
        if (p.getPosition().getRow() == 1 && p.getPosition().getCol() == 8) {
            Window.msg("The question marks seem to be a device of some sort to question you" + "\nThis all seems familiar, like you've been through this many times before");
        }
		if (null != q.getQuestPos2() &&  p.getPosition().getRow() == q.getQuestPos2().getRow() && p.getPosition().getCol() == q.getQuestPos2().getCol()) {
			if (q.randomQuestion()) q.killQues(2);
		}
		if (null != q.getQuestPos3() &&  p.getPosition().getRow() == q.getQuestPos3().getRow() && p.getPosition().getCol() == q.getQuestPos3().getCol()) {
			if (q.randomQuestion()) q.killQues(3);
		}
		if (null != q.getQuestPos4() &&  p.getPosition().getRow() == q.getQuestPos4().getRow() && p.getPosition().getCol() == q.getQuestPos4().getCol()) {
			if (q.randomQuestion()) q.killQues(4);
		}
		if (null != q.getQuestPos5() &&  p.getPosition().getRow() == q.getQuestPos5().getRow() && p.getPosition().getCol() == q.getQuestPos5().getCol()) {
			if (q.randomQuestion()) q.killQues(5);
		}
		if (p.getPosition().getRow() == ex.getPosition().getRow() && p.getPosition().getCol() == ex.getPosition().getCol()){
			Window.msg("You have escaped the labyrinth" + "\nBut this seems like the beginning of a long adventure ");
			System.exit(0);
		}
	}
}