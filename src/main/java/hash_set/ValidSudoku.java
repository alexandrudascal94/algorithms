package hash_set;

import java.util.HashSet;
//https://leetcode.com/problems/valid-sudoku/

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // iterate all rows and if there are duplicate numbers, use HashSet
        // iterate all columns if there are duplicates numebrs
        for(int i = 0; i < board.length; i++){
            if(!isValid(board, i, i + 1, 0, 9)){
                return false;
            }
            if(!isValid(board, 0, 9, i, i + 1)){
                return false;
            }
        }

        for(int i = 0; i < board.length; i += 3){
            for(int j = 0; j < board[i].length; j += 3){
                if(!isValid(board, i, i + 3, j, j + 3)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int startI , int endI,
                           int startJ, int endJ){
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = startI; i < endI; i++){
            for(int j = startJ; j < endJ; ++j){
                char c = board[i][j];
                if('.' != c){
                    int number = Character. getNumericValue(c);
                    if(set.contains(number)){
                        return false;
                    }

                    set.add(number);
                }
            }
        }
        return true;
    }
}
