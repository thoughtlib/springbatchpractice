package com.thoughtlib.springbatchpractice.openapi.tour.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourInfoDto {

    String resultCode;  //결과코드

    String resultMsg;   //결과메시지

    Long numOfRows;     //한 페이지 결과 수

    Long pageNo;        //페이지 번호

    Long totalCount;    //전체 결과 수

    String code;        //지역코드 또는 시군구코드

    String name;        //지역명 또는 시군구명

    String rnum;        //일련번호

}
