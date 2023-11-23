package org.example;
public class Equation{
    private double A;
    private double B;
    private double C;
    public Equation(double[] coefficients){
        A = coefficients[0];
        B = coefficients[1];
        C = coefficients[2];
    }

    public void solveEquation(){
        if(A == 0){
            System.out.println("Found one solution: "+(-C/B));
        }
        else {
            solveQuadraticEquation();
        }
    };

    private void solveQuadraticEquation(){
        double delta = Math.pow(B, 2) - 4*A*C;
        if(delta > 0){
            System.out.println("Found two solutions: \n"+((-B-Math.sqrt(delta))/(2*A)));
            System.out.println((-B+Math.sqrt(delta))/(2*A));
        }
        else if(delta == 0){
            System.out.println("Found one solution: "+(-B/(2*A)));
        }
        else{
            System.out.println("The equation does not have real solutions");
        }
    }
}