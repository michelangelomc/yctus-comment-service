package br.com.yctus.api.comment.service.domain.entities.request;

import br.com.yctus.api.comment.service.infraestructure.configurations.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequest {
    @JsonIgnore
    public UUID postId = IdGenerator.generateID();

    public String author;
    public String comments;
}