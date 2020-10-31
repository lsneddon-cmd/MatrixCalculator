package com.lsneddon.matrixCalculator;

import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

/**
 *  Contains one static method that iterates through a 2 dimensional
 *  double array and prints the elements in an appropriate format
 */

final class MatrixPrinter {
    public static void printMatrix(double[] @NotNull [] matrix) {
        System.out.println("\tThe result is:");
        for (double[] doubles : matrix) {
            IntStream.range(0, matrix[0].length).forEach(i -> System.out.printf("%4.0f", doubles[i]));
            System.out.println();
        }
    }
}
