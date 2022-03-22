package encrypt.aes;

import encrypt.Encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Base64;

public class AESEncoder implements AESEncrypt {
    @Override
    public String encrypt(Cipher cipher, SecretKey secretKey, IvParameterSpec ivParameterSpec, String str) throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(str.getBytes(Encrypt.CHARSET));   //16byte    128bit
        return new String(Base64.getEncoder().encode(encrypted));
    }
}
