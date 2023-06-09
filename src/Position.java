public class Position {
    public int rank;
    public int file;

    public Position(int rank, int files) {
        this.rank = rank;
        this.file = files;
    }

    public static boolean isOutOfRange(Position p) {

        return p.rank >= 0 && p.rank <= 7 && p.file >= 0 && p.file <= 7;
    }
}
