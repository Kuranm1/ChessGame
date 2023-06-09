import java.util.HashMap;

public class ChessGame implements I_Chess{
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Color currentColorTurn;
    private final Board board;
    private GameStatus status;
    private int numOfKilledPieces ;


    public ChessGame(String whitePlayer, String blackPlayer) {
        this.whitePlayer = new Player(whitePlayer,Color.WHITE);
        this.blackPlayer = new Player(blackPlayer,Color.BLACK);
        this.board = new Board();
        status = GameStatus.RUNNING;
        currentColorTurn=Color.WHITE;
        numOfKilledPieces = 0;
        Printer.printWelcome();
        Printer.printBoard(board);
        Printer.printCurruentTurn(currentColorTurn);

    }

    public void playWhite(String move){
        Position sourcePosition = new Position(Mapper.getRank(move.charAt(1)),Mapper.getFile(move.charAt(0)));
        Position destPosition = new Position(Mapper.getRank(move.charAt(4)),Mapper.getFile(move.charAt(3)));
        Square sourceSquare = board.getSquare(sourcePosition);
        Square destinationSquare = board.getSquare(destPosition);
        makeMove(whitePlayer,sourceSquare,destinationSquare);
    }
    public void playBlack(String move){
        Position sourcePosition = new Position(Mapper.getRank(move.charAt(1)),Mapper.getFile(move.charAt(0)));
        Position destPosition = new Position(Mapper.getRank(move.charAt(4)),Mapper.getFile(move.charAt(3)));
        Square sourceSquare = board.getSquare(sourcePosition);
        Square destinationSquare = board.getSquare(destPosition);
        makeMove(blackPlayer,sourceSquare,destinationSquare);
    }

    public void makeMove(Player player, Square sourceSquare, Square destinationSquare){

        Piece sourcePiece = sourceSquare.getPiece();
        Piece destPiece = destinationSquare.getPiece();


        if (sourcePiece == null)
            return;

        // Check the validation of the move
        if (!sourcePiece.isValidMove(sourceSquare, destinationSquare))
            return;

        // Check if the user wants to make a castle move
        if (sourcePiece instanceof King){
            if (isCastling())
                return;
        }

        // set piece to be killed at the destination square
        if (destPiece != null){
            destPiece.setPieceKilled(true);
            numOfKilledPieces++;
        }

        //Make the move
        destinationSquare.setPiece(sourcePiece);
        sourceSquare.setPiece(null);

        // Promote Pawn if it reaches the last rank
        checkPromotion(destinationSquare);

        if (isUnderAttack()){
            // If the king is under attack notify the other player
        }

        if (isCheckMate()){
            // End the game and set the winner
        }

        // If the king is killed end the game ( Alternative solution of check mate)
        if (destPiece instanceof King && destPiece.isPieceKilled()) {

            if (currentColorTurn == Color.WHITE)
                this.status = GameStatus.WHITE_WIN;
            else
                this.status = GameStatus.BLACK_WIN;
        }

        if (isDraw())
            status = GameStatus.DRAW;

        // Switch turn to the other player
        changeTurn();

        // Print the board status
        Printer.printBoard(board);

        // Print the current player turn to make a move
        if (!isDone())
            Printer.printCurruentTurn(currentColorTurn);
    }

    public boolean isDone (){
        return status != GameStatus.RUNNING;
    }

    public boolean isWhiteTurn(){
        return currentColorTurn == Color.WHITE;
    }

    public void printWinnerName(){
        if (status == GameStatus.WHITE_WIN)
            System.out.println("\n++ "+whitePlayer.getName()+" (White) is the Winner !!!");
        else
            System.out.println("\n++ "+blackPlayer.getName()+" (Black) is the Winner !!!");
    }

    @Override
    public void checkPromotion(Square destinationSquare) {
        if (destinationSquare.getPiece() instanceof Pawn && destinationSquare.getPosition().rank==0 || destinationSquare.getPosition().rank==7){
            if(destinationSquare.getPiece().getColor() == Color.WHITE)
                destinationSquare.setPiece(new Queen(Color.WHITE));
            else
                destinationSquare.setPiece(new Queen(Color.BLACK));
        }

    }

    @Override
    public boolean isUnderAttack() {
        return false;
    }

    @Override
    public boolean isCheckMate() {
        return false;
    }

    @Override
    public boolean isDraw() {
        return  (numOfKilledPieces==30 && !board.getBlackKing().isPieceKilled() && !board.getWhiteKing().isPieceKilled());
    }

    public void changeTurn(){
        if (currentColorTurn == Color.WHITE)
            currentColorTurn = Color.BLACK;
        else
            currentColorTurn = Color.WHITE;

    }

    @Override
    public boolean isCastling(){
        return false;
    }

}

