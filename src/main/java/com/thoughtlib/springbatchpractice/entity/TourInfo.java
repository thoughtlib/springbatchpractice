package com.thoughtlib.springbatchpractice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "tour_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class TourInfo {

    @Id
    String tourInfoId;

    String address;

    String addressDetail;

    String areaCode;

    String category1;

    String category2;

    String category3;


}
