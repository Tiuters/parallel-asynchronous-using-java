package com.learnjava.parallelStream;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.learnjava.util.CommonUtil.*;

import static org.junit.jupiter.api.Assertions.*;


class ParallelStreamExampleTest {

    ParallelStreamExample parallelStreamExample = new ParallelStreamExample();

    @Test
    void stringTransform() {

        //given
        List<String> list = DataSet.namesList();

        //when
        startTimer();
        List<String> resList = parallelStreamExample.stringTransform(list);
        timeTaken();

        //then
        assertEquals(4, resList.size());
        resList.forEach(
                name -> assertTrue(name.contains("-"))
        );
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void stringTransform2(boolean isParallel) {

        //given
        List<String> list = DataSet.namesList();

        //when
        stopWatchReset();
        startTimer();
        List<String> resList = parallelStreamExample.stringTransform2(list, isParallel);
        timeTaken();

        //then
        assertEquals(4, resList.size());
        resList.forEach(
                name -> assertTrue(name.contains("-"))
        );

    }
}