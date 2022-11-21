package com.github.avpyanov.testit.client.api;

import com.github.avpyanov.testit.client.dto.WorkItemResponseDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TestSuites {


    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testSuites/{testSuiteId}/workItems?isDeleted={isDeleted}")
    List<WorkItemResponseDto> workItems(@Param(value = "testSuiteId") String testSuiteId,
                   @Param(value = "isDeleted") boolean isDeleted);

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testSuites/{testSuiteId}/workItems?isDeleted={isDeleted}&Skip={skip}&Take={take}&OrderBy={orderBy}&SearchField={searchField}&SearchValue={searchValue}")
    List<WorkItemResponseDto> workItems(@Param(value = "testSuiteId") String testSuiteId,
                                        @Param(value = "isDeleted") boolean isDeleted,
                                        @Param(value = "skip") Integer skip,
                                        @Param(value = "take") Integer take,
                                        @Param(value = "orderBy") String orderBy,
                                        @Param(value = "searchField") String searchField,
                                        @Param(value = "searchValue") String searchValue);

}
