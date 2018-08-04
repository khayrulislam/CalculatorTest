package Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SerialCalculation {
	
	
	private Function func = new Function();
	private char [] operatorArray = { '(',')','+','*','/','-','^' };
	private ArrayList<String> allOperatorList = new ArrayList<String>(Arrays.asList("+","-","*","/","^","sin","cos","tan","asin","acos","atan","exp","log","ln"));
	private ArrayList<String> trigonometryList = new ArrayList<String>(Arrays.asList("sin","cos","tan","asin","acos","atan","exp","log","ln"));
	
	public String replaceBracket(String equation) {

		equation = equation.replace("{", "(");
		equation = equation.replace("[", "(");
		equation = equation.replace("}", ")");
		equation = equation.replace("]", ")");
		equation = equation.replace(" ", "");
		
		if(equation.charAt(0)!= '(')
			equation = "("+ equation + ")";
			
		return equation;
		
	}
	
	public String addSpaceInEquation(String equation) {
		
		for(int j=0;j<operatorArray.length;j++) {
			for(int i=0;i<equation.length();i++) {
				if( operatorArray[j] == equation.charAt(i) ) {
					equation = new StringBuffer(equation).insert(i, " ").toString();
					equation = new StringBuffer(equation).insert(i+2, " ").toString();
					i+=2;	
				}	
			}
		}
		equation = equation.replace("  ", " ");
		return equation;
	}
	
	
	public int getPreference(String operand) {
		
		if(operand.equals("^")) return 3;
		else if(operand.equals("*")  || operand.equals("/")  ) return 2;
		else if(operand.equals("+")  || operand.equals("-")  ) return 1;
		else if(trigonometryList.contains(operand)  ) return 4;
		return -1;
	}
	
	public boolean isOperator(String operator) {
				
		return allOperatorList.contains(operator);
		
	}
	
	public double generalOperation(String operator, double num1, double num2 ) {
		
		double ans = 0;
		
		if(operator.equals("+")) ans = func.add(num1, num2);
		
		else if (operator.equals("-")) ans = func.sub(num1, num2);
		
		else if (operator.equals("*")) ans = func.mul(num1, num2);
		
		else if (operator.equals("/"))  ans = func.div(num1, num2);
		
		else if (operator.equals("^"))  ans = func.pow(num1, num2);
		
		return ans;
	}
	
	public double trigonometryOperation(String operator, double num1) {
		
		double ans = 0;
		
		if(operator.equals("sin")) ans = func.sin(num1);
		
		else if (operator.equals("cos")) ans = func.cos(num1);
		
		else if (operator.equals("tan")) ans = func.tan(num1);
		
		else if (operator.equals("acos")) ans = func.acos(num1);
		
		else if (operator.equals("asin")) ans = func.asin(num1);
		
		else if (operator.equals("atan")) ans = func.atan(num1);
		
		else if (operator.equals("log")) ans = func.log10(num1);
		
		else if (operator.equals("asin")) ans = func.ln(num1);
		
		return ans;
	}
	
	
	
	public double convertEquationToPostfix(String [] equationElement) {
		
		Stack < String > operatorStack = new Stack < String > ();
		Stack < Double > operand = new Stack < Double > ();
		
		String element,current;
		double num1,num2;
		
		for(int i=1;i<equationElement.length;i++) {
			
			element = equationElement[i];
						
			if( element.equals( "(" ) ) 
				operatorStack.push(element);
			
			else if ( element.equals( ")" ) ) {
				
				while(!operatorStack.peek().equals("(") ) {
					current = operatorStack.pop();
					num1 = operand.pop();
					num2 = operand.pop();
					
					operand.push(generalOperation(current, num2, num1));
					
				}
				if( operatorStack.peek().equals("(") ) operatorStack.pop();
				
				
				if( !operatorStack.empty() && trigonometryList.contains(operatorStack.peek())) {
					
					current = operatorStack.pop();
					num1 = operand.pop();
					
					operand.push(trigonometryOperation(current, num1));
					
				}
			}
			
			else if ( isOperator(element) ) {
				
				while( getPreference(element) <= getPreference( operatorStack.peek() )   ) {
					
					current = operatorStack.pop();
					num1 = operand.pop();
					num2 = operand.pop();
					
					operand.push(generalOperation(current, num2, num1));					
				}
				
				operatorStack.push(element);
				
			}
			
			
			else operand.push(Double.parseDouble(element));
			
		}
		
		return operand.pop();
	}
	
	
	public double solveEquation(String equation) {
		
		equation = addSpaceInEquation( replaceBracket(equation) );
		
		
		String [] equationElement = equation.split(" ");
		
		
		//System.out.println(convertEquationToPostfix(equationElement));
		
	
		return convertEquationToPostfix(equationElement);
		
	}

}
