import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com uma frase: ");

        Crypto crypto = new Crypto();
        crypto.setPhrase(scanner.nextLine());
        scanner.close();

        try {
            crypto.cryptoAndSaveInFile("text.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.printf("Frase descriptografada: %s", crypto.decryptFileContent("text.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
