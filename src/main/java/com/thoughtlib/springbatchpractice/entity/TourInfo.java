package com.thoughtlib.springbatchpractice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "tour_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TourInfo {

    @Id
    String tourInfoId;

    String address;

    String addressDetail;

    String areaCode;

    String category1;

    String category2;

    String category3;

    String contentId;

    String contentTypeId;

    LocalDateTime createTime;

    String firstImage;

    String firstImage2;

    BigDecimal mapx;

    BigDecimal mapy;

    String mlevel;

    LocalDateTime modifiedTime;

    Long readCount;

    String sigunguCode;

    String tel;

    String title;

    @Builder
    public TourInfo(String address, String addressDetail, String areaCode, String category1, String category2, String category3, String contentId, String contentTypeId, LocalDateTime createTime, String firstImage, String firstImage2, BigDecimal mapx, BigDecimal mapy, String mlevel, LocalDateTime modifiedTime, Long readCount, String sigunguCode, String tel, String title) {
        this.tourInfoId = UUID.randomUUID().toString();
        this.address = address;
        this.addressDetail = addressDetail;
        this.areaCode = areaCode;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.contentId = contentId;
        this.contentTypeId = contentTypeId;
        this.createTime = createTime;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.mapx = mapx;
        this.mapy = mapy;
        this.mlevel = mlevel;
        this.modifiedTime = modifiedTime;
        this.readCount = readCount;
        this.sigunguCode = sigunguCode;
        this.tel = tel;
        this.title = title;
    }
}
