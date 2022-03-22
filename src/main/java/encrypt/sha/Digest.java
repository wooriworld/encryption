package encrypt.sha;

import encrypt.Encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Digest extends Encrypt {
    MessageDigest getMessageDigest() throws NoSuchAlgorithmException;

    default byte[] execute(String key) {
        byte[] digest = null;
        try {
            MessageDigest md = getMessageDigest();
            md.update(key.getBytes(Encrypt.CHARSET));
            digest = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest;
    }
}
