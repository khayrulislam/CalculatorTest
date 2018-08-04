package CalculatorTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Calculator.SerialCalculation;

public class SerialCalculationTest {

	static SerialCalculation cc ;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		cc = new SerialCalculation();

		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReplaceBracket() {
		assertEquals("((a+b*(5+a(a*hu)))+(65464+(646))+46+85)", cc.replaceBracket("[{ a+b *( 5+ a ( a *hu ) ) } + {65464 +( 646 )} + 46+ 85]"));
	}

	@Test
	public void testAddSpaceInEquation() {
		assertEquals(" ( ( a + b * ( 5 + a ( a * hu ) ) ) + ( 65464 + ( 646 ) ) + 46 + 85 ) ", cc.addSpaceInEquation("((a+b*(5+a(a*hu)))+(65464+(646))+46+85)"));
	}

	@Test
	public void testGetPreference() {
		assertEquals(3, cc.getPreference("^"));
	}

	@Test
	public void testIsOperator() {
		assertEquals(1, cc.isOperator("*"));
	}

	@Test
	public void testGeneralOperation() {
		assertEquals(20, cc.generalOperation("+", 10, 10));
	}

	@Test
	public void testTrigonometryOperation() {
		assertEquals(0.5, cc.trigonometryOperation("sin", 30));
	}
	@Test
	public void testConvertEquationToPostfix() {
		
	}

	@Test
	public void testSolveEquation() {
		assertEquals(17470.0, cc.solveEquation("20+28*(5^3-120)^(2+1*2)-50"));
	}

}
