package com.exchangerate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    private String url;

    public HttpRequest(String url) {
        this.url = url;
    }

    public HttpResponse send() throws Exception {
        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int statusCode = connection.getResponseCode();
        StringBuilder responseBody = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
        }

        return new HttpResponseImpl(statusCode, responseBody.toString());
    }

    private static class HttpResponseImpl implements HttpResponse {
        private final int statusCode;
        private final String body;

        public HttpResponseImpl(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        @Override
        public int getStatusCode() {
            return statusCode;
        }

        @Override
        public String getBody() {
            return body;
        }
    }
}
