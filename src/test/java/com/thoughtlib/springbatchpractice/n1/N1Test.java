package com.thoughtlib.springbatchpractice.n1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class N1Test {

    @Autowired
    TravelService travelService;

    @Autowired
    TravelRepository travelRepository;

    @Test
    @Rollback(value = false)
    public void insert() {
        List<Flight> flightList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Flight flight = Flight.builder()
                    .flightNo("N" + i)
                    .build();

            flightList.add(flight);
        }

        Travel travel = Travel.builder()
                .flightList(flightList)
                .build();

        travelRepository.save(travel);
    }

    @Test
    public void insert5() {
        for (int i = 0; i < 5; i++) {
            insert();
        }
    }

    @Test
    public void search() {
        List<Travel> travelList = travelRepository.findAll();

        log.debug("result : {}", travelList);

    }

}
