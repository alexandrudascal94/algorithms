package interviews;

import java.util.Arrays;
import java.util.HashSet;

public class FindThePasswordStrength {

    /*
            Find the password strength.
        For each substring of the password which contains at least one vowel and one consonant, its strength goes up by 1.
        vowels={'a', 'e', 'i', 'o', 'u'}, and rest of letters are all consonant.
        (Only lower alphabet letters)

     */

    public static void main(String[] args) {
        System.out.println(passwordStrength("thisissbeautiful"));
        System.out.println(passwordStrength("hackerrank"));

    }

    public static HashSet<Character> vowels = new HashSet<>();
    static {
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    }

    // time - O(n)
    // space - O(1) - only vowels which is constant
    public static int passwordStrength(String input){
        boolean isConsonant = false;
        boolean isVowel = false;
        int strength = 0;


        for(int i = 0; i < input.length(); ++i){
            char currentChar = input.charAt(i);
            if(isVowel(currentChar)){
                isVowel = true;
            }
            else{
                isConsonant = true;
            }

            if(isConsonant && isVowel){
                strength ++;
                isConsonant = false;
                isVowel = false;
            }
        }
        return strength;
    }

    private static boolean isVowel(char currentChar) {
        return vowels.contains(currentChar);
    }
}
