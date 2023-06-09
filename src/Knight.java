public class Knight extends Piece  {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Square sourceSquare, Square destinationSquare) {
        /*
            implement all validation cases for Knight moves
        */
        return true;
    }

    @Override
    public String toString() {
        return (getColor().name()+" "+"Knight");
    }
}
