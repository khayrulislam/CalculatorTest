package CalculatorTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Calculator.Function;

public class FunctionTest {

	public static Function f ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
		f = new Function();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		//System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		//System.out.println("tearDown");
	}

	@Test
	public void testAdd() {
		assertEquals(30, f.add(10, 20));
	}

	@Test
	public void testSub() {
		assertEquals(-10, f.sub(10, 20));
	}

	@Test
	public void testMul() {
		assertEquals(100, f.mul(10, 10));
	}

	@Test
	public void testDiv() {
		assertEquals(10, f.div(100, 10));
	}

	@Test
	public void testSquare() {
		assertEquals(100, f.square(10));
	}

	@Test
	public void testCube() {
		assertEquals(1000, f.cube(10));
	}

	@Test
	public void testSqrt() {
		assertEquals(8, f.sqrt(64));
	}

	@Test
	public void testSin() {
		assertEquals(0.5, f.sin(30));
	}

	@Test
	public void testCos() {
		assertEquals(0.5, f.cos(60));
	}

	@Test
	public void testTan() {
		assertEquals(1.732, f.tan(60));
	}

	@Test
	public void testAsin() {
		assertEquals(30, f.asin(0.5));
	}

	@Test
	public void testAcos() {
		assertEquals(60, f.acos(0.5));
	}

	@Test
	public void testAtan() {
		assertEquals(60, f.atan(1.732));
	}

	@Test
	public void testLog10() {
		assertEquals(3, f.log10(1000));
	}

	@Test
	public void testLog2() {
		assertEquals(8, f.log2(256));
	}

	@Test
	public void testExp() {
		assertEquals(148.413, f.exp(5));
	}

	@Test
	public void testLn() {
		assertEquals(3.218, f.ln(25));
	}

	@Test
	public void testPow() {
		assertEquals(625, f.pow(5, 4));
	}

}
