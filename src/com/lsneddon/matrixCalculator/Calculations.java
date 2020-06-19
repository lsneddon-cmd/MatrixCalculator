package com.lsneddon.matrixCalculator;

/**
 * A collection of static methods that carry out Math operations on given matrices
 */

public final class Calculations {

    private Calculations() {}

    public static double[][] calculateAddition(int rows, int cols, double[][] first, double[][] second) {
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                outputMatrix[i][j] = first[i][j] + second[i][j];
            }
        }
        return outputMatrix;
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
    public static double[][] calculateMatrixMult(int fRows, int fCols, int sCols, double[][] first, double[][] second) {
        double[][] outputMatrix = new double[fRows][sCols];
        for (int i = 0; i < fRows; i++) {
            for (int j = 0; j < sCols; j++) {
                for (int k = 0; k < fCols; k++) {
                    outputMatrix[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return outputMatrix;
    }
    public static double[][] calculateMainTransposition(double[][] matrix) {
        /////////////////////////////////////////////
        // currently works only for a square matrix//
        /////////////////////////////////////////////
        double[][] outputMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                outputMatrix[i][j] = matrix[j][i];
            }
        }
        return outputMatrix;
    }
    public static double[][] calculateSideTransposition(double[][] matrix, int rows, int cols) {
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[cols - 1 - j][rows - 1 - i];
            }
        }
        return outputMatrix;
    }
    public static double[][] calculateVerticalTransposition(double[][] matrix, int rows, int cols) {
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j= 0; j < cols; j++) {
                outputMatrix[i][j] = matrix[i][rows - 1 - j];
            }
        }
        return outputMatrix;
    }
    public static double[][] calculateHorizontalTransposition(double[][] matrix, int rows, int cols) {
        double[][] outputMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (cols >= 0) System.arraycopy(matrix[cols - 1 - i], 0, outputMatrix[i], 0, cols);
        }
        return outputMatrix;
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
    // Used to reduce matrix while calculating Determinant
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
        // overloads strip method and returns a new matrix with a specified row and column removed
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
