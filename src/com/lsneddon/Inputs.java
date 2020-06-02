package com.lsneddon;

import java.util.Scanner;

public class Inputs {

    public static void addition(Scanner reader) {
        System.out.println("Let's start with the first matrix:");
        int fRows = MatrixReader.readRows(reader);
        int fCols = MatrixReader.readColumns(reader);
        double[][] fMatrix = MatrixReader.readMatrix(fRows, fCols, reader);
        System.out.println("Now for the second matrix:");
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        if (!(fRows == rows) || !(fCols == cols)) {
            System.out.println("\tERROR!\n\tMatrices must have the same dimensions to add");
        } else {
            double[][] outputMatrix = Calculations.calculateAddition(fRows, fCols, fMatrix, matrix);
            MatrixPrinter.printMatrix(outputMatrix, fRows, fCols);
        }
    }

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

    public static void multiplyMatrices(Scanner reader) {
        // Matrix multiplication
        System.out.println("Let's start with the first matrix:");
        int fRows = MatrixReader.readRows(reader);
        int fCols = MatrixReader.readColumns(reader);
        double[][] fMatrix = MatrixReader.readMatrix(fRows, fCols, reader);
        System.out.println("Now for the second matrix:");
        int sRows = MatrixReader.readRows(reader);
        int sCols = MatrixReader.readColumns(reader);
        double[][] sMatrix = MatrixReader.readMatrix(sRows, sCols, reader);;

        if (fCols != sRows) {
            // Matrices cannot be multiplied, print error
            System.out.println("\tERROR\n\tMatrices cannot be multiplied\n\tThe number of rows of a matrix must match the number of columns of another matrix in order to multiply them\n");
        } else {
            double[][] outputMatrix = Calculations.calculateMatrixMult(fRows, fCols, sCols, fMatrix, sMatrix);
            MatrixPrinter.printMatrix(outputMatrix, fRows, sCols);
        }
    }

    public static void mainTransposition(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        int oRows = cols;
        int oCols = rows;
        double[][] outputMatrix = Calculations.calculateMainTransposition(matrix);
        MatrixPrinter.printMatrix(outputMatrix, oRows, oCols);
    }

}
