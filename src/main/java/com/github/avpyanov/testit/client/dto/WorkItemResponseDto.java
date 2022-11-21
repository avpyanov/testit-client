package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class WorkItemResponseDto {

    private UUID id;
    private String name;
    private String entityTypeName;
    private UUID projectId;
    private UUID sectionId;
    private String globalId;
    private Map<String, String> attributes;
    private List<Tag> tags;
}