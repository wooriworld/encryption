package encrypt.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Digest implements Digest {
    @Override
    public MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256");
    }
}
