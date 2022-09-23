public class Test {

    public static void main(String[] args) {

    }

    public int[] solution(String[] S) {
        for(int i = 0; i < S.length - 1; i++){
            var currentString = S[i];
            for(int j = i + 1; j < S.length; j++){
                var compareToString = S[j];

                for(int k = 0; k < currentString.length(); k++){
                    if(compareToString.charAt(k) == currentString.charAt(k)){
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return new int[0];
    }
}
