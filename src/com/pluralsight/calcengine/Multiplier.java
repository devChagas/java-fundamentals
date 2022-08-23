package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase{
	
	public Multiplier() {}
	
	public Multiplier(double leftVal, double rightVal) {
		super(leftVal, rightVal);
		//Chama o construtor de CalculateBase que aceita 2 parametros
	}
	
	
	@Override
	public void calculate() {
		double value = getLeftVal() * getRightVal();
		setResult(value);
	}
}
