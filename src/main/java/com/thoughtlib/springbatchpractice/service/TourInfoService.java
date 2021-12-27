package com.thoughtlib.springbatchpractice.service;

import com.thoughtlib.springbatchpractice.entity.TourInfo;
import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoApiSearchDto;
import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoResponseDto;
import com.thoughtlib.springbatchpractice.openapi.korean.TourInfoApiInKorean;
import com.thoughtlib.springbatchpractice.repository.TourInfoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourInfoService {

    @Autowired
    TourInfoApiInKorean tourInfoApiInKorean;

    @Autowired
    TourInfoRepository tourInfoRepository;

    @Transactional
    public void getTourInfoInKorean(TourInfoApiSearchDto search ) throws IOException, URISyntaxException {
        List<TourInfoResponseDto.Item> itemList = tourInfoApiInKorean.getTourInfo(search);

        List<TourInfo> tourInfoList = responseToTourInfoList(itemList);

        saveAll(tourInfoList);
    }

    @Transactional
    public void saveAll(List<TourInfo> tourInfoList) {
        tourInfoRepository.saveAll(tourInfoList);
    }

    @Transactional
    public void save(TourInfo tourInfo) {
        tourInfoRepository.save(tourInfo);
    }

    private List<TourInfo> responseToTourInfoList(List<TourInfoResponseDto.Item> itemList) {

        List<TourInfo> tourInfoList = new ArrayList<>();

        for (TourInfoResponseDto.Item item : itemList) {
            TourInfo tourInfo = item.createTourInfo();
            tourInfoList.add(tourInfo);
        }

        return tourInfoList;
    }

}
