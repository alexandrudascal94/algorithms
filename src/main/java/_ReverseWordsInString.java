import java.util.Arrays;
import java.util.stream.Collectors;

public class _ReverseWordsInString {


    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
