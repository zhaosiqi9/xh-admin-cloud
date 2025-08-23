package com.xh.auth.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 00:27
 */
@Slf4j
public class RequestUtil {

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    /**
     * 离线解析ip地址
     */
    public static String getIpRegion2(String ip) {
        if ("0:0:0:0:0:0:0:1".equals(ip)) return null;
        // 1、创建 searcher 对象
        String dbPath = "/ip2region.xdb";
        try (
                InputStream inputStream = new ClassPathResource(dbPath).getInputStream();
                MySearcher searcher = MySearcher.newWithBuffer(FileCopyUtils.copyToByteArray(inputStream))
        ) {
            return searcher.search(ip).replaceAll("\\|", "").replaceAll("0", "");
        } catch (Exception e) {
            log.error("解析ip属地异常", e);
            return "";
        }
    }

    static class MySearcher extends Searcher implements AutoCloseable {
        public MySearcher(String dbFile, byte[] vectorIndex, byte[] cBuff) throws IOException {
            super(dbFile, vectorIndex, cBuff);
        }

        public static MySearcher newWithBuffer(byte[] cBuff) throws IOException {
            return new MySearcher(null, null, cBuff);
        }
    }
}
