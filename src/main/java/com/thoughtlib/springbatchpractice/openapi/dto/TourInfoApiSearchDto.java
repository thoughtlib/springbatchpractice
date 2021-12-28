package com.thoughtlib.springbatchpractice.openapi.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.net.URLEncoder;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourInfoApiSearchDto {

    Integer numOfRows;

    Integer pageNo;
}
