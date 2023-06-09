public class Queen extends Piece {

    public Queen(Color color) {
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
        return (getColor().name()+" "+"Queen");
    }
}
