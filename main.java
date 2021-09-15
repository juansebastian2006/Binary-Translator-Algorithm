
public class Main {

    public static void main(String[] args) {
        BinaryTranslator b = new BinaryTranslator();

        String a = "A";
        String converted = b.asciiToBinary(a);
        System.out.println(converted);

        System.out.println(b.binaryToAscii(converted));
    }
}
