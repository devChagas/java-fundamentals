package com.pluralsight.calcengine;

public class MathEquation {
	private double leftVal, rightVal, result;
	private char opCode;
	
	private static int numberOfCalculations;
	private static double sumOfResults;
	
	
	
	//CONSTRUTORES
	public MathEquation() {}
	
	public MathEquation(char opCode) {
		this.opCode = opCode;
	}
	
	public MathEquation(char opCode, double leftVal, double rightVal) {
		this(opCode);
		this.leftVal = leftVal;
		this.rightVal = rightVal;
	}
	
	void execute() {
		switch(opCode) {
		case 'a':
			result = leftVal + rightVal;
			break;
		case 's':
			result = leftVal - rightVal;
			break;
		case 'm':
			result = leftVal * rightVal;
			break;
		case 'd':
			result = rightVal != 0 ? leftVal / rightVal : 0.0d;
			break;
		default:
			System.out.println("opCode Inválido: " + opCode);
			result = 0.0d;
			break;
		}
		
		numberOfCalculations++;
		sumOfResults += result;
	}
	
	public void execute(double leftVal, double rightVal) {
		this.leftVal = leftVal;
		this.rightVal = rightVal;
		
		execute();
	}
	
	public void execute(int leftVal, int rightVal) {
		this.leftVal = leftVal;
		this.rightVal = rightVal;
		execute();
		
		result = (int) result;
	}
	
	public static double getAverageResult() {
		return sumOfResults / numberOfCalculations;
	}
	
	//SETTERs GETTERs
	public double getResult() {return result;}
	public void setResult(double result) {this.result = result;}
	
	public double getLeftVal() {return leftVal;}
	public void setLeftVal(double leftVal) {this.leftVal = leftVal;}
	
	public double getRightVal() {return rightVal;}
	public void setRightVal(double rightVal) {this.rightVal = rightVal;}
	
	public char getOpCode() {return opCode;}
	public void setOpCode(char opCode) {this.opCode = opCode;}
	
		
}
