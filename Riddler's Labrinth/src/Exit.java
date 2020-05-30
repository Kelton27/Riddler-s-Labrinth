public class Exit {
    //An array of positions that cannot be changed
    private final Position[] posArr2 = { new Position(22, 24), new Position(22, 24), new Position(22, 24), new Position(22, 24) };

    //This variable chooses a random position from the previous array of positions
    private final Position _doorPos = this.posArr2[((int)(Math.random() * 4.0D))];

    //A getter for the door position variable
    Position getPosition() {
        return _doorPos;
    }
}

