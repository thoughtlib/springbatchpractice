package com.thoughtlib.springbatchpractice.batch.tour;

import com.thoughtlib.springbatchpractice.openapi.tour.korean.TourInfoApiInKorean;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourInfoTasklet implements Tasklet {

    TourInfoApiInKorean tourInfoApiInKorean;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info(">>>>> TourInfo importing start");
//        tourInfoApiInKorean.getForTypeReference(null, null);
        log.info(">>>>> TourInfo importing end");
        return null;
    }
}
