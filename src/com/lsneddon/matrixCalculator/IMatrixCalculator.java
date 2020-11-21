package com.lsneddon.matrixCalculator;

public interface IMatrixCalculator {
    Matrix calculate(Matrix first, Matrix second);
    String getCalculation();
    boolean validateOperation(Matrix first, Matrix second);
}
