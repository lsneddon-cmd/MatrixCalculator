package com.lsneddon.matrixCalculator;

public class Add implements IMatrixCalculator {
    @Override
    public Matrix calculate(Matrix first, Matrix second) {
        Matrix outputMatrix = new Matrix(first.getRows(), first.getCols());
        double res;
        for (int i = 0; i < first.getRows(); i++) {
            for (int j = 0; j < first.getCols(); j++) {
                res = first.getEntry(i, j) + second.getEntry(i, j);
                outputMatrix.setEntry(i, j, res);
            }
        }
        return outputMatrix;
    }

    @Override
    public String getCalculation() {
        return "add";
    }

    @Override
    public boolean validateOperation(Matrix first, Matrix second) {
        return first.getRows() == second.getRows() && first.getCols() == second.getCols();
    }
}
