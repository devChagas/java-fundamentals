package com.pluralsight.calcengine;

public class Adder extends CalculateBase implements MathProcessing {
	
	public Adder() {}
	
	public Adder(double leftVal, double rightVal) {
		super(leftVal, rightVal);
		//Chama o construtor de CalculateBase que aceita 2 parametros
	}
	
	@Override
	public void calculate() {
		double value = getLeftVal() + getRightVal();
		setResult(value);
	}

	@Override
	public String getKeyWord() {
		return "add";
	}

	@Override
	public double doCalculation(double leftVal, double rightVal) {
		setLeftVal(leftVal);
		setRightVal(rightVal);
		calculate();
		
		return getResult();
	}
	
	
}
