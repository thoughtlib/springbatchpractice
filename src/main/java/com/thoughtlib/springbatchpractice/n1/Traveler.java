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
@Table(name = "traveler")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Traveler {

    @Id
    String travelerId;

    String name;

    @Builder
    public Traveler(String name) {
        this.travelerId = UUID.randomUUID().toString();
        this.name = name;
    }

}
