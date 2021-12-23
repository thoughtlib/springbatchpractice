package com.thoughtlib.springbatchpractice.openapi.tour;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public abstract class TourInfoHttpClient {

    public abstract RestTemplate getRestTemplate();

    public abstract HttpHeaders getHttpHeaders();

    public abstract String generateAuthorization();

    public abstract String getBaseUrl();

    protected HttpEntity<String> getHttpEntity() {
        return new HttpEntity<>(getHttpHeaders());
    }

    protected <B> HttpEntity<B> getHttpEntity(B body) {
        HttpHeaders httpHeaders = getHttpHeaders();
        return new HttpEntity<>(body, httpHeaders);
    }

    public <T> ResponseEntity<T> getForTypeReference(String uri, ParameterizedTypeReference<T> responseType) {
        String url = generateURL(uri);
        HttpEntity<String> httpEntity = getHttpEntity();
        return getRestTemplate().exchange(url, HttpMethod.GET, httpEntity, responseType);
    }

    public <T, R> ResponseEntity<T> postForEntity(String uri, R requestBody, Class<T> responseType) {
        String url = generateURL(uri);
        HttpEntity<R> httpEntity = getHttpEntity(requestBody);
        return getRestTemplate().postForEntity(url, httpEntity, responseType);
    }

    private String generateURL(String uri){
        String url = uri.toLowerCase().startsWith("http") ? uri : (getBaseUrl() + uri);
        log.info(url);
        return url;
    }
}
