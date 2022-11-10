package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class WorkItemPutDto {

    private UUID id;
    private UUID sectionId;
    private String name;
    private List<IdDto> attachments;
    private List<IdDto> autoTests;
    private String description;
    private String state;
    private String priority;
    private List<WorkItemStep> steps;
    private List<WorkItemStep> preconditionSteps;
    private List<WorkItemStep> postconditionSteps;
    private Map<String, String> attributes;
    private List<Tag> tags;
    private List<Link> links;
    private Long duration;
}