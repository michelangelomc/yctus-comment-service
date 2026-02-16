package br.com.yctus.api.comment.service.infraestructure.dataproviders.services;

import br.com.yctus.api.comment.service.domain.entities.request.ModerationRequest;
import br.com.yctus.api.comment.service.domain.entities.response.ModerationResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("api/moderation")
public interface ModerationServices {
    @PostExchange
    ModerationResponse moderationRequest(@RequestBody ModerationRequest request);
}
