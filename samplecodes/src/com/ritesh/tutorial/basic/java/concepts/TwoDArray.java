package com.ritesh.tutorial.basic.java.concepts;

import java.util.function.Consumer;
import java.util.function.Function;

public class TwoDArray {

    public static void main (String[] arr) {
        int[][] array2D = {{1,2,3,4}, {5,6,7,8}, {9, 10, 11, 12}, {13,14,15,16}};//initialization 1

        //Print diagonal
        int numRows = array2D.length;
        int numColumns = array2D[0].length;

        int diagonal = (numColumns < numRows)? numColumns:numRows;

        for (int i = 0; i < diagonal; i++) {
            System.out.println(array2D[i][i]);
        }

        int[][] array2D1 = new int[4][4];
        printDiagonal(array2D1);
    }

    public static void printDiagonal(int array2D[][]) {
        int numRows = array2D.length;
        int numColumns = array2D[0].length;

        int diagonal = (numColumns < numRows)? numColumns:numRows;

        for (int i = 0; i < diagonal; i++) {
            System.out.println(array2D[i][i]);
        }
    }
}
