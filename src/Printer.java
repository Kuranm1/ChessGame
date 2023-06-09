abstract public class Printer {

    public static void printBoard(Board board){

        System.out.println("\t\tA\t\t\t\tB\t\t\t\tC\t\t\t\tD\t\t\t\tE\t\t\t\tF\t\t\t\tG\t\t\t\tH");

        for (int i = 0; i < 8; i++) {
            System.out.print("   ");
            System.out.println(new String(new char[126]).replace("\0", "_"));
            System.out.print(i+1 +" ");

            for (int j = 0; j < 8; j++) {
                if(board.getSquare(new Position(i,j)).getPiece()==null)
                    System.out.print("|\t\t\t\t");
                else
                    System.out.print("| "+board.getSquare(new Position(i,j)).getPiece()+"\t");
            }

            System.out.print("|");
            System.out.println("  ");
        }
        System.out.print("   ");
        System.out.println(new String(new char[126]).replace("\0", "_"));
        System.out.println("\t\tA\t\t\t\tB\t\t\t\tC\t\t\t\tD\t\t\t\tE\t\t\t\tF\t\t\t\tG\t\t\t\tH");
    }

    public static void printWelcome(){
        System.out.println("========================================\n" +
                "++ Welcome the CHESS GAME !!\n" +
                "++ Mohammad AlQuraan\n" +
                "++ Fahed Jubair\n" +
                "++ Atypon Training 2022\n" +
                "========================================\n");
    }

    public static void printCurruentTurn(Color currentColorTurn){
        System.out.println("\n++ "+currentColorTurn.name()+" player turn:");
    }
}
