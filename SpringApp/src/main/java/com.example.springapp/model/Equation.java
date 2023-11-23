package com.example.springapp.model;

public class Equation {
    private String firstCoefficient;
    private String secondCoefficient;
    private String thirdCoefficient;
    private double A;
    private double B;
    private double C;
    public String getFirstCoefficient() {
        return firstCoefficient;
    }
    public void setFirstCoefficient(String firstCoefficient) {
        this.firstCoefficient = firstCoefficient;
    }
    public String getSecondCoefficient() {
        return secondCoefficient;
    }
    public String getThirdCoefficient() {
        return thirdCoefficient;
    }
    public void setThirdCoefficient(String thirdCoefficient) {
        this.thirdCoefficient = thirdCoefficient;
    }
    public void setSecondCoefficient(String secondCoefficient) {
        this.secondCoefficient = secondCoefficient;
    }

    public void convertInput() throws Exception{
        A = Double.parseDouble(firstCoefficient);
        B = Double.parseDouble(secondCoefficient);
        C = Double.parseDouble(thirdCoefficient);
    }
    public void solveEquation() {
        if(A == 0 && B == 0 && C != 0){
            System.out.println("Incorrect equation");
        }
        else if(A == 0 && B != 0){
            System.out.println("Found one solution: "+(-C/B));
        }
        else if (A != 0){
            solveQuadraticEquation();
        }
        else{
            System.out.println("Equation with all 0 is 0, do you really need to solve that?");
        }
    }
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