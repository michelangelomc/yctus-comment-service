package br.com.yctus.api.comment.service.domain.entities.request;

import br.com.yctus.api.comment.service.infraestructure.configurations.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.tsid.TSID;
import lombok.Data;

@Data
public class CommentRequest {
    @JsonIgnore
    public TSID postId = IdGenerator.generateId();

    public String author;
    public String content;
}