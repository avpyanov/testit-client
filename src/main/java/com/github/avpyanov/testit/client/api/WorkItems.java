package com.github.avpyanov.testit.client.api;

import com.github.avpyanov.testit.client.dto.AutotestDto;
import com.github.avpyanov.testit.client.dto.WorkItem;
import com.github.avpyanov.testit.client.dto.WorkItemPutDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface WorkItems {

    @RequestLine("GET /api/v2/workItems/{workItemId}/autoTests")
    List<AutotestDto> getLinkedAutotests(@Param("workItemId") String workItemId);

    @RequestLine("DELETE /api/v2/workItems/{workItemId}")
    void deleteWorkItem(@Param("workItemId") String workItemId);

    @RequestLine("GET /api/v2/workItems/{workItemId}")
    WorkItem getWorkItem(@Param("workItemId") String workItemId);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/v2/workItems")
    WorkItem createWorkItem(WorkItem workItem);

    @Headers("Content-Type: application/json")
    @RequestLine("PUT /api/v2/workItems")
    void updateWorkItem(WorkItemPutDto workItem);
}