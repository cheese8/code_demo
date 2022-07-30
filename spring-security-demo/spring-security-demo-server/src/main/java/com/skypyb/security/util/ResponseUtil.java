package com.skypyb.security.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class ResponseUtil {
    
    public static void printAndFlush(HttpServletResponse response, String content, String contentType) throws IOException {
        response.setContentType(contentType);
        PrintWriter writer = response.getWriter();
        writer.print(content);
        writer.flush();
        writer.close();
    }
}
