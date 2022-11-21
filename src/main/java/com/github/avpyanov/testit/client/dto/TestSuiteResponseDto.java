package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class TestSuiteResponseDto {

    private UUID id;
    private UUID parentId;
    private UUID testPlanId;
    private String name;
    private ArrayList<TestSuiteResponseDto> children;
}
