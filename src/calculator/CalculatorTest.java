package calculator;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
	StringCalculator calculator;

	@Before
    public void init() {
		calculator =  new StringCalculator();
	}

	@Test
	public void shouldResturnZeroForEmptyString() {
		assertEquals(calculator.add(""), 0);
	}
	@Test
	public void shouldResturnNumberForNumber() {
		assertEquals(calculator.add("12"), 12);
	}
	@Test
	public void shouldResturnSumOfNumbersForCommaDelimetedTwoNumbers() {
		assertEquals(calculator.add("1,5"), 6);
	}
	@Test
	public void shouldResturnSumOfMultipleNumbersDelimetedByComma() {
		fail("Not yet implemented");
	}
//
//	@Test
//	public void shouldAcceptNewLineAsValidDelimeter() {
//		fail("Not yet implemented");
//	
//	}
//	@Test
//	public void shouldAcceptCustomDelimeter() {
//		fail("Not yet implemented");
//	
//	}
//	@Test
//	public void shouldRaiseExceptionOnNegativeNumber() {
//		fail("Not yet implemented");
//	
//	}
//	@Test
//	public void shouldRaiseExceptionOnMultipleNegativeNumbers() {
//		fail("Not yet implemented");
//	
//	}
//	@Test
//	public void shouldAcceptDelimeterOfLengthMoreThanOne () {
//		fail("Not yet implemented");
//	
//	}
//	@Test
//	public void shouldAcceptMultlepleDelimeter() {
//		fail("Not yet implemented");
//	
//	}
//	@Test
//	public void shouldAcceptMultlepleDelimetersWithMoreThanOneChar() {
//		fail("Not yet implemented");
//	
//	}
	
}
