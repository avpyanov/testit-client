package com.github.avpyanov.testit.client;

import com.github.avpyanov.testit.client.api.*;
import feign.Feign;
import feign.Retryer;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import okhttp3.Interceptor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class TestItApi {

    private final Autotests autotests;
    private final Attachments attachments;
    private final TestRuns testRuns;
    private final WorkItems workItems;
    private final Projects projects;

    public TestItApi(String endpoint, String token) {
        final OkHttpClient httpClient = getHttpClient(new TestItRequestsInterceptor(token));

        Feign.Builder feinBuilder = Feign.builder()
                .client(httpClient)
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
        final OkHttpClient httpClient = getHttpClient(interceptor);

        Feign.Builder feinBuilder = Feign.builder()
                .client(httpClient)
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

    private OkHttpClient getHttpClient(Interceptor interceptor) {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            return new OkHttpClient(
                    new okhttp3.OkHttpClient.Builder()
                            .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                            .addInterceptor(interceptor).build());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new IllegalStateException("Unable to create http client " + e);
        }
    }
}