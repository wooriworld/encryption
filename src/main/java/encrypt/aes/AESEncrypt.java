package encrypt.aes;

import encrypt.Encrypt;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public interface AESEncrypt extends Encrypt {
    String encrypt(Cipher cipher, SecretKey secretKey, IvParameterSpec ivParameterSpec, String str) throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException;

    default String execute(byte[] key, String input) {
        byte[] iv = Arrays.copyOf(key, 16); //16byte 128bit
        return execute(input, key, iv);
    }

    default String execute(String str, byte[] key, byte[] iv) {
        String result = null;
        try {
            //Secret Key는 평문을 암호화하는데 사용되며 절때로 외부에 노출되어서는 안됩니다. (암호키)
            SecretKey secretKey = new SecretKeySpec(key, "AES");

            //암호화수행모드 세팅
            //aes는 128bit 의 블록단위로 암호화하는데 이보다 작은 경우 특정값으로 채우는것을패딩
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            //AES는 128비트의 고정된 블록 단위로 암호화를 수행 첫번째 블록은 이전 암호화 블록이 없기 때문에 이를 위해 IV(initialization vector)를 이용합니다.
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            result = encrypt(cipher, secretKey, ivParameterSpec, str);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
