package encrypt.sha;

import org.junit.jupiter.api.Test;
import util.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DigestTest {

    @Test
    void execute() {
        //given
        String key = "키";
        Digest digest = new SHA256Digest();

        //when
        byte[] sha256 = digest.execute(key);

        //then
        assertThat(sha256.length).isEqualTo(32);    //32byte * 8bit = 256bit
        assertThat(Util.bytesToHex(sha256).length()).isEqualTo(64);
    }
}