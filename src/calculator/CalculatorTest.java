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
		assertEquals(calculator.Add(""), 0);
	}
	@Test
	public void shouldResturnNumberForNumber() {
		assertEquals(calculator.Add("12"), 12);
	}
	@Test
	public void shouldResturnSumOfNumbersForCommaDelimetedTwoNumbers() {
		assertEquals(calculator.Add("1,5"), 6);
	}
	@Test
	public void shouldResturnSumOfMultipleNumbersDelimetedByComma() {
		assertEquals(calculator.Add("1,5,4"), 10);
	}

	@Test
	public void shouldAcceptNewLineAsValidDelimeter() {
		assertEquals(calculator.Add("1,5,6\n4,5"), 21);
	
	}
	@Test
	public void shouldAcceptCustomDelimeter() {
		assertEquals(calculator.Add("//;\n1;5"), 6);
		assertEquals(calculator.Add("//;\n1;5;6\n4;5"), 21);
		assertEquals(calculator.Add("//%\n1%5"), 6);
	
	}
	@Test
	public void shouldRaiseExceptionOnNegativeNumber() {
		fail("Not yet implemented");
	
	}
	@Test
	public void shouldRaiseExceptionOnMultipleNegativeNumbers() {
		fail("Not yet implemented");
	
	}
	@Test
	public void shouldAcceptDelimeterOfLengthMoreThanOne () {
		fail("Not yet implemented");
	
	}
	@Test
	public void shouldAcceptMultlepleDelimeter() {
		fail("Not yet implemented");
	
	}
	@Test
	public void shouldAcceptMultlepleDelimetersWithMoreThanOneChar() {
		fail("Not yet implemented");
	
	}
}
