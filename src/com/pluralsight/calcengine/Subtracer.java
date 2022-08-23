package com.pluralsight.calcengine;

public class Subtracer extends CalculateBase {
	
	public Subtracer() {}
	
	public Subtracer(double leftVal, double rightVal) {
		super(leftVal, rightVal);
		//Chama o construtor de CalculateBase que aceita 2 parametros
	}
	
	@Override
	public void calculate() {
		double value = getLeftVal() - getRightVal();
		setResult(value);
	}
}
