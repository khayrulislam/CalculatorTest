package Calculator;

public class Function {

	
	public double add(double number1,double number2) {
		return number1+number2;
	}
	
	public double sub(double number1,double number2) {
		return number1 - number2;
	}
	
	public double mul(double number1,double number2) {
		return number1*number2;
	}
	
	public double div(double number1, double number2) {
		if(number2>0) return number1/number2;
		return -1;
	}
	
	public double square(double number1) {
		return number1*number1;
	}
	
	public double cube(double number1) {
		return number1*number1*number1;
	}
	
	public double sqrt(double number1) {
		return Math.sqrt(number1);
	}
	
	public double sin(double number1) {
		return Math.sin(Math.toRadians(number1));
	}
	
	public double cos(double number1) {
		return Math.cos(Math.toRadians(number1));
	}
	
	public double tan(double number1) {
		return Math.tan(Math.toRadians(number1));
	}
	
	public double asin(double number1) {
		return Math.toDegrees(Math.asin(number1));
	}
	
	public double acos(double number1) {
		return Math.toDegrees(Math.acos(number1));
	}
	
	public double atan(double number1) {
		return Math.toDegrees(Math.atan(number1));
	}
	
	
	public double log10(double number1) {
		return Math.log10(number1);
	}
	
	public double log2(double number1) {
		return Math.log(number1)/Math.log(2);
	}
	
	public double exp(double number1) {
		return Math.exp(number1);
	}
	
	public double ln(double number) {
		return Math.log(number);
	}
	
	public double pow(double base, double power) {
		return Math.pow(base, power);
	}
	
}
