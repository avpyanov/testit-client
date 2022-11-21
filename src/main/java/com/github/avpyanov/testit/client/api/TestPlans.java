package com.github.avpyanov.testit.client.api;

import com.github.avpyanov.testit.client.dto.TestPlanResponseDto;
import com.github.avpyanov.testit.client.dto.TestSuiteResponseDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TestPlans {

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testPlans/{testPlanId}")
    TestPlanResponseDto testPlans(@Param(value = "testPlanId") String testPlanId);


    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testPlans/{testPlanId}/testSuites")
    List<TestSuiteResponseDto> testSuites(@Param(value = "testPlanId") String testPlanId);
}