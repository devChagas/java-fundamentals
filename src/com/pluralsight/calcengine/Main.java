package com.pluralsight.calcengine;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//performCalculations();
		
		Divider divider = new Divider();
		doCalculation(divider, 100.0d, 50.0d);
		
		Adder adder = new Adder();
		doCalculation(adder, 25.0d, 92.0d);
		
		//performMoreCalculations();
		
		//executeInteractive();
		
		dynamicInteractive();
	}
	
	private static void dynamicInteractive() {
		DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
				new Adder(),
				new Divider(),
				new PowerOf()
		});
		
		System.out.println("Entre com uma operação e dois números: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		
		helper.process(userInput);
		scanner.close();
	}
	
	static void executeInteractive() {
		System.out.println("Entre com uma operação e dois números: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		String[] parts = userInput.split(" ");
		performOperation(parts);
		scanner.close();
	}
	
	
	private static void performOperation(String[] parts) {
		MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
		double leftVal = Double.parseDouble(parts[1]);
		double rightVal = Double.parseDouble(parts[2]);
		CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
		calculation.calculate();
		System.out.println("Operação feita: " + operation);
		System.out.println(calculation.getResult());
	}

	private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
		CalculateBase calculation = null;
		switch(operation) {
			case ADD:
				calculation = new Adder(leftVal, rightVal);
				break;
			case SUBTRACT:
				calculation = new Subtracer(leftVal, rightVal);
				break;
			case MULTIPLY:
				calculation = new Multiplier(leftVal, rightVal);
				break;
			case DIVIDE:
				calculation = new Divider(leftVal, rightVal);
				break;
		}
		
		return calculation;
	}
	
	private static void performMoreCalculations() {
		CalculateBase[] calculations = {
			new Divider(100.0d, 50.0d),
			new Adder(25.0d, 92.0d),
			new Subtracer(225.0d, 17.0d),
			new Multiplier(11.0d, 3.0d)
		};
		System.out.println();
		System.out.println("Cálculos do Vetor");
		
		for(CalculateBase calculation : calculations) {
			calculation.calculate();
			System.out.println("Resultado = " + calculation.getResult());
		}	
	}

	static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
		calculation.setLeftVal(leftVal);
		calculation.setRightVal(rightVal);
		calculation.calculate();
		System.out.println("Resultado do Cálculo = " + calculation.getResult());
	}
	
	static void performCalculations() {
		
		MathEquation[] equations = new MathEquation[4];
		equations[0] = new MathEquation('d', 100.0d, 50.0d);
		equations[1] = new MathEquation('a', 25.0d, 92.0d);
		equations[2] = new MathEquation('s', 225.0d, 17.0d);
		equations[3] = new MathEquation('m', 11.0d, 3.0d);
		
		for(MathEquation equation : equations) {
			
			equation.execute();
			System.out.println("resultado = " + equation.getResult());
		}
		
		System.out.println("Resultado Médio = " + MathEquation.getAverageResult());
		
		System.out.println("Usando overload com método execute");
		
		MathEquation equationOverload = new MathEquation('d');
		double leftDouble = 9.0d;
		double rightDouble = 4.0d;
		
		equationOverload.execute(leftDouble, rightDouble);;
		System.out.println("Resultado Overload com Doubles = " + equationOverload.getResult());
		
		int leftInt = 9;
		int rightInt = 4;
		
		equationOverload.execute(leftInt, rightInt);
		System.out.println("Resultado Overload com Ints = " + equationOverload.getResult());
	}


}