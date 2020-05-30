public class Player {
	//Instance variables
	private static Position _curPos;
	private boolean _isAlive = true;

	//This method will return the player's current position
	public Position getPosition() {
		return _curPos;
	}

	//Returns whether the player is alive or not
	public boolean isAlive() {
		return _isAlive;
	}

	//Sets the position of the player to the passed parameter
	public static void setPosition(Position p) {
		_curPos = p;
	}

	//kills the player
	public void killPlayer() {
		_isAlive = false;
	}

	//constructor
	public Player(Maze z) {
		_curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
	}

	//moves the player to the direction of the passed variable in the maze
	public boolean move(Direction d, Maze z) {
		if (d == Direction.North) {
			if (_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.South) {
			if (_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.East) {
			if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length
					&& !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
				return true;
			}
		} else {
			if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
				return true;
			}
		}
		return false;
	}
}
