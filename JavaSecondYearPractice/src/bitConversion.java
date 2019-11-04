
public class bitConversion {
	public static String toBin(int decimal) {
		String result = "";
		int factor = 0;
		while (decimal > 0) {
			if (decimal % 2 == 0) {
				result += "0";
				factor = decimal / 2;

			} else {
				result += "1";
				factor = decimal / 2;
			}
			decimal = factor;
		}
		return revArr(result);
	}

	public static String toHex(int decimal) {
		int div1 = 0;
		int res = 0;
		String result = "";
	
		while (decimal > 0) {
			div1 = decimal / 16;

			res = decimal % 16;
			decimal = div1;
			result += decToHexString(res);
		}
		
		return revArr(result);
	}

	public static String decToHexString(int res) {
		if (res >=0 && res<10) {
			return ""+res;
		}
		if (res == 10) {
			return "A";
		}
		if (res == 11) {
			return "B";
		}
		if (res == 12) {
			return "C";
		}
		if (res == 13) {
			return "D";
		}
		if (res == 14) {
			return "E";
		}
		if (res == 15) {
			return "F";
		}

		return "";
	}
	
	
	public static String revArr(String s) {
		char[] newArr = s.toCharArray();
		char[] finalArr = new char[newArr.length];
		
		for(int i = 0; i < newArr.length;i++) {
			finalArr[i] = newArr[(newArr.length-1) - i];
		}
		
		return new String(finalArr);
	}

	public static void main(String[] args) {
		System.out.println(toBin(7562));
		System.out.println(toHex(7562));
		

	}

}
