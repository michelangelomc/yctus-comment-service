package br.com.yctus.api.comment.service.domain.entities.response;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class CommentServiceResponse {
    private String id;
    private String commentDescription;
    private String author;
    private OffsetDateTime createdAt;
}
