import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Week 2 Exercise — String analysis (implement TODO methods).
 *
 * Compile: javac TextAnalyzer.java
 * Run:     java TextAnalyzer
 */
public class TextAnalyzer {

    /**
    Counts the number of words in a body of text using \\s to capture whitespaces
    @param  text
     @return count of words
     */
    public static int wordCount(String text) {
        return text.split("\\s+").length;
    }

    /**
     * checks if a string is a palindrome
     * @param token to check if palindrome
     * @return boolean of whether it is palidrome
     */
    public static boolean isPalindrome(String token) {
        token = token.toLowerCase();
        token = token.trim();
        for(int i = 0; i < token.length() / 2; i++){
            if(token.charAt(i) != token.charAt(token.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    /**
     * count the occurunces of word in body of text
     * @param haystack is the body of text to scan
     * @param needle is the string to search for in the haystack
     * @return count of how many times needle is in haystack
     */

    public static int countOccurrences(String haystack, String needle) {
        int count = 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Path p = Path.of("sample.txt");
        String body = Files.readString(p);
        System.out.println("words=" + wordCount(body));
        System.out.println("palindrome(Radar)=" + isPalindrome("Radar"));
        System.out.println("occurrences of 'QA'=" + countOccurrences(body, "QA"));
    }
}