package util;

public class Util {
    /**
     * 바이트를 헥스값으로 변환한다.
     * @param bytes     바이트
     * @return          헥스값
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes)
            builder.append(String.format("%02x", b));
        return builder.toString();
    }
}
