package utils;

public class StringUtil {
    public static int getNumberFromString(String str) {
        StringBuilder myNumbers = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                myNumbers.append(str.charAt(i));
            }
        }
        return Integer.parseInt(myNumbers.toString());
    }
}
