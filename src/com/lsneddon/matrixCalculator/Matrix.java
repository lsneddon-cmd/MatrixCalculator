package com.lsneddon.matrixCalculator;

import java.util.stream.IntStream;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] matrix;

    public Matrix(int rows, int cols, double[] input) {
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
        int iterator = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input[iterator];
                iterator++;
            }
        }
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setEntry(int row, int col, double entry) {
        this.matrix[row][col] = entry;
    }

    public double getEntry(int row, int col) {
        return this.matrix[row][col];
    }

    public void printFormattedMatrix() {
        System.out.println("\tThe result is:");
        for (double[] doubles : matrix) {
            IntStream.range(0, matrix[0].length).forEach(i -> System.out.printf("%4.0f", doubles[i]));
            System.out.println();
        }
    }
}
