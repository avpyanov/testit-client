package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AutotestDto {

    private UUID id;
    private String globalId;
    private boolean isDeleted;
    private String externalId;
    private String lastTestResultOutcome;
    private List<Link> links;
    private String projectId;
    private String name;
    private String namespace;
    private String classname;
    private List<AutotestStep> steps;
    private List<AutotestStep> setup;
    private List<AutotestStep> teardown;
    private String title;
    private String description;
    private boolean isFlaky;
}