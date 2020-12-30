package calculator;

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

		for(; lineNo <lines.length; lineNo++) {
			sum  += addNumbersSeperatedByGivenDelimiter(lines[lineNo], delimiter);
		}
		return sum;

	}
	String getdelimiter(String delimiterToken) {
		String delimiter = "";
		return delimiter + delimiterToken.charAt(2);		
	}



	public int addNumbersSeperatedByGivenDelimiter(String delimiterSeperatedNumbers, String delimiter) {
		int sum  = 0;
		String [] tokens = delimiterSeperatedNumbers.split(delimiter);
		for(String token : tokens) { 
			int no = Integer.parseInt(token);
			sum += no;
		}
		return sum;

	}



}

