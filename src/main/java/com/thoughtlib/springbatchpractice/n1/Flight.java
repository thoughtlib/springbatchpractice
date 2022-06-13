package com.thoughtlib.springbatchpractice.n1;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Entity
@Table(name = "flight")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Flight {

    @Id
    String flightId;

    String flightNo;

    @Builder
    public Flight(String flightNo) {
        this.flightId = UUID.randomUUID().toString();
        this.flightNo = flightNo;
    }

}
