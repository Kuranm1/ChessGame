abstract public class Piece   {
    private Color color;
    private Boolean pieceKilled;
    public Piece(Color color) {
        this.color = color;
        pieceKilled = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean isPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Boolean pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    abstract public boolean isValidMove(Square sourceSquare, Square destinationSquare);

    @Override
    abstract public String toString();
}
