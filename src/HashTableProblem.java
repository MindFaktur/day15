import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class HashTableProblem {
    static Scanner SCAN = new Scanner(System.in);
    static Hashtable<String,Integer> wordsCount = new Hashtable<>();

    static String userInput() {
        System.out.println("Please enter the string with duplicate words");
        return SCAN.nextLine();
    }

    public static void main(String[] args) {
        String[] words = userInput().split(" ",0);
        for( String word : words ) {
            wordsCount.put(word, 0);
        }
        for( String compareWord : words ) {
            for ( String key : wordsCount.keySet() ) {
                if (compareWord.equals(key)) {
                    Integer value = wordsCount.get(key);
                    value++;
                    wordsCount.put(key, value);
                }
            }
        }
        System.out.println(wordsCount);
    }
}

