package br.com.yctus.api.comment.service.domain.entities.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModerationRequest {
    private String postId;
    private String comments;
}
