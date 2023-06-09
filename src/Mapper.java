import java.util.HashMap;

public abstract class Mapper {
    private static HashMap<Character,Integer> file = new HashMap<Character, Integer>() {{
        put('a', 0);
        put('b', 1);
        put('c', 2);
        put('d', 3);
        put('e', 4);
        put('f', 5);
        put('g', 6);
        put('h', 7);
    }};
    private static HashMap<Character,Integer> rank = new HashMap<Character,Integer>() {{
        put('1', 0);
        put('2', 1);
        put('3', 2);
        put('4', 3);
        put('5', 4);
        put('6', 5);
        put('7', 6);
        put('8', 7);
    }};
    public static int getRank(char c){
        return rank.get(c);
    }
    public static int getFile(char c){
        return file.get(c);
    }
}
