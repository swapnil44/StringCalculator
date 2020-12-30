package calculator;

public class StringCalculator {
	
	public int add(String inputString) {
		if(inputString == "") {
			return 0 ;
		}
		String[] nos = inputString.split(",");
		if(nos.length ==1) {
			return Integer.parseInt(nos[0]);
		} else {
			return Integer.parseInt(nos[0]) +Integer.parseInt(nos[1]);
			
		}	
	}
	

}
