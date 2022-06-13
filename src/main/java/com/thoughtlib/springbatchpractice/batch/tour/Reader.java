package com.thoughtlib.springbatchpractice.batch.tour;

import com.thoughtlib.springbatchpractice.entity.TourInfo;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<TourInfo> {
    @Override
    public TourInfo read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
