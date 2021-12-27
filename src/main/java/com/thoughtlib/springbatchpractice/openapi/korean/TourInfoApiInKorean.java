package com.thoughtlib.springbatchpractice.openapi.korean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoApiSearchDto;
import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Service
public class TourInfoApiInKorean {

    private final static String URL_AREA_CODE = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode";
    private final static String URL_AREA_BASE_LIST = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList";

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

    private URI createUrI(TourInfoApiSearchDto search) throws IOException, URISyntaxException {

        StringBuilder urlBuilder = new StringBuilder(URL_AREA_BASE_LIST);
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + apiKey + "&_type=json");
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(search.getPageNo().toString(), "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(search.getNumOfRows().toString(), "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + "ETC");
//        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("cat1","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("32", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("cat2","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("cat3","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8"));

        URI uri = new URI(urlBuilder.toString());

        return uri;

    }

    public List<TourInfoResponseDto.Item> getTourInfo(TourInfoApiSearchDto search) throws IOException, URISyntaxException {

        HttpEntity httpEntity = getHttpEntity();
        URI uri = createUrI(search);

        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper objectMapper = new ObjectMapper();

        ResponseEntity<TourInfoResponseDto> result = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, TourInfoResponseDto.class);

        return result.getBody().getItemList();
    }
}
