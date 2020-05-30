public class Position {
	//instance variables
	private final int _row;
	private final int _col;

	//getters
	public int getRow() { return _row; }
	public int getCol() { return _col; }

	//constructor
	public Position(int r, int c) {
		_row = r;
		_col = c;
	}
}