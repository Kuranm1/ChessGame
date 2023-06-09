public class Board {
    private final Square[][] squares = new Square[8][8];
    private final Piece whiteKing = new King(Color.WHITE);
    private final Piece blackKing = new King(Color.BLACK);

    public Board() {

        // White side pieces
        squares[0][0] = new Square(new Position(0,0), new Rook(Color.WHITE));
        squares[0][1] = new Square(new Position(0,1), new Knight(Color.WHITE));
        squares[0][2] = new Square(new Position(0,2), new Bishop(Color.WHITE));
        squares[0][3] = new Square(new Position(0,3), new Queen(Color.WHITE));
        squares[0][4] = new Square(new Position(0,4), whiteKing);
        squares[0][5] = new Square(new Position(0,5), new Bishop(Color.WHITE));
        squares[0][6] = new Square(new Position(0,6), new Knight(Color.WHITE));
        squares[0][7] = new Square(new Position(0,7), new Rook(Color.WHITE));
        for (int i = 0; i < 8; i++) {
            squares[1][i] = new Square(new Position(1,i), new Pawn(Color.WHITE));
        }

        // Black side pieces
        squares[7][0] = new Square(new Position(7,0), new Rook(Color.BLACK));
        squares[7][1] = new Square(new Position(7,1), new Knight(Color.BLACK));
        squares[7][2] = new Square(new Position(7,2), new Bishop(Color.BLACK));
        squares[7][3] = new Square(new Position(7,3), new Queen(Color.BLACK));
        squares[7][4] = new Square(new Position(7,4), blackKing);
        squares[7][5] = new Square(new Position(7,5), new Bishop(Color.BLACK));
        squares[7][6] = new Square(new Position(7,6), new Knight(Color.BLACK));
        squares[7][7] = new Square(new Position(7,7), new Rook(Color.BLACK));
        for (int i = 0; i < 8; i++) {
            squares[6][i] = new Square(new Position(6,i), new Pawn(Color.BLACK));
        }

        // Empty squares
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(new Position(i,j), null);
            }
        }

    }

    public Piece getWhiteKing() {
        return whiteKing;
    }

    public Piece getBlackKing() {
        return blackKing;
    }

    public Square getSquare(Position p) {
        return squares[p.rank][p.file];
    }
}