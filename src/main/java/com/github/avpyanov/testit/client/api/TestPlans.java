package com.github.avpyanov.testit.client.api;

import com.github.avpyanov.testit.client.dto.TestPlanResponseDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface TestPlans {

    @Headers("Content-Type: application/json")
    @RequestLine("GET /api/v2/testPlans/{testPlanId}")
    TestPlanResponseDto getTestPlan(@Param(value = "testPlanId") String testPlanId);
}