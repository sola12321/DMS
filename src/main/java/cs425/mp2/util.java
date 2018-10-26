package cs425.mp2;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class util {

    public static String getHostnameFromIp(String ip) throws UnknownHostException {
        return InetAddress.getByName(ip).getHostName();
    }

    public static String getIpFromHostname(String host) throws UnknownHostException {
        return InetAddress.getByName(host).getHostAddress();
    }

    public static String getCurrentHostname() throws UnknownHostException {
        return InetAddress.getLocalHost().getCanonicalHostName();
    }

    public static String ungzip(byte[] bytes) throws Exception {
        InputStreamReader isr = new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bytes)), StandardCharsets.UTF_8);
        StringWriter sw = new StringWriter();
        char[] chars = new char[1024];
        for (int len; (len = isr.read(chars)) > 0; ) {
            sw.write(chars, 0, len);
        }
        return sw.toString();
    }

    public static byte[] gzip(String s) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        OutputStreamWriter osw = new OutputStreamWriter(gzip, StandardCharsets.UTF_8);
        osw.write(s);
        osw.close();
        return bos.toByteArray();
    }

}
