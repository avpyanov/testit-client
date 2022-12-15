package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SharedStep {

    private UUID versionId;
    private String globalId;
    private String name;
    private List<WorkItemStep> steps;

}