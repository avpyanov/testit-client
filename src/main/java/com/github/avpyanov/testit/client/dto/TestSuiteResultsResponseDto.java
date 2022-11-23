package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TestSuiteResultsResponseDto {

    private UUID id;
    private UUID configurationId;
    private UUID testPointId;
    private TestPoint testPoint;
    private UUID testRunId;
    private String outcome;
}