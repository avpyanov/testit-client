package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
public class TestPlanResponseDto {

    private UUID id;
    private String globalId;
    private String status;
    private String name;
    private String productName;
    private String description;
    private String build;
    private Date startDate;
    private Date endDate;
    private ArrayList<Tag> tags;
    private Map<String, String> attributes;
    private UUID projectId;
    private boolean isDeleted;
    private boolean hasAutomaticDurationTimer;

}