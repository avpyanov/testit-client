package com.github.avpyanov.testit.client.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TestResult {

    private Configuration configuration;
    private List<String> failureReasonNames;
    private AutotestDto autoTest;
    private String id;
    private String configurationId;
    private String testRunId;
    private String outcome;
    private String comment;
    private List<Link> links;
    private List<Attachment> attachments;
    private Map<String, String> parameters;
    private Map<String, String>  properties;

}
