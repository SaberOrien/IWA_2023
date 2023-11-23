package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("This program solves the quadratic equations.");
        System.out.println("Insert coefficients separated by ENTER key.");
        boolean equationToSolve = true;
        double coefficients[] = new double[3];
        Scanner input = new Scanner(System.in);
        while(equationToSolve) {
            try {
                for (int i = 0; i < 3; i++) {
                    coefficients[i] = Double.parseDouble(input.nextLine());
                }
                equationToSolve = false;
            }
            catch(Exception e){
                System.out.println("Coefficients must be numerical. Please insert again.");
            }
        }
        input.close();
        Equation equation = new Equation(coefficients);
        equation.solveEquation();
    }
}