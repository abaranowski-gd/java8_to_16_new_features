package com.griddynamics.practical.stringblocks;

import javassist.tools.web.BadHttpRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Log4j2
public class LoggingFilter extends OncePerRequestFilter {
    private static final String LOGGER_MESSAGE = "\n" +
            "====REQUEST LOG====\n" +
            "requestURI: {},\n" +
            "contextPath: {},\n" +
            "remoteAddr: {},\n" +
            "method: {},\n" +
            "contentLength: {},\n" +
            "body: {}\n" +
            "====END REQUEST LOG====\n" +
            "\n";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        logServletRequest(httpServletRequest);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void logServletRequest(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String remoteAddr = request.getRemoteAddr();
        String method = request.getMethod();
        int contentLength = request.getContentLength();
        String body = getBody(request);

        String correctJson = """
                {
                    "name":"John Doe",
                    "id":1
                }""";

        if(!body.equals(correctJson)){
            throw new IllegalArgumentException();
        } else {
            log.info(LOGGER_MESSAGE,
                    requestURI,
                    contextPath,
                    remoteAddr,
                    method,
                    contentLength,
                    body);
        }
    }

    private String getBody(HttpServletRequest request) {
        StringBuilder body = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            int c = reader.read();
            while (c != -1){
                body.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body.toString();
    }

}
