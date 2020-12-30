package calculator;

public class StringCalculator {
	
	public int Add(String inputString) {
		if(inputString == "") {
			return 0 ;
		}
		String[] nos = inputString.split(",");
		int sum = 0;
		for(String no : nos ) {
			sum += Integer.parseInt(no);
		}
		return sum;
	}
	

}

