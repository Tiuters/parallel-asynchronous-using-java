package com.learnjava.parallelStream;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamExample {
    public static void main(String[] args) {

        List<String> namesList = DataSet.namesList();
        ParallelStreamExample parallelStreamExample = new ParallelStreamExample();
        startTimer();
        List<String> resultList = parallelStreamExample.stringTransform(namesList);
        log("resultList: " + resultList);
        timeTaken();
    }

    public List<String> stringTransform(List<String> namesList) {

        return namesList
//                .stream()
                .parallelStream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public List<String> stringTransform2(List<String> namesList, boolean isParallel) {

        Stream<String> stream = namesList.stream();

        if (isParallel) {
            stream.parallel();
        }

        return stream
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    private String addNameLengthTransform(String name) {
        delay(500);
        return name.length() + " - " + name;
    }
}
