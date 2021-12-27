package com.thoughtlib.springbatchpractice.batch.tour;

import com.thoughtlib.springbatchpractice.openapi.dto.TourInfoApiSearchDto;
import com.thoughtlib.springbatchpractice.openapi.korean.TourInfoApiInKorean;
import com.thoughtlib.springbatchpractice.service.TourInfoService;
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

    TourInfoService tourInfoService;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        TourInfoApiSearchDto search = new TourInfoApiSearchDto();
        search.setPageNo(1);
        search.setNumOfRows(10);

        log.info(">>>>> TourInfo importing start");
        tourInfoService.getTourInfoInKorean(search);
        log.info(">>>>> TourInfo importing end");
        return RepeatStatus.FINISHED;
    }
}
