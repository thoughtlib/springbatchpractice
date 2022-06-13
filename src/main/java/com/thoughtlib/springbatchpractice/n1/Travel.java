package com.thoughtlib.springbatchpractice.n1;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "travel")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Travel {

    @Id
    String travelId;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "travel_id")
    List<Flight> flightList;

    @Builder
    public Travel(List<Flight> flightList) {
        this.travelId = UUID.randomUUID().toString();
        this.flightList = flightList;
    }
}
