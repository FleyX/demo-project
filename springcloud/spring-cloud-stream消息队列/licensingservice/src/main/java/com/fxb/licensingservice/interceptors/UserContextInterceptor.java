package com.fxb.licensingservice.interceptors;

import com.fxb.licensingservice.Entity.UserContext;
import com.fxb.licensingservice.util.UserContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 类功能简述：用于发起实际http调用前在请求头中加入关联id
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/21 16:43
 */
public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpHeaders headers = httpRequest.getHeaders();
        headers.add(UserContext.ID_HEADER_KEY,UserContextHolder.getContext().id);
        return clientHttpRequestExecution.execute(httpRequest,bytes);
    }
}
