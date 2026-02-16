package br.com.yctus.api.comment.service.infraestructure.dataproviders.services.impl;

import br.com.yctus.api.comment.service.domain.entities.request.ModerationRequest;
import br.com.yctus.api.comment.service.domain.entities.response.ModerationResponse;
import br.com.yctus.api.comment.service.infraestructure.dataproviders.services.ModerationServices;
import br.com.yctus.api.comment.service.infraestructure.dataproviders.services.RestClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClient;

@Slf4j
public class ModerationServicesImpl implements ModerationServices {

    private final RestClient restClientApi;

    public ModerationServicesImpl(RestClientFactory restFactory) {
        this.restClientApi = restFactory.moderationServiceClient();
    }

    @Override
    public ModerationResponse moderationRequest(ModerationRequest request) {
        log.info("Request:{}:", request);

        ModerationResponse response = restClientApi
                .post()
                .uri("api/moderation", request)
                .retrieve()
                .body(ModerationResponse.class);

        return response;
    }
}
