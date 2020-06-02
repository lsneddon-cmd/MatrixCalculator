/**
 * This program carries out mathematical calculations on matrices
 * @version 1.2 2020-06-02
 * @author Lewis Sneddon
 */

package com.lsneddon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Menu menu = new Menu();

        boolean exit = false;
        while (!exit) {
            int menuChoice = menu.mainMenuSelection(reader);

            switch (menuChoice) {
                case 0:
                    exit = true;
                    System.out.println("Exiting!");
                    break;
                case 1:
                    System.out.println("Performing Matrix Addition");
                    Inputs.addition(reader);
                    break;
                case 2:
                    System.out.println("Performing Scalar Multiplication");
                    Inputs.scalarMultiplication(reader);
                    break;
                case 3:
                    System.out.println("Performing Matrix Multiplication");
                    Inputs.multiplyMatrices(reader);
                    break;
                case 4:
                    int transpositionChoice = menu.transposeMenuSelection(reader);
                    switch (transpositionChoice) {
                        case 1:
                            System.out.println("Perfoming Main Diagonal Transposition");
                            Inputs.mainTransposition(reader);
                            break;
                        case 2:
                            System.out.println("Performing Side Transposition");
                            Inputs.sideTransposition(reader);
                            break;
                        case 3:
                            System.out.println("Performing Vertical Transposition");
                            Inputs.verticalTransposition(reader);
                            break;
                        case 4:
                            System.out.println("Performing Horizonatal Transposition");
                            Inputs.horizontalTransposition(reader);
                            break;
                        default:
                            System.out.println("Unrecognised input... restarting program");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Calculating the Determinant of a Matrix");
                    Inputs.determinantOfMatrix(reader);
                    break;
                case 6:
                    System.out.println("Calculating the Inverse of a Matrix");
                    Inputs.inverseOfMatrix(reader);
                    break;
                default:
                    System.out.println("Unrecognised input, please try again");
            }
        }
    }
}


