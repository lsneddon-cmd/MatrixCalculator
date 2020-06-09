package com.lsneddon.matrixCalculator;

/**
 * Handles all user interaction with the main menu and sub menu
 */

import java.util.Scanner;

public class Menu {

    private final String[] menuOptions = {
            "Add Matrices",
            "Scalar Multiplication",
            "Multiply Matrices",
            "Transpose Matrix",
            "Determinant",
            "Inverse Matrix",
    };
    private final String[] subMenuOptions = {
            "Main diagonal",
            "Side diagonal",
            "Vertical line",
            "Horizontal line"
    };

    public String getTitle() {
        return "\tMatrix Calculator\n";
    }
    public String getMainSubTitle() {
        return "\tMain Menu\n";
    }
    public String getTranspositionSubTitle() {
        return "\tTransposition Menu\n";
    }
    public String getMainMenu() {
        return "Please select one of the following options:\n";
    }
    public String[] getMenuOptions() {
        return menuOptions;
    }
    public String[] getSubMenuOptions() {
        return subMenuOptions;
    }
    public String getPrompt() {
        return "--> ";
    }

    public int mainMenuSelection(Scanner reader) {

        System.out.print("\t");
        for (int i = 0; i < getTitle().length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.print(getTitle());
        System.out.print(getMainSubTitle());
        System.out.print("\t");
        for (int i = 0; i < getTitle().length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println();
        System.out.println(getMainMenu());
        for (int i = 1; i < getMenuOptions().length; i++) {
            System.out.print("\t" + i + ". " + getMenuOptions()[i - 1] + "\n");
        }
        System.out.println("\t0. Exit");
        System.out.print(getPrompt());
        return reader.nextInt();
    }

    public int transposeMenuSelection(Scanner reader) {
        System.out.print("\t");
        for (int i = 0; i < getTitle().length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.print(getTitle());
        System.out.print(getTranspositionSubTitle());
        System.out.print("\t");
        for (int i = 0; i < getTitle().length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 1; i <= getSubMenuOptions().length; i++) {
            System.out.print("\t" + i + ". " + getSubMenuOptions()[i - 1] + "\n");
        }
        System.out.println();
        System.out.print(getPrompt());
        return reader.nextInt();
    }
}