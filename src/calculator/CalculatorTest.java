package calculator;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	@Rule public ExpectedException rule =  ExpectedException.none();
	@Test
	public void shouldRaiseExceptionOnNegativeNumber() {
		rule.expect(IllegalArgumentException.class);
		rule.expectMessage("negatives not allowed:-1");
		calculator.Add("//;\n1;-1");
//		calculator.Add("1\n1,-1,-2");
	}
	@Test
	public void shouldRaiseExceptionOnMultipleNegativeNumbers() {
		rule.expect(IllegalArgumentException.class);
		rule.expectMessage("negatives not allowed:-1,-3,-4");
		calculator.Add("//;\n1;-1;2;-3;-4");
	
	}
	@Test
	public void shouldAcceptDelimeterOfLengthMoreThanOne () {
		assertEquals(calculator.Add("//[**]\n1**5"), 6);
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
