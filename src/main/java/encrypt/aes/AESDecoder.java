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

public class AESDecoder implements AESEncrypt {
    @Override
    public String encrypt(Cipher cipher, SecretKey secretKey, IvParameterSpec ivParameterSpec, String str) throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] byteStr = Base64.getDecoder().decode(str.getBytes(Encrypt.CHARSET));
        return new String(cipher.doFinal(byteStr), Encrypt.CHARSET);
    }
}
