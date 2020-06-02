package com.lsneddon;

import java.util.Scanner;

public class Calculations {
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
            double[][] outputMatrix = new double[fRows][fCols];
            for (int i = 0; i < fRows; i++) {
                for (int j = 0; j < fCols; j++) {
                    outputMatrix[i][j] = fMatrix[i][j] + matrix[i][j];
                }
            }
            MatrixPrinter.printMatrix(outputMatrix, fRows, fCols);
        }
    }



    public static double[][] calculateScalarMult(double[][] matrix, double scalar) {
        double[][] outputMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                outputMatrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return outputMatrix;
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
        double[][] outputMatrix;
        if (fCols != sRows) {
            // Matrices cannot be multiplied, print error
            System.out.println("\tERROR\n\tMatrices cannot be multiplied\n\tThe number of rows of a matrix must match the number of columns of another matrix in order to multiply them\n");
        } else {
            outputMatrix = new double[fRows][sCols];
            for (int i = 0; i < fRows; i++) {
                for (int j = 0; j < sCols; j++) {
                    for (int k = 0; k < fCols; k++) {
                        outputMatrix[i][j] += fMatrix[i][k] * sMatrix[k][j];
                    }
                }
            }
            // Print output Matrix
            MatrixPrinter.printMatrix(outputMatrix, fRows, sCols);
        }
    }

    public static void sideTransposition(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        int oRows = cols;
        int oCols = rows;
        double[][] outputMatrix = new double[oRows][oCols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[cols - 1 - j][rows - 1 - i];
            }
        }
        MatrixPrinter.printMatrix(outputMatrix, oRows, oCols);
    }

    public static void verticalTransposition(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[i][rows - 1 - j];
            }
        }
        MatrixPrinter.printMatrix(outputMatrix, rows, cols);
    }

    public static void horizontalTransposition(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[cols - 1 - i][j];
            }
        }
        MatrixPrinter.printMatrix(outputMatrix, rows, cols);
    }

    public static void mainTransposition(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        int oRows = cols;
        int oCols = rows;
        double[][] outputMatrix = calculateMainTransposition(matrix);
        MatrixPrinter.printMatrix(outputMatrix, oRows, oCols);
    }

    public static double[][] calculateMainTransposition(double[][] matrix) {
        // currently works only for a square matrix
        double[][] outputMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                outputMatrix[i][j] = matrix[j][i];
            }
        }
        return outputMatrix;
    }

    public static void determinantOfMatrix(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        if (rows == cols) {
            double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
            double determinant = calculateDeterminant(matrix);
            System.out.print("\tThe determinant is:\t");
            System.out.print(determinant + "\n");
        } else {
            System.out.println("Determinant can only be calculated on a square Matrix");
        }

    }

    public static double calculateDeterminant(double[][] matrix) {
        double det = 0;
        if (matrix.length == 2) {
            return twoByTwoDeterminant(matrix);
        }
        for (int i = 0; i < matrix.length; i++) {
            double[][] temp = stripMatrix(matrix, i);
            det += i % 2 == 0 ? matrix[0][i] * calculateDeterminant(temp) : -(matrix[0][i] * calculateDeterminant(temp));
        }
        return det;
    }

    public static double[][] stripMatrix(double[][] matrix, int num) {
        double[][] output = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j < num) {
                    output[i - 1][j] = matrix[i][j];
                }
                if (j > num) {
                    output[i - 1][j - 1] = matrix[i][j];
                }
            }
        }
        return output;
    }

    public static double[][] stripMatrix(double[][] matrix, int row, int col) {
        // overloads strip method and returns a new matrix with a specifed row and column removed
        double[][] output = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i < row && j < col) {
                    output[i][j] = matrix[i][j];
                } else if (i > row && j < col) {
                    output[i - 1][j] = matrix[i][j];
                } else if (i < row && j > col) {
                    output[i][j - 1] = matrix[i][j];
                } else if (i > row && j > col) {
                    output[i - 1][j - 1] = matrix[i][j];
                }
            }
        }
        return output;
    }

    public static double twoByTwoDeterminant(double[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static void inverseOfMatrix(Scanner reader) {
        int rows = MatrixReader.readRows(reader);
        int cols = MatrixReader.readColumns(reader);
        double[][] matrix = MatrixReader.readMatrix(rows, cols, reader);
        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Inverse of the given matrix can't be found as it's determinant is 0!");
        } else {
            double[][] cofactorMatrix = findCofactors(matrix);
            double[][] transposedCofactorMatrix = calculateMainTransposition(cofactorMatrix);
            double[][] inverseMatrix = calculateScalarMult(transposedCofactorMatrix, 1 / determinant);
            MatrixPrinter.printMatrix(inverseMatrix, inverseMatrix.length, inverseMatrix.length);
        }
    }

    public static double[][] findCofactors(double[][] matrix) {
        double[][] output = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // output element cofactor of matrix element
                output[i][j] = calculateDeterminant(stripMatrix(matrix, i, j));
            }
        }
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if ((i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0)) {
                    output[i][j] *= -1;
                }
            }
        }
        return output;
    }
}
