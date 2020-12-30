package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int Add(String inputString) {
		if(inputString.isEmpty()) {
			return 0;
		}
		int sum = 0;
		if(inputString.startsWith("//")) {
			sum  = findDelimiterAndAddNoSeperatedBydelimiter(inputString);
		} else {
			sum = addNumbersSeperatedByGivenDelimiter(inputString, ",|\n");
		}
		return sum;
	}

	private int findDelimiterAndAddNoSeperatedBydelimiter(String inputString) {
		int lineNo =1;
		int sum = 0;

		String [] lines = inputString.split("\n");
		String delimiter = getdelimiter(lines[0]);
		List<String> negativeNos = new ArrayList<String>();
		for(; lineNo <lines.length; lineNo++) {
			sum  += addNumbersSeperatedByGivenDelimiter(lines[lineNo], delimiter,negativeNos);
		}
		if(negativeNos.isEmpty()) {
			return sum;
		} 
		throw new IllegalArgumentException("negatives not allowed:" + String.join(",", negativeNos)) ;
	}
	
	private String getdelimiter(String delimiterToken) {
		String delimiter = "";
		return delimiter + delimiterToken.charAt(2);		
	}

	private int addNumbersSeperatedByGivenDelimiter(String delimeterSeperatedNumbers, String delimeter, List<String> negativeNos) {
		int sum  = 0;
		String [] tokens = delimeterSeperatedNumbers.split(delimeter);
		for(String token : tokens) { 
			int no = Integer.parseInt(token);
			if(no < 0) {
				System.out.println(no);
				negativeNos.add(token);
			}
			sum = sum+no;
		}
		return sum;

	}
	
	private int addNumbersSeperatedByGivenDelimiter(String delimiterSeperatedNumbers, String delimiter) {
		int sum  = 0;
		String [] tokens = delimiterSeperatedNumbers.split(delimiter);
		List<String> negativeNos = new ArrayList<String>();
		for(String token : tokens) { 
			int no = Integer.parseInt(token);
			if(no <0) {
				negativeNos.add(token);
			}
			sum += no;
		}
		if(negativeNos.isEmpty()) {
			return sum;
		} 
		throw new IllegalArgumentException("negatives not allowed:" + String.join("," , negativeNos)) ;

	}



}

