package com.github.avpyanov.testit.client;

import com.github.avpyanov.testit.client.api.*;
import feign.Feign;
import feign.Retryer;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import okhttp3.Interceptor;

public class TestItApi {

    private final Autotests autotests;
    private final Attachments attachments;
    private final TestRuns testRuns;
    private final WorkItems workItems;
    private final Projects projects;

    public TestItApi(String endpoint, String token) {
        final OkHttpClient client = new OkHttpClient(new okhttp3.OkHttpClient.Builder()
                .addInterceptor(new TestItRequestsInterceptor(token)).build());
        Feign.Builder feinBuilder = Feign.builder()
                .client(client)
                .encoder(new FormEncoder(new GsonEncoder()))
                .decoder(new GsonDecoder())
                .retryer(Retryer.NEVER_RETRY);

        autotests = feinBuilder.target(Autotests.class, endpoint);
        attachments = feinBuilder.target(Attachments.class, endpoint);
        testRuns = feinBuilder.target(TestRuns.class, endpoint);
        workItems = feinBuilder.target(WorkItems.class, endpoint);
        projects = feinBuilder.target(Projects.class, endpoint);
    }

    public TestItApi(String endpoint, Interceptor interceptor) {
        final OkHttpClient client = new OkHttpClient(new okhttp3.OkHttpClient.Builder()
                .addInterceptor(interceptor).build());
        Feign.Builder feinBuilder = Feign.builder()
                .client(client)
                .encoder(new FormEncoder(new GsonEncoder()))
                .decoder(new GsonDecoder())
                .retryer(Retryer.NEVER_RETRY);

        autotests = feinBuilder.target(Autotests.class, endpoint);
        attachments = feinBuilder.target(Attachments.class, endpoint);
        testRuns = feinBuilder.target(TestRuns.class, endpoint);
        workItems = feinBuilder.target(WorkItems.class, endpoint);
        projects = feinBuilder.target(Projects.class, endpoint);
    }

    public Autotests getAutotestsClient() {
        return autotests;
    }

    public Attachments getAttachmentsClient() {
        return attachments;
    }

    public TestRuns getTestRunsClient() {
        return testRuns;
    }

    public WorkItems getWorkItemsClient() {
        return workItems;
    }

    public Projects getProjectsClient() {
        return projects;
    }
}