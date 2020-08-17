package com.neuq.ea.common.shiro.utils;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils extends org.springframework.util.StreamUtils {

    /**
     * closeQuietly
     * @param closeable 自动关闭
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }
}