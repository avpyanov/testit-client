package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TestPoint {

    private UUID testSuiteId;
    private UUID id;
    private UUID workItemId;
    private UUID configurationId;
    private String status;
}