package org.example.leetcode.easy;

import org.example.helpercode.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWord {

    private Set<String> found = new HashSet<>();
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();
    private int mRow;
    private int mCol;

    public boolean inBounds(int row, int col) {
        return (row >= 0 && row < mRow && col >= 0 && col < mCol);

    }

    public boolean traverse(char[][] board, int i, int j, String word) {
        if (!inBounds(i, j))
            return false;
        if (word.length() == 0)
            return true;

        visited.add(new Pair<>(i, j));
        boolean found = false;
        if (word.charAt(0) == board[i][j]) {
            found = traverse(board, i, j+1, word.substring(1, word.length())) ||
                    traverse(board, i, j-1, word.substring(1, word.length())) ||
                    traverse(board, i+1, j, word.substring(1, word.length())) ||
                    traverse(board, i-1, j, word.substring(1, word.length()));
        }
        return found;

    }

    public void traverse(char[][] board, int i, int j, String[] words) {

        for (String s: words) {
            visited.clear();
            if (traverse(board, i, j, s))  {
                found.add(s);
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int i = 0;
        int j = 0;
        mRow = board.length;
        mCol = board[0].length;

        for(i = 0; i < mRow; i++) {
            for (j = 0; j < mCol; j++) {
                traverse(board, i, j, words);
            }
        }

        return new ArrayList<String>(found);
    }

    public static void main(String[] args) {
        FindWord w = new FindWord();
        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        w.findWords(board, words);
    }
}
