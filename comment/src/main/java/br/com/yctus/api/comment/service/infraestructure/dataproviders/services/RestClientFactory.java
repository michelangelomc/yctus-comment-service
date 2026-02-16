package br.com.yctus.api.comment.service.infraestructure.dataproviders.services;

import br.com.yctus.api.comment.service.infraestructure.configurations.web.exception.CommentSeviceClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RestClientFactory {
    private final RestClient.Builder restClientBuilder;
    private static final String URI_MODERATION = "http://localhost:8081/";

    public RestClient moderationServiceClient() {
        return restClientBuilder
                .baseUrl(URI_MODERATION)
                .requestFactory(generateClientHttpRequestFactory())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::isError, (_, response) -> {
                    throw new CommentSeviceClientException("Error calling moderation service: " + response.getStatusCode());
                })
                .build();
    }

    private ClientHttpRequestFactory generateClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(Duration.ofSeconds(5));
        clientHttpRequestFactory.setReadTimeout(Duration.ofSeconds(3));
        return clientHttpRequestFactory;
    }
}
