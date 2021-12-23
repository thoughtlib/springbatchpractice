package com.thoughtlib.springbatchpractice.openapi.tour.korean;

import com.thoughtlib.springbatchpractice.openapi.tour.dto.TourInfoApiSearchDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class TourInfoApiInKorean {

    private final static String URL_AREA_CODE = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";

    private final static String apiKey = "TDHSEiCPy9WZMmhzgN4w1IUf26bqbBQbLDlj3EL74%2BzUINStirUIjDN5OQq5lqpjFnik4OwEuxvGFfdg9FCi9A%3D%3D";
    private final static String decodingKey = "TDHSEiCPy9WZMmhzgN4w1IUf26bqbBQbLDlj3EL74+zUINStirUIjDN5OQq5lqpjFnik4OwEuxvGFfdg9FCi9A==";

    private HttpEntity<String> getHttpEntity() {
        return new HttpEntity<>(getHttpHeaders());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
        headers.setContentType(mediaType);
        return headers;
    }

    private URI getParameterInUrl(TourInfoApiSearchDto search) throws IOException, URISyntaxException {

        /*UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_AREA_CODE)
                .queryParam("ServiceKey", apiKey)
                .queryParam("numOfRows", "10")
                .queryParam("pageNo", "1")
                .queryParam("MobileOS", "ETC")
                .queryParam("MobileApp", "AppTest")
                .queryParam("areaCode", "1");*/

        StringBuilder urlBuilder = new StringBuilder(URL_AREA_CODE);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + apiKey);
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(search.getNumOfRows().toString(), "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(search.getPageNo().toString(), "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));

        URI uri = new URI(urlBuilder.toString());

        return uri;

    }

    public ResponseEntity<String> getAreaCode(TourInfoApiSearchDto search) throws IOException, URISyntaxException {

        HttpEntity httpEntity = getHttpEntity();

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                getParameterInUrl(search)
                , HttpMethod.GET
                , httpEntity
                , String.class);
    }
}
