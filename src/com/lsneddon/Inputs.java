package com.lsneddon;

import java.util.Scanner;

public class Inputs {
    public static void scalarMultiplication(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        System.out.println("\tEnter a scalar to multiply by:");
        System.out.print("--> ");
        double scalar = reader.nextDouble();
        double[][] outputMatrix = Calculations.calculateScalarMult(matrix, scalar);
        MatrixPrinter.printMatrix(outputMatrix, rows, cols);
    }
}
