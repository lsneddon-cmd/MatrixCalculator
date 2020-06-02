package com.lsneddon;

public class MatrixPrinter {
    public static void printMatrix(double[][] matrix, int rows, int cols) {
        System.out.println("\tThe result is:");
        // format so that different sizes of numbers are aligned
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4.0f", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
