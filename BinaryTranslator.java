import java.util.ArrayList;
import java.util.Collections;

public class BinaryTranslator {

  
    public String asciiToBinary(String text) {

        ArrayList<String> binaryText = new ArrayList<String>();

        for(char letter : text.toCharArray()) {
            String converted = "";

            int number = (int)letter;

            while (number > 0) {
                converted = (number % 2) + converted;
                number = (int)number / 2;
            }
            binaryText.add(fillString(converted));
        }
        return String.join(" ", binaryText);
    }


    public String binaryToAscii(String BinaryText) {

        ArrayList<String> newText = new ArrayList<String>();

        for(String binaryNum : BinaryText.split(" ")) {
            if (isBinary(binaryNum)) {
                try {
                    int additionDigits = 0;
                    String reversed = reverseString(binaryNum);
                    for (int i = 0; i < reversed.length(); i++) {

                        additionDigits += Integer.parseInt(
                                String.valueOf(reversed.charAt(i))) * ((int)Math.pow(2, i)
                        );
                    }
                    char letter = (char)additionDigits;
                    newText.add(String.valueOf(letter));

                }catch(Exception e) {
                    newText.add(" ");
                }
            } else {
                return "Enter a binary String";
            }
        }
        return String.join("", newText);
    }
  
  
    public boolean isBinary(String binaryText) {
        for (char letter : binaryText.toCharArray()) {
            if (letter != '1' && letter != '0') {
                return false;
            }
        }
        return true;
    }
  
  
    public String reverseString(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--)
           sb.append(text.charAt(i));

        return sb.toString();
    }
  
  
    public String fillString(String binary) {
        return String.join("", Collections.nCopies(8 - binary.length(), "0")) + binary;
    }
}
