package util;

import encrypt.aes.AESEncrypt;
import encrypt.sha.Digest;
import encrypt.sha.SHA256Digest;

public class EncryptUtil {
    /**
     * SHA-256 + AES 를 사용한 암복호화
     * @param keyString     AES 암복호화 키
     * @param input         암복호화 대상
     * @param aesEncrypt    AES 인코딩/디코딩 전략
     * @return              암복호화 결과
     */
    public static String aesWithKeyOfSha256(String keyString, String input, AESEncrypt aesEncrypt) {
        Digest digest = new SHA256Digest();

        //key 생성
        byte[] key = digest.execute(keyString);

        //AES 암복호화
        return aesEncrypt.execute(key, input);
    }
}
