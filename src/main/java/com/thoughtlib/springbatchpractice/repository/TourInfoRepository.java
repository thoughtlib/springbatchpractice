package com.thoughtlib.springbatchpractice.repository;

import com.thoughtlib.springbatchpractice.entity.TourInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourInfoRepository extends JpaRepository<TourInfo, String> {

}
