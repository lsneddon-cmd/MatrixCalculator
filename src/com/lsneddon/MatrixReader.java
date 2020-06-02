package com.lsneddon;

import java.util.Scanner;

public class MatrixReader {
    public static double[][] readMatrix(int rows, int cols, Scanner reader) {
        System.out.println("\tEnter each element of the matrix: ");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((i + 1) + ", " + (j + 1) + " --> ");
                matrix[i][j] = reader.nextDouble();
            }
        }
        return matrix;
    }

    public static int readRows(Scanner reader) {
        System.out.print("\tEnter the number of rows in the matrix\n");
        System.out.print("--> ");
        return reader.nextInt();
    }

    public static int readColumns(Scanner reader) {
        System.out.print("\tEnter the number of columns in the matrix\n");
        System.out.print("--> ");
        return reader.nextInt();
    }
}
