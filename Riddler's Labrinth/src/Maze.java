public class Maze {

	//Instance variables
	private final boolean[][] _maze;
	private final Position[] posArr = { new Position(12, 12), new Position(12, 12), new Position(12, 12), new Position(12, 12) };
	private final Position _playerPos = this.posArr[((int)(Math.random() * 4.0D))];

	//getter to return the player position
	Position getStart() { return _playerPos; }

	//getter to return which maze is chosen
	public boolean[][] getMaze() { return _maze; }

	//This constructor has 5 mazes in it and can change to different ones for different levels when needed
	public Maze() {
		boolean[][] maze1 = {
				{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
				{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
				{true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
				{true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true},
				{true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true},
				{true, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, false, false, false, false, false, false, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, true, true, true, true, true, false, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, true, false, false, false, true, false, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, true, false, true, true, true, false, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, true, false, false, false, false, false, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, true, true, true, true, true, true, true, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, false, false, false, false, false, false, false, false, false, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true},
				{true, false, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true},
				{true, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true},
				{true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
				{true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
				{true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
				{true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
		};

		boolean[][] maze2 = {
				    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
					{true, false, false, false, false, false, false, false, false, false, false, true, true, false, true, false, false, false, false, false, false, false, false, false, true},
					{true, false, false, false, true, false, true, true, true, true, false, true, true, false, true, false, true, true, true, true, true, true, true, false, true},
					{true, false, true, true, true, false, true, false, false, false, false, false, true, false, true, false, true, false, false, false, false, false, true, false, true},
					{true, false, false, false, false, false, false, false, true, true, true, false, true, false, false, false, true, false, true, true, true, false, true, false, true},
					{true, false, true, false, true, false, true, false, true, false, true, false, false, false, false, true, true, false, false, false, true, false, true, false, true},
					{true, false, true, false, true, false, true, false, false, false, true, false, false, false, false, false, false, false, true, false, true, false, true, false, true},
					{true, false, false, false, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true},
					{true, false, true, true, true, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, true, false, false, false, true},
					{true, false, false, false, true, false, false, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, false, true, true},
					{true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, true},
					{true, false, true, true, true, false, true, false, false, true, true, true, true, false, false, false, true, false, true, true, true, true, true, true, true},
					{true, false, false, false, true, false, true, false, false, false, false, false, true, true, false, false, false, false, true, false, false, false, false, false, true},
					{true, false, true, false, true, true, true, false, true, true, true, false, true, false, false, true, false, false, true, false, true, true, true, false, true},
					{true, false, true, false, true, false, true, false, true, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true},
					{true, false, true, false, false, false, true, false, true, true, true, false, true, false, false, true, false, false, false, false, true, false, true, false, true},
					{true, false, false, false, true, false, true, false, false, false, true, false, true, true, false, true, true, true, false, false, true, true, true, false, true},
					{true, false, true, true, true, true, true, true, true, false, true, false, false, false, false, false, false, true, true, true, true, false, false, false, true},
					{true, false, true, false, false, false, false, false, true, false, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true},
					{true, false, false, false, true, true, true, false, true, false, false, false, false, true, false, true, true, true, true, true, true, false, true, false, true},
					{true, true, true, false, true, false, true, false, true, true, true, true, true, true, false, false, false, false, false, false, true, false, true, false, true},
					{true, false, true, false, true, false, false, false, false, false, false, false, false, false, false, true, false, true, true, false, true, false, false, false, true},
					{true, false, true, false, true, false, true, true, true, true, true, true, true, true, true, true, false, false, true, false, true, true, true, false, true},
					{true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
					{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
		};

		boolean[][] maze3 =
				{{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
						{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
						{true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
						{true, false, false, false, false, false, false, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, false, true},
						{true, true, true, true, true, true, false, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true},
						{true, false, false, false, false, false, false, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true},
						{true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true},
						{true, false, true, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, true, false, true, true, true, false, true},
						{true, false, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, false, false, false, true, true, true, false, true},
						{true, false, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, false, true},
						{true, false, true, true, true, true, false, false, false, false, false, false, false, true, true, true, false, true, true, true, true, true, true, false, true},
						{true, false, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, false, true},
						{true, false, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, false, false, false, false, false, false, false, true},
						{true, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
						{true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, true, true},
						{true, true, true, true, true, false, true, true, true, true, false, false, false, true, true, true, false, true, false, true, true, true, true, true, true},
						{true, true, true, true, true, false, false, false, true, true, false, true, false, true, true, true, false, true, false, true, true, true, true, true, true},
						{true, true, true, true, true, true, true, false, true, true, false, true, false, true, true, true, false, true, false, true, true, false, false, false, true},
						{true, false, false, false, false, false, false, false, true, true, false, true, false, false, false, false, false, true, false, true, true, false, true, false, true},
						{true, false, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, false, true, false, true},
						{true, false, false, false, false, false, false, false, true, true, false, true, true, true, true, true, true, true, false, true, true, false, true, false, true},
						{true, true, true, true, true, true, true, false, true, true, false, true, true, false, false, false, false, false, false, true, true, false, true, false, true},
						{true, true, true, true, true, true, true, false, false, false, false, true, true, false, true, true, true, true, true, true, true, false, true, false, false},
						{true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, true, true},
						{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}};
		
		boolean[][] maze4 = {
				{true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true}, 
				{true, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	true},
				{true, 	true, 	true, 	true, 	false, 	true, 	false, 	true, 	true, 	true},
				{true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
				{false,	false, 	false, 	true, 	true, 	false, 	false, 	true, 	false, 	true},
				{false, true, 	false, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
				{false,	true, 	false, 	true, 	true, 	false, 	false, 	false, 	false, 	true},
				{true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	false, 	true},
				{true, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	false, 	true},
				{true, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true},
		};
		
		boolean[][] maze5 = {
				{true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true}, 
				{true, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	true},
				{true, 	true, 	true, 	true, 	false, 	true, 	false, 	true, 	true, 	true},
				{true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
				{false,	false, 	false, 	true, 	true, 	false, 	false, 	true, 	false, 	true},
				{false, true, 	false, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
				{false,	true, 	false, 	true, 	true, 	false, 	false, 	false, 	false, 	true},
				{true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	false, 	true},
				{true, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	false, 	true},
				{true, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true},
		};

		_maze = maze3;
	}
}
