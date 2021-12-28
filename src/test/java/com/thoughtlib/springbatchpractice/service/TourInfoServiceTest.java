package com.thoughtlib.springbatchpractice.service;


import com.thoughtlib.springbatchpractice.entity.TourInfo;
import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoApiSearchDto;
import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoResponseDto;
import com.thoughtlib.springbatchpractice.openapi.korean.TourInfoApiInKorean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@SpringBootTest
public class TourInfoServiceTest {

    @Autowired
    TourInfoApiInKorean tourInfoApiInKorean;

    @Autowired
    TourInfoService tourInfoService;

    @Test
    public void saveTest() throws IOException, URISyntaxException {
        TourInfoApiSearchDto search = new TourInfoApiSearchDto();

        search.setNumOfRows(10);
        search.setPageNo(1);

        List<TourInfoResponseDto.Item> itemList = tourInfoApiInKorean.getItemList(search);

        TourInfo tourInfo = itemList.get(0).createTourInfo();

        tourInfoService.save(tourInfo);

    }

}
