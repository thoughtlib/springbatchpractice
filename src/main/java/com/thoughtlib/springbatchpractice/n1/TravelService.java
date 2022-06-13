package com.thoughtlib.springbatchpractice.n1;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TravelService {

    TravelRepository travelRepository;

    @Transactional
    public void insert(Travel travel) {
        travelRepository.save(travel);
    }
}
