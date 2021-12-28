package com.thoughtlib.springbatchpractice.batch.tour;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourInfoConfiguration {

    JobBuilderFactory jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    TourInfoTasklet tourInfoTasklet;

    @Bean
    public Job tourInfoJob() {
        return this.jobBuilderFactory.get("tourInfoJob")
                .start(tourInfoStep())
                .build();
    }

    @Bean
    @JobScope
    public Step tourInfoStep() {
        return this.stepBuilderFactory.get("tourInfoStep")
                .tasklet(tourInfoTasklet)
                .build();
    }

}
