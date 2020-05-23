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

        String title = "\t=================\n\tMatrix Calculator\n\tMain Menu\n\t=================\n";
        String mainMenu = "Please select one of the following options:\n\t1. Add matrices \n\t2. Multiply matrix to a constant\n\t3. Multiply Matrices\n\t4. Transpose matrix\n\t5. Calculate determinant\n\t6. Inverse matrix\n\t0. Exit";
        String prompt = "--> ";
        boolean exit = false;
        while (!exit) {
            // Menu
            System.out.println(title);
            System.out.println(mainMenu);
            System.out.print(prompt);
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
        System.out.println("\t==================\n\tMatrix Calculator\n\tTransposition Menu\n\t==================\n");
        System.out.println("\t1. Main diagonal");
        System.out.println("\t2. Side diagonal");
        System.out.println("\t3. Vertical line");
        System.out.println("\t4. Horizontal line");
        System.out.print("--> ");
        return reader.nextInt();
    }

    public static void addition(Scanner reader) {
        System.out.println("Let's start with the first matrix:");
        int fRows = readRows(reader);
        int fCols = readColumns(reader);
        double[][] fMatrix = readMatrix(fRows, fCols, reader);
        System.out.println("Now for the second matrix:");
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
        if (!(fRows == rows) || !(fCols == cols)) {
            System.out.println("\tERROR!\n\tMatrices must have the same dimensions to add");
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
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
        System.out.println("\tEnter a scalar to multiply by:");
        System.out.print("--> ");
        double scalar = reader.nextDouble();
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
        System.out.println("Let's start with the first matrix:");
        int fRows = readRows(reader);
        int fCols = readColumns(reader);
        double[][] fMatrix = readMatrix(fRows, fCols, reader);
        System.out.println("Now for the second matrix:");
        int sRows = readRows(reader);
        int sCols = readColumns(reader);
        double[][] sMatrix = readMatrix(sRows, sCols, reader);;
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
            printMatrix(outputMatrix, fRows, sCols);
        }
    }

    public static void sideTransposition(Scanner reader) {
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
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
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[i][rows - 1 - j];
            }
        }
        printMatrix(outputMatrix, rows, cols);
    }

    public static void horizontalTransposition(Scanner reader) {
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[cols - 1 - i][j];
            }
        }
        printMatrix(outputMatrix, rows, cols);
    }

    public static void mainTransposition(Scanner reader) {
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
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
        int rows = readRows(reader);
        int cols = readColumns(reader);
        if (rows == cols) {
            double[][] matrix = readMatrix(rows, cols, reader);
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
        int rows = readRows(reader);
        int cols = readColumns(reader);
        double[][] matrix = readMatrix(rows, cols, reader);
        double determinant = calculateDeterminant(matrix);
        if (determinant == 0) {
            System.out.println("Inverse of the given matrix can't be found as it's determinant is 0!");
        } else {
            double[][] cofactorMatrix = findCofactors(matrix);
            double[][] transposedCofactorMatrix = calculateMainTransposition(cofactorMatrix);
            double[][] inverseMatrix = calculateScalarMult(transposedCofactorMatrix, 1 / determinant);
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
        System.out.println("\tThe result is:");
        // format so that different sizes of numbers are aligned
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] readMatrix(int rows, int cols, Scanner reader) {
        System.out.println("\tEnter each element of the matrix: ");
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("-->");
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


