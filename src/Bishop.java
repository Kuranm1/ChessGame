public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Square sourceSquare, Square destinationSquare) {
        /*
            implement all validation cases for King moves
        */
        return true;
    }

    @Override
    public String toString() {
        return (getColor().name()+" "+"Bishop");
    }
}
