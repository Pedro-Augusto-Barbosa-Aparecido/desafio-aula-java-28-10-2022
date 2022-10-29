import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Crypto {
    private String phrase;

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Crypto() {
    }

    public void cryptoAndSaveInFile(String filepath) throws IOException {
        File file = new File(filepath);

        if (file.isDirectory() || !file.exists()) {
            throw new IOException("Arquivo nao encontrado");
        }

        String encrypted = "";

        for (int i = 0; i < this.phrase.length(); i++) {
            encrypted = encrypted.concat(String.valueOf((char) ((int) this.phrase.charAt(i) + 3)));
        }

        Files.writeString(Paths.get(filepath), encrypted);

    }

    public String decryptFileContent(String filepath) throws IOException {
        File file = new File(filepath);

        if (file.isDirectory() || !file.exists()) {
            throw new IOException("Arquivo nao encontrado");
        }

        String decrypted = "";
        String encryptedString = Files.readString(Paths.get(filepath));

        for (int i = 0; i < encryptedString.length(); i++) {
            decrypted = decrypted.concat(String.valueOf((char) ((int) encryptedString.charAt(i) - 3)));
        }

        return decrypted;
    }

}
