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
            printMenu();
            int menuChoice = reader.nextInt();

            switch (menuChoice) {
                case 0:
                    exit = true;
                    System.out.println("Exiting!");
                    break;
                case 1:
                    System.out.println("Performing Matrix Addition");
                    Calculations.addition(reader);
                    break;
                case 2:
                    System.out.println("Performing Scalar Multiplication");
                    Inputs.scalarMultiplication(reader);
                    break;
                case 3:
                    System.out.println("Performing Matrix Multiplication");
                    Calculations.multiplyMatrices(reader);
                    break;
                case 4:
                    int transpositionChoice = transposeSelection(reader);
                    switch (transpositionChoice) {
                        case 1:
                            System.out.println("Perfoming Main Diagonal Transposition");
                            Calculations.mainTransposition(reader);
                            break;
                        case 2:
                            System.out.println("Performing Side Transposition");
                            Calculations.sideTransposition(reader);
                            break;
                        case 3:
                            System.out.println("Performing Vertical Transposition");
                            Calculations.verticalTransposition(reader);
                            break;
                        case 4:
                            System.out.println("Performing Horizonatal Transposition");
                            Calculations.horizontalTransposition(reader);
                            break;
                        default:
                            System.out.println("Unrecognised input... restarting program");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Calculating the Determinant of a Matrix");
                    Calculations.determinantOfMatrix(reader);
                    break;
                case 6:
                    System.out.println("Calculating the Inverse of a Matrix");
                    Calculations.inverseOfMatrix(reader);
                    break;
                default:
                    System.out.println("Unrecognised input, please try again");
            }
        }
    }

    public static int transposeSelection(Scanner reader) {
        String[] subMenuOptions = {
                "Main diagonal",
                "Side diagonal",
                "Vertical line",
                "Horizontal line"
        };
        String title = "\tMatrix Calculator\n";
        System.out.print("\t");
        for (int i = 0; i < title.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.print(title);
        System.out.println("\tTransposition Menu");
        System.out.print("\t");
        for (int i = 0; i < title.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 1; i < subMenuOptions.length; i++) {
            System.out.print("\t" + i + ". " + subMenuOptions[i - 1] + "\n");
        }
        System.out.println();
        System.out.print("--> ");
        return reader.nextInt();
    }

    public static void printMenu() {
        String title = "\tMatrix Calculator\n";
        String mainMenu = "Please select one of the following options:\n";
        String[] menuOptions = {
                "Add Matrices",
                "Scalar Multiplication",
                "Multiply Matrices",
                "Transpose Matrix",
                "Determinant",
                "Inverse Matrix",
        };
        String prompt = "--> ";
        System.out.print("\t");
        for (int i = 0; i < title.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.print(title);
        System.out.println("\tMain Menu");
        System.out.print("\t");
        for (int i = 0; i < title.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println(mainMenu);
        for (int i = 1; i < menuOptions.length; i++) {
            System.out.print("\t" + i + ". " + menuOptions[i - 1] + "\n");
        }
        System.out.println("\t0. Exit");
        System.out.print(prompt);
    }

}


