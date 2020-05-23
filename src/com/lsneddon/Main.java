/**
 * This program carries out mathematical calculations on matrices
 * @version 1.1 2020-05-23
 * @author Lewis Sneddon
 */

package com.lsneddon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Menu
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply Matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");

            int menuChoice = reader.nextInt();

            switch (menuChoice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    // addition
                    addition(reader);
                    break;
                case 2:
                    // scalar multiplication
                    scalarMultiplication(reader);
                    break;
                case 3:
                    multiplyMatrices(reader);
                    break;
                case 4:
                    // Transpose selection
                    int transpositionChoice = transposeSelection(reader);
                    switch (transpositionChoice) {
                        case 1:
                            // Main Diagonal
                            mainTransposition(reader);
                            break;
                        case 2:
                            // Side Diagonal
                            sideTransposition(reader);
                            break;
                        case 3:
                            // Vertical Line
                            verticalTransposition(reader);
                            break;
                        case 4:
                            // Horizontal Line
                            horizontalTransposition(reader);
                            break;
                        default:
                            System.out.println("Unrecognised input... restarting program");
                            break;
                    }
                    break;
                case 5:
                    // Determinant
                    determinantOfMatrix(reader);
                    break;
                case 6:
                    //Inverse
                    inverseOfMatrix(reader);
                    break;
                default:
                    System.out.println("Unrecognised input, please try again");
            }
        }
    }

    public static int transposeSelection(Scanner reader) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
        return reader.nextInt();
    }

    public static void addition(Scanner reader) {
        double[][] fMatrix;
        int fRows;
        int fCols;
        double[][] matrix;
        int rows;
        int cols;
        System.out.print("Enter the size of the first matrix: ");
        fRows = reader.nextInt();
        fCols = reader.nextInt();
        fMatrix = readMatrix(fRows, fCols, reader);
        System.out.print("Enter the size of the second matrix: ");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        if (!(fRows == rows) || !(fCols == cols)) {
            System.out.println("ERROR");
        } else {
            double[][] outputMatrix = new double[fRows][fCols];
            for (int i = 0; i < fRows; i++) {
                for (int j = 0; j < fCols; j++) {
                    outputMatrix[i][j] = fMatrix[i][j] + matrix[i][j];
                }
            }
            printMatrix(outputMatrix, fRows, fCols);
        }
    }

    public static void scalarMultiplication(Scanner reader) {
        double[][] matrix;
        int rows;
        int cols;
        double scalar;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        System.out.println("Enter a scalar to multiply by:");
        scalar = reader.nextDouble();
        double[][] outputMatrix = calculateScalarMult(matrix, scalar);
        printMatrix(outputMatrix, rows, cols);
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
        double[][] fMatrix;
        int fRows;
        int fCols;
        double[][] sMatrix;
        int sRows;
        int sCols;
        double[][] outputMatrix;
        System.out.print("Enter the size of the first matrix: ");
        fRows = reader.nextInt();
        fCols = reader.nextInt();
        fMatrix = readMatrix(fRows, fCols, reader);
        System.out.print("Enter the size of the second matrix: ");
        sRows = reader.nextInt();
        sCols = reader.nextInt();
        sMatrix = readMatrix(sRows, sCols, reader);
        if (fCols != sRows) {
            // Matrices cannot be multiplied, print error
            System.out.println("ERROR");
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
            printMatrix(outputMatrix, fRows, sCols);
        }
    }

    public static void sideTransposition(Scanner reader) {
        double[][] matrix;
        int rows;
        int cols;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        int oRows = cols;
        int oCols = rows;
        double[][] outputMatrix = new double[oRows][oCols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[cols - 1 - j][rows - 1 - i];
            }
        }
        printMatrix(outputMatrix, oRows, oCols);
    }

    public static void verticalTransposition(Scanner reader) {
        double[][] matrix;
        int rows;
        int cols;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[i][rows - 1 - j];
            }
        }
        printMatrix(outputMatrix, rows, cols);
    }

    public static void horizontalTransposition(Scanner reader) {
        double[][] matrix;
        int rows;
        int cols;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[cols - 1 - i][j];
            }
        }
        printMatrix(outputMatrix, rows, cols);
    }

    public static void mainTransposition(Scanner reader) {
        double[][] matrix;
        int rows;
        int cols;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        int oRows = cols;
        int oCols = rows;
        double[][] outputMatrix = calculateMainTransposition(matrix);
        printMatrix(outputMatrix, oRows, oCols);
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
        double[][] matrix;
        int rows;
        int cols;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        if (rows == cols) {
            matrix = readMatrix(rows, cols, reader);
            double determinant = calculateDeterminant(matrix);
            System.out.println("The determinant is: ");
            System.out.println(determinant);
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
        double[][] matrix;
        int rows;
        int cols;
        System.out.println("Enter the size of the matrix:");
        rows = reader.nextInt();
        cols = reader.nextInt();
        matrix = readMatrix(rows, cols, reader);
        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Inverse of the given matrix can't be found as it's determinant is 0!");
        } else {
            // find cofactors of each element in the matrix
            double[][] cofactorMatrix = findCofactors(matrix);
            // transpose the cofactor matrix
            double[][] transposedCofactorMatrix = calculateMainTransposition(cofactorMatrix);
            // inverse matrix is determinant scalarMultiplication of transposed cofactor matrix
            double[][] inverseMatrix = calculateScalarMult(transposedCofactorMatrix, 1 / determinant);
            // print inverse matrix
            printMatrix(inverseMatrix, inverseMatrix.length, inverseMatrix.length);
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

    public static void printMatrix(double[][] matrix, int rows, int cols) {
        System.out.println("The result is:");
        // format so that different sizes of numbers are aligned
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] readMatrix(int rows, int cols, Scanner reader) {
        System.out.println("Enter the matrix: ");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = reader.nextDouble();
            }
        }
        return matrix;
    }



}


