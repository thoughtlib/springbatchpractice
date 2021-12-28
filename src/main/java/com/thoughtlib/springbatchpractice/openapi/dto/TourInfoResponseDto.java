package com.thoughtlib.springbatchpractice.openapi.dto;

import com.thoughtlib.springbatchpractice.entity.TourInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourInfoResponseDto {

    Response response;

    @Getter
    @Setter
    public static class Response {
        Header header;
        Body body;
    }

    @Getter
    @Setter
    public static class Header {
        String resultCode;
        String resultMsg;
    }

    @Getter
    @Setter
    public static class Body {
        Items items;
        Long numOfRows;
        Long pageNo;
        Long totalCount;
    }

    @Getter
    @Setter
    public static class Items {
        List<Item> item;
    }

    @Getter
    @Setter
    public static class Item {
        String addr1;
        String addr2;
        String areacode;
        String cat1;
        String cat2;
        String cat3;
        String contentid;
        String contenttypeid;
        String createdtime;
        String firstimage;
        String firstimage2;
        BigDecimal mapx;
        BigDecimal mapy;
        String mlevel;
        String modifiedtime;
        Long readcount;
        String sigungucode;
        String tel;
        String title;

        public TourInfo createTourInfo() {
            TourInfo tourInfo = TourInfo.builder()
                    .address(this.addr1)
                    .addressDetail(this.addr2)
                    .areaCode(this.areacode)
                    .category1(this.cat1)
                    .category2(this.cat2)
                    .category3(this.cat3)
                    .contentId(this.contentid)
                    .contentTypeId(this.contenttypeid)
                    .createTime(LocalDateTime.parse(this.createdtime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                    .firstImage(this.firstimage)
                    .firstImage2(this.firstimage2)
                    .mapx(this.mapx)
                    .mapy(this.mapy)
                    .mlevel(this.mlevel)
                    .modifiedTime(LocalDateTime.parse(this.modifiedtime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                    .readCount(this.readcount)
                    .sigunguCode(this.sigungucode)
                    .tel(this.tel)
                    .title(this.title)
                    .build();

            return tourInfo;
        }
    }

    public List<Item> getItemList() {
        return response.getBody().items.getItem();
    }

}
