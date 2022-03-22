package util;

import encrypt.aes.AESDecoder;
import encrypt.aes.AESEncoder;
import encrypt.aes.AESEncrypt;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EncryptUtilTest {

    @Test
    void encode() {
        //given
        String key = "유니크아이디";
        String input = "전문";
        AESEncrypt aesEncrypt = new AESEncoder();

        //when
        String result = EncryptUtil.aesWithKeyOfSha256(key, input, aesEncrypt);

        //then
        assertThat(result.length()).isEqualTo(24);
        System.out.println(result);
    }

    @Test
    void decode() {
        //given
        String key = "유니크아이디";
        String input = "lF5qU3kaYxc1TUXGFiDqDg==";
        AESEncrypt aesEncrypt = new AESDecoder();

        //when
        String result = EncryptUtil.aesWithKeyOfSha256(key, input, aesEncrypt);

        //then
        assertThat(result).isEqualTo("전문");
        System.out.println(result);
    }
}