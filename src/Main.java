import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class Main {
    public static String read_move_from_console() throws IOException {
        String move;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("-- type your move please e.g., \"move b8 b6\"");
            move = br.readLine().trim();
            move = move.toLowerCase();
            Pattern pattern = Pattern.compile("move [a-h][1-8] [a-h][1-8]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(move);
            if (matcher.find()&& move.length() == 10)
                break;
        }

        return move.substring(5);
    }
    public static void main(String[] args) throws IOException {

        ChessGame game = new ChessGame("fahed","ahmad");
        while (!game.isDone()){
            String move = read_move_from_console();
            if (game.isWhiteTurn())
                game.playWhite(move);
            else
                game.playBlack(move);
        }
        game.printWinnerName();
    }
}
