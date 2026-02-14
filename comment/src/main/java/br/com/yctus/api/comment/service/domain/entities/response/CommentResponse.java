package br.com.yctus.api.comment.service.domain.entities.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {
    public String feedback;
    public String error;
}
