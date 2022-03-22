package encrypt.aes;

import encrypt.sha.Digest;
import encrypt.sha.SHA256Digest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AESEncryptTest {

    @Test
    void aesEncoder() {
        //given
        Digest digest = new SHA256Digest();
        byte[] key = digest.execute("키");
        String input = "전문";
        AESEncrypt aesEncrypt = new AESEncoder();

        //when
        String result = aesEncrypt.execute(key, input);

        //then
        assertThat(result.length()).isEqualTo(24);
        System.out.println(result);
    }

    @Test
    void aesDecoder() {
        //given
        Digest digest = new SHA256Digest();
        byte[] key = digest.execute("키");
        String input = "56AGiqH1yuf5KGJNl1ot+Q==";
        AESEncrypt aesEncrypt = new AESDecoder();

        //when
        String result = aesEncrypt.execute(key, input);

        //then
        assertThat(result).isEqualTo("전문");
    }
}