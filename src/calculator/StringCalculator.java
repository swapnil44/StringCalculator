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

	public String getdelimiter(String delimeterString) {

		if(delimeterString.indexOf('[')<0) {
			return String.valueOf(delimeterString.charAt(2));	
		}

		List<String> delimiters = new ArrayList<>();
		String delimiter = "";
		for (int j = 3; j<delimeterString.length(); j++) {
			char c = delimeterString.charAt(j);
			if(c == '[')  { 
				continue;
			}
			if(c == ']')  {
				delimiters.add(delimiter);
				delimiter = "";
				continue;
			}
			if(c == '*' ) {
				delimiter += "\\*";
			} else {
				delimiter += c;
			}

		}
		String delimeterRegxExpression = String.join("|",delimiters);
		return delimeterRegxExpression;
	}
	private int addNumbersSeperatedByGivenDelimiter(String delimeterSeperatedNumbers, String delimeter, List<String> negativeNos) {
		int sum  = 0;
		String [] tokens = delimeterSeperatedNumbers.split(delimeter);
		for(String token : tokens) { 
			int no = Integer.parseInt(token);
			if(no < 0) {
				negativeNos.add(token);
			}
			if(no >1000) {
				continue;
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
			if(no >1000) {
				continue;
			}
			sum += no;
		}
		if(negativeNos.isEmpty()) {
			return sum;
		} 
		throw new IllegalArgumentException("negatives not allowed:" + String.join("," , negativeNos)) ;

	}



}

