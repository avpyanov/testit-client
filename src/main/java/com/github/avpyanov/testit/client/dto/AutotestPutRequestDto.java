package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AutotestPutRequestDto {

    private String id;
    private String externalId;
    private String globalId;
    private String projectId;
    private String name;
    private String namespace;
    private String classname;
    private String title;
    private String description;
    private List<AutotestStep> steps;
    private List<AutotestStep> setup;
    private List<AutotestStep> teardown;
    private List<Link> links;
    private List<UUID> workItemIdsForLinkWithAutoTest;
    private boolean isFlaky;
}