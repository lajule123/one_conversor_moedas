package com.exchangerate;

public class HttpClient {
    public static String get(String url) throws Exception {
        HttpRequest request = new HttpRequest(url);
        HttpResponse response = request.send();

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusCode());
        }

        return response.getBody();
    }
}
