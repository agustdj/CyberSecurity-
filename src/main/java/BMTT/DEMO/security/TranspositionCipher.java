package BMTT.DEMO.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TranspositionCipher {

    public static String decrypt(String ciphertext, int key) {
        int numCols = (int) Math.ceil((double) ciphertext.length() / key);
        char[] plaintext = new char[ciphertext.length()];

        int index = 0;
        for (int i = 0; i < numCols; i++) {
            for (int j = i; j < ciphertext.length(); j += numCols) {
                plaintext[j] = ciphertext.charAt(index++);
            }
        }
        return new String(plaintext);
    }

    public static String base64ToString(String base64) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}